package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.ServerUserData;
import fp.messageParsers.Message;

public interface MessageHandler {
	
	public void handleMessage(Message message, ServerUserData userData) throws SQLException;
		
}

