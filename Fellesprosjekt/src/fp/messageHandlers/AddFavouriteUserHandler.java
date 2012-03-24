package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.server.ServerClientContext;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.UserConverter;

public class AddFavouriteUserHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext) throws SQLException {
		
		User user = UserConverter.convertXMLToUser(message.getDataElements().get(0));
		String sqlQurey = "INSERT INTO UserFavourites VALUES('"+ clientContext.user.userID+ "' , 'user', '" + user.userID + "', NULL);";
		DatabaseConnection.executeWriteQuery(sqlQurey);
	
	}
	
}
