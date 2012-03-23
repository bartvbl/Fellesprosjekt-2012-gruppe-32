package fp.events;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentEventDispatcher {
	private ConcurrentHashMap<EventType, CopyOnWriteArrayList<Object>> listeners = new ConcurrentHashMap<EventType, CopyOnWriteArrayList<Object>>();
	private ConcurrentHashMap<Object, AtomicReference<ArrayList<ServerEvent<?>>>> dispatchedEventCue = new ConcurrentHashMap<Object, AtomicReference<ArrayList<ServerEvent<?>>>>();
	
	public ConcurrentEventDispatcher()
	{
		
	}
	public synchronized void addEventListener(EventType type, Object Object)
	{
		listeners.putIfAbsent(type, new CopyOnWriteArrayList<Object>());
		CopyOnWriteArrayList<Object> list = this.listeners.get(type);
		synchronized(list)
		{
			list.add(Object);
		}
	}
	public synchronized void removeEventListener(EventType type, Object Object)
	{
		if(!this.listeners.containsKey(type))
		{
			System.out.println("ERROR: tried to remove the event listener of type '" + type + "', which is not present in the dispatcher");
			return;
		}
		CopyOnWriteArrayList<Object> list = this.listeners.get(type);
		synchronized(list)
		{
			list.remove(Object);
		}
	}
	public synchronized void dispatchEvent(ServerEvent<?> event)
	{
		CopyOnWriteArrayList<Object> listeners = this.listeners.get(event.eventType);
		AtomicReference<ArrayList<ServerEvent<?>>> eventCueReference;
		ArrayList<ServerEvent<?>> eventCue;
		for(Object Object : listeners)
		{
			eventCueReference = this.dispatchedEventCue.get(Object);
			eventCue = eventCueReference.get();
			synchronized(eventCue)
			{
				eventCue.add(event);
			}
		}
	}
	public synchronized ArrayList<ServerEvent<?>> getEventsByListenerObject(Object listener)
	{
		AtomicReference<ArrayList<ServerEvent<?>>> eventCueReference = this.dispatchedEventCue.get(listener);
		ArrayList<ServerEvent<?>> emptyList = new ArrayList<ServerEvent<?>>();
		ArrayList<ServerEvent<?>> returnedEventCue = eventCueReference.getAndSet(emptyList);
		return returnedEventCue;
	}
	
}
