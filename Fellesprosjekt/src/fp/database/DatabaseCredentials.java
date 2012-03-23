package fp.database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseCredentials {
	private static final String URL_TYPE = "URL";
	private static final String USERNAME_TYPE = "USERNAME";
	private static final String PASSWORD_TYPE = "PASSWORD";
	private String url = "jdbc:";// = "jdbc:mysql://mysql.idi.ntnu.no/tronboe_fp";
	private String username;// = "tronboe_fp";
	private String password;// = "password";

	public void loadFromFile(String src) {
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(src));
			while (fileReader.ready()) {
				String read = fileReader.readLine();
				readLine(read);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find the configuration file for the database. "
					+ "Please make sure " + src + " exists: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to read the configuration file: " + e.getMessage());
			e.printStackTrace();
		}

	}

	String getURL() {
		return this.url;
	}

	String getUsername() {
		return this.username;
	}

	String getPassword() {
		return this.password;
	}

	private void readLine(String line) {
		if (!(line == null || this.lineIsComment(line))) {
			String[] typeAndValueStringsArray = line.split(":", 2);
			if (typeAndValueStringsArray.length != 2) {
				System.err
						.println("There is an error in the configuration file in one of the uncommented lines.");
				return;
			}
			typeAndValueStringsArray[0] = typeAndValueStringsArray[0].trim();
			typeAndValueStringsArray[1] = typeAndValueStringsArray[1].trim();
			setValueStringByType(typeAndValueStringsArray[0], typeAndValueStringsArray[1]);
		}
	}

	private void setValueStringByType(String type, String contents) {
		if (type.equals(URL_TYPE)) {
			url += contents;
		} else if (type.equals(USERNAME_TYPE)) {
			username = contents;
		} else if (type.equals(PASSWORD_TYPE)) {
			password = contents;
		}
	}

	private boolean lineIsComment(String line) {
		return (line.charAt(0) == '#');
	}
}