package fp.messageHandlers;

import fp.dataObjects.Meeting;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;

public class addMeetingHandler implements MessageHandler {

	private Meeting meeting;
	
	@Override
	public void handleMessage(Message message) {
		DatabaseConnection.connect();
		
	}
	
	
	

	

}
