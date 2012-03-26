package fp.events;

import fp.dataObjects.Meeting;

public class ServerEvent<EventParamsDataType> extends Event {

	public final int destinationUserID;

	public ServerEvent(EventType eventType, int destinationUserID) {
		super(eventType);
		this.destinationUserID = destinationUserID;
	}
	
	public ServerEvent(EventType eventType, EventParamsDataType dataType, int destinationUserID) {
		super(eventType, dataType);
		this.destinationUserID = destinationUserID;
	}

}
