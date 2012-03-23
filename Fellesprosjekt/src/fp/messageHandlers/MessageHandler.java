package fp.messageHandlers;

import java.sql.SQLException;

import fp.messageParsers.Message;
import fp.server.ServerClientContext;

public interface MessageHandler {
	
	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException;
	
}

