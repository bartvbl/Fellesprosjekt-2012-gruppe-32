package fp.messageHandlers.client;

import java.util.ArrayList;

import nu.xom.Element;
import nu.xom.Elements;
import fp.dataObjects.MeetingNotification;
import fp.dataObjects.MeetingRoom;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.messageParsers.Message;
import fp.messageParsers.client.ClientMessageHandler;
import fp.net.client.ClientConnectionContext;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.MeetingRoomConverter;

public class SearchMeetingRoomReturnMessageHandler implements ClientMessageHandler {

	private EventDispatcher eventDispatcher;
	private ArrayList<MeetingRoom> rooms;
	
	public SearchMeetingRoomReturnMessageHandler(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
	}
	
	@Override
	public void handleMessage(Message message, ClientConnectionContext context) {
		rooms = new ArrayList<MeetingRoom>();
		Element data = message.getDataElements().get(0);
		int size = data.getChildElements().size();
		for (int i = 0; i < size; i++) {
			rooms.add(MeetingRoomConverter.convertXMLToMeetingRoom((Element) data.getChild(i)));
			System.out.println(rooms.get(i).name);
		}
		eventDispatcher.dispatchEvent(new Event<ArrayList<MeetingRoom>>(EventType.SEARCH_MEETINGROOM_RESULT, rooms));
	}
}
