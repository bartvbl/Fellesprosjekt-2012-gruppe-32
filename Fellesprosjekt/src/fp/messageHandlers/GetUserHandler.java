
package fp.messageHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import nu.xom.Element;

import fp.dataObjects.ServerUserData;
import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.xmlConverters.UserConverter;

public class GetUserHandler implements MessageHandler{
	
	@Override
	public void handleMessage(Message message, ServerUserData userData) throws SQLException {
		User user = UserConverter.convertXMLToUser(message.getData());
		String query;
		ResultSet rs;
		Element data;
		int userID = 0;
		String userName = user.userName;
		String password = null;
		String firstName = null;
		String lastName = null;
		String email = null;
		String phoneNumber = null;
		query = "SELECT * FROM USER WHERE UserName="+user.userName;
		rs = DatabaseConnection.executeReadQuery(query);
		while(rs.next()){
			userID = rs.getInt("UserID");
			userName = rs.getString("UserName");
			password = rs.getString("Password");
			firstName = rs.getString("FirstName");
			lastName = rs.getString("LastName");
			email = rs.getString("Email");
			phoneNumber = rs.getString("PhoneNumber");
		}
		user = new User(userID, userName, password, firstName, lastName, email, phoneNumber);
		data = UserConverter.convertUserToXML(user);
	}
	
}
