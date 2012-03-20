package fp.core;

import fp.server.ServerMain;

public class ServerRunner {
	public static void main(String[] args) {
		ServerMain main = new ServerMain();
		main.initialize();
		Thread server = new Thread(main);
		server.start();
	}
}
