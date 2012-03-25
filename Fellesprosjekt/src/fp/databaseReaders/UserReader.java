package fp.databaseReaders;

import java.sql.ResultSet;
import java.sql.SQLException;

import fp.dataObjects.User;

public class UserReader {

	public static User readUserFromResultSet(ResultSet set) throws SQLException {
		return new User(set.getInt("UserID"), set.getString("UserName"), null, set.getString("FirstName"), set.getString("LastName"), set.getString("Email"), set.getString("PhoneNumber"));
	}

}
