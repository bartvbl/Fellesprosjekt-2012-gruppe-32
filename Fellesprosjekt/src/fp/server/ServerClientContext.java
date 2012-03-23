package fp.server;

import java.sql.SQLException;
import java.util.HashMap;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.messageParsers.Message;
import fp.messageParsers.MessageParser;
import fp.messageParsers.MessageType;
import fp.net.ConnectionHandler;
import fp.xmlConverters.WeekConverter;


public class ServerClientContext {
	ConnectionHandler connectionHandler;
	User user;
	
	public ServerClientContext(ConnectionHandler connectionHandler, User user){
		this.connectionHandler = connectionHandler;
		this.user = user;
	}
}
