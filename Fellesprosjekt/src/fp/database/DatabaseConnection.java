package fp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	public static final int DEFAULT_TIMEOUT = 3000;
	public static final String DATABASE_CREDENTIALS_CONFIG_FILE_PATH = "config/databaseinfo.cfg";
	private static Connection connection;

	public static void connect() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			DatabaseCredentials credentials = new DatabaseCredentials();
			credentials.loadFromFile(DatabaseConnection.DATABASE_CREDENTIALS_CONFIG_FILE_PATH);
			System.out.println("connecting to database at " + credentials.getURL() + " with user " + credentials.getUsername());
			connection = DriverManager.getConnection(credentials.getURL(), credentials.getUsername(),
					credentials.getPassword());
			System.out.println("The connection was a success!");

		} catch (SQLException e) {
			System.out.println("Connection failed: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Failed during driverinitialization: " + e.getMessage());
		} catch (InstantiationException e) {
			System.out.println("Failed during driverinstantiation (instantiation failed): " + e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println("Failed during driverinstantiation (access denied): " + e.getMessage());
		}
	}

	public static boolean disconnect() {
		if (connection != null && isConnected(DatabaseConnection.DEFAULT_TIMEOUT)) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Failed to close MySQL connection: " + e.getMessage());
				return false;
			}
		}
		return true;
	}

	public static boolean isConnected(int timeoutInMilliseconds) {
		if (connection != null) {
			try {
				return connection.isValid(timeoutInMilliseconds);
			} catch (SQLException e) {
				System.err.println("Something is wrong with the connection: " + e.getMessage());
				return false;
			}
		}
		return false;
	}

	public static ResultSet executeReadQuery(String query) throws SQLException {
		return connection.createStatement().executeQuery(query);
	}

	public static boolean executeWriteQuery(String query) throws SQLException {
		return connection.createStatement().execute(query);
	}

	public static int exectuteWriteQueryAndReturnID(String query) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		int numberOfRowsAffected = statement.executeUpdate();
		if (numberOfRowsAffected == 0) {
			System.err.println("Query Failed (0 rows affected) ");
		}
		ResultSet generatedKey = statement.getGeneratedKeys();
		int id = -1;
		generatedKey.next();
		id = generatedKey.getInt(1);
		return id;
	}
}