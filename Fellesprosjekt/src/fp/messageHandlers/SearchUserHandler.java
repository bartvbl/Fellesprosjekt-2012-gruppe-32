package fp.messageHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nu.xom.Element;
import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.server.ServerClientContext;
import fp.xmlConverters.UserConverter;
import fp.xmlConverters.XMLWriter;

public class SearchUserHandler implements MessageHandler{

	@Override
	public void handleMessage(Message message, ServerClientContext clientContext)
			throws SQLException {
		ArrayList<Element> elements = message.getDataElements();
		String searchString = "";
		for (Element e : elements) {
			searchString = e.getValue();
		}
		try{
			Message m = searchUsers(searchString);			
			clientContext.connectionHandler.sendMessage(m);
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("no message was returned");
		}
	}
	
	
	public Message searchUsers(String name) throws SQLException{

		int userID = 0;
		String userName = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		String phoneNumber = null;
		
		Message message = new Message(MessageType.searchUser);
		
		String query = "SELECT * from User WHERE FirstName LIKE '" + name + "%' OR LastName LIKE '" + name + "%';";
		ResultSet rs = DatabaseConnection.executeReadQuery(query);
		while(rs.next()){
			userID = rs.getInt("UserID");
			userName = rs.getString("UserName");
			password = rs.getString("Password");
			firstName = rs.getString("FirstName");
			lastName = rs.getString("LastName");
			email = rs.getString("Email");
			phoneNumber = rs.getString("PhoneNumber");
			User user = new User(userID, userName, password, firstName, lastName, email, phoneNumber);
			Element element = UserConverter.convertUserToXML(user);
			
			message.addDataElement(element);
		}
		return message;
	}

}
