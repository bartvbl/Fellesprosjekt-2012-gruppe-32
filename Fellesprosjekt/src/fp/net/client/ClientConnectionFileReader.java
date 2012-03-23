package fp.net.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ClientConnectionFileReader {
	private static final String source = "config/connection.cfg";
	private String serverHost;
	private int serverPort;

	public ClientConnectionFileReader() {
		this.readConfigFile(source);
	}

	private void readConfigFile(String src) {
		try {
			BufferedReader reader = this.getFileStream(src);
			this.parseConfigurationFile(reader);
		} catch (IOException e) {e.printStackTrace();}
	}

	private void parseConfigurationFile(BufferedReader reader)throws IOException {
		while(reader.ready()) {			
			String line = reader.readLine();
			String[] lineParts = line.split("=");
			if(lineParts[0].equals("serverHost")) {
				this.serverHost = lineParts[1];
			} else if (lineParts[0].equals("serverPort")) {
				this.serverPort = Integer.parseInt(lineParts[1]);
			}
		}
		
	}

	public String getServerHost() {
		return serverHost;
	}

	public int getServerPort() {
		return serverPort;
	}

	private BufferedReader getFileStream(String src)throws FileNotFoundException {
		FileReader fileReader;

		fileReader = new FileReader(src);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		return bufferedReader;

	}
}
