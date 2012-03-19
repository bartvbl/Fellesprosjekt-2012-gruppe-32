package fp.events;

public interface EventHandler {
	public void handleEvent(Event<?> event);
}
