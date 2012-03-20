
package fp.messageHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import nu.xom.Element;

import fp.dataObjects.User;
import fp.database.DatabaseConnection;
import fp.messageParsers.Message;
import fp.xmlConverters.UserConverter;

public class GetUserHandler implements MessageHandler{

	private User user;
	private String query;
	private ResultSet rs;
	private Element data;

	private int userID;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	@Override
	public void handleMessage(Message message) throws SQLException {
		user = UserConverter.convertXMLToUser(message.getData());
		query = "SELECT * FROM USER WHERE UserName="+user.userName;
		DatabaseConnection.connect();
		rs = DatabaseConnection.executeReadQuery(query);
		DatabaseConnection.disconnect();
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
