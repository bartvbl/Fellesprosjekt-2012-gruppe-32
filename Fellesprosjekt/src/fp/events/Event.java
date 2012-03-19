package fp.events;

public class Event<EventParamsDataType> {
	private final EventParamsDataType eventParameter;
	public final String eventType;

	public Event(String eventType) {
		this.eventType = eventType;
		this.eventParameter = null;
	}

	public Event(String eventType, EventParamsDataType eventParameterObject) {
		this.eventType = eventType;
		this.eventParameter = eventParameterObject;
	}

	public EventParamsDataType getEventParameterObject() {
		return this.eventParameter;
	}

	public boolean hasParameterObject() {
		if (this.eventParameter != null) {
			return true;
		} else {
			return false;
		}
	}
}