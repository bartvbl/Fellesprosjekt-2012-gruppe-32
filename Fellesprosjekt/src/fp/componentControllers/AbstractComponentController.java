package fp.componentControllers;

import fp.events.EventDispatcher;

public class AbstractComponentController {
	protected final ComponentControllerType controllerType;
	protected final EventDispatcher eventDispatcher;
	
	public AbstractComponentController(ComponentControllerType controllerType, EventDispatcher eventDispatcher) {
		this.controllerType = controllerType;
		this.eventDispatcher = eventDispatcher;
	}
}
