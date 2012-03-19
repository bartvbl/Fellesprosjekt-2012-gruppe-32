package fp.componentHandlers;

import fp.events.EventDispatcher;

public abstract class AbstractComponentHandler {
	protected final ComponentHandlerType componentHandlerType;
	protected final EventDispatcher eventDispatcher;
	
	public AbstractComponentHandler(ComponentHandlerType componentHandlerType, EventDispatcher eventDispatcher) {
		this.componentHandlerType = componentHandlerType;
		this.eventDispatcher = eventDispatcher;
	}
}
