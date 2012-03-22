package fp.messageHandlers;

import java.sql.SQLException;

import nu.xom.Element;

import fp.dataObjects.ServerUserData;
import fp.messageParsers.Message;

public interface MessageHandler {
	
	public void handleMessage(Message message, ServerUserData userData) throws SQLException;
	
}

