package fp.componentHandlers;

public abstract class AbstractComponentHandler {
	protected final ComponentHandlerType componentHandlerType;
	
	public AbstractComponentHandler(ComponentHandlerType componentHandlerType) {
		this.componentHandlerType = componentHandlerType;
	}
}
