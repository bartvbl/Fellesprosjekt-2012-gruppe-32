package fp.aCodeTestsPackage;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import fp.database.DatabaseConnection;

public class Testing1 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://mysql.idi.ntnu.no/tronboe_fellesprosjekt";
		String user = "tronboe_fp";
		String pw = "password";
		try {
			java.sql.Connection con = DriverManager.getConnection(url,user,pw);
			System.out.println("yay");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
			
		//DatabaseConnection.connect();
	}

	
}
