package fp.messageHandlers;

import java.sql.SQLException;

import fp.messageParsers.Message;

public interface MessageHandler {
	
	public void handleMessage(Message message) throws SQLException;
		
}

