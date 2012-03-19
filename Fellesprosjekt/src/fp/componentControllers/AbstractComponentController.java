package fp.componentControllers;

public class AbstractComponentController {
	protected final ComponentControllerType controllerType;
	
	public AbstractComponentController(ComponentControllerType controllerType) {
		this.controllerType = controllerType;
	}
}
