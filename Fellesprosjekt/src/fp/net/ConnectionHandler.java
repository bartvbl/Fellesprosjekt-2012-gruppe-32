package fp.net;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.Socket;

import no.ntnu.fp.net.Connection;

public class ConnectionHandler implements Connection {

	public void connect(InetAddress remoteAddress, int remotePort)
			throws IOException, SocketTimeoutException {
	}

	public Connection accept() throws IOException, SocketTimeoutException {
		return null;
	}

	public void send(String msg) throws ConnectException, IOException {
		
	}

	public String receive() throws ConnectException, IOException {
		return null;
	}

	public void close() throws IOException {
		
	}


}
