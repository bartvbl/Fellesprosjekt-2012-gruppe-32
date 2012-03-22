package fp.events;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;


public class ConcurrentEventDispatcher {
	private ConcurrentHashMap<EventType, CopyOnWriteArrayList<Object>> listeners = new ConcurrentHashMap<EventType, CopyOnWriteArrayList<Object>>();
	private ConcurrentHashMap<Object, AtomicReference<ArrayList<Event<?>>>> dispatchedEventCue = new ConcurrentHashMap<Object, AtomicReference<ArrayList<Event<?>>>>();
	
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
	public synchronized void removeEventListener(String type, Object Object)
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
	public synchronized void dispatchEvent(Event<?> event)
	{
		CopyOnWriteArrayList<Object> listeners = this.listeners.get(event.eventType);
		AtomicReference<ArrayList<Event<?>>> eventCueReference;
		ArrayList<Event<?>> eventCue;
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
	public synchronized ArrayList<Event<?>> getEventsByListenerObject(Object listener)
	{
		AtomicReference<ArrayList<Event<?>>> eventCueReference = this.dispatchedEventCue.get(listener);
		ArrayList<Event<?>> emptyList = new ArrayList<Event<?>>();
		ArrayList<Event<?>> returnedEventCue = eventCueReference.getAndSet(emptyList);
		return returnedEventCue;
	}
	
}
