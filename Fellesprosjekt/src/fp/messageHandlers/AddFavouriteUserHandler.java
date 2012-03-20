package fp.messageHandlers;

import java.sql.SQLException;

import fp.dataObjects.Meeting;
import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.xmlConverters.MeetingConverter;
import fp.xmlConverters.UserConverter;

public class AddFavouriteUserHandler implements MessageHandler {

	@Override
	public void handleMessage(Message message, ServerUserData userData) throws SQLException {
		
		User user = UserConverter.convertXMLToUser(message.getData());
		String sqlQurey = "INSERT INTO UserFavourites VALUES("+ userData.getUser().userID+ " , 'user', " + user.userID + ", NULL);";
		DatabaseConnection.executeWriteQuery(sqlQurey);
	
	}
	
	
}
