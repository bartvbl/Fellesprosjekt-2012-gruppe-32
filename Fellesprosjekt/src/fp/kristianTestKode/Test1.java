package fp.kristianTestKode;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import nu.xom.Element;
import fp.database.DatabaseConnection;
import fp.messageHandlers.SearchUserHandler;
import fp.messageParsers.Message;
import fp.messageParsers.MessageType;
import fp.net.ConnectionHandler;
import fp.server.ServerClientContext;

public class Test1 {

	private static String mysqlDriver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://mysql.stud.ntnu.no/tronboe_fellesprosjekt";
	private static java.sql.Connection conn;

	private static void initializeDB() throws ClassNotFoundException,
			SQLException {

		Class.forName(mysqlDriver);
		Properties props = new Properties();
		props.setProperty("user", "tronboe_fp");
		props.setProperty("password", "password");

		try {
			conn = DriverManager.getConnection(url, props);
			System.out.println("huasdasdrra");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("lolol");
		}
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		try {
			initializeDB();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Message m = new Message(MessageType.searchUser);
		Element e = new Element("data");
		e.appendChild("br");
		m.addDataElement(e);
		SearchUserHandler suh = new SearchUserHandler();
		


		try {
			DatabaseConnection.connect();
			System.out.println("ferdig");
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

}