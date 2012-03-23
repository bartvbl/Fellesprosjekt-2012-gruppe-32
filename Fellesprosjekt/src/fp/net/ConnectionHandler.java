package fp.net;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.Socket;

import no.ntnu.fp.net.Connection;

public class ConnectionHandler {

	private Socket socket;

	public ConnectionHandler(Socket socket) {
		this.socket = socket;
	}
	
	
}
