package fp.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.messageParsers.Message;
import fp.messageParsers.MessageParser;
import fp.net.ConnectionHandler;

public class ClientHandler implements Runnable {
	private ServerMain main;
	private boolean shutdownRequested = false;
	private boolean isRunning = true;
	private ConnectionHandler connectionHandler;
	private ServerClientContext clientContext;
	private static final int FREQUENCY = 10;
	private static final int HANDSHAKE_TIMEOUT = 3600000;

	public ClientHandler(ServerMain main, Socket clientSocket)
	{
		this.main = main;
		this.connectionHandler = new ConnectionHandler(clientSocket);
		this.clientContext = new ServerClientContext(connectionHandler);
	}

	public void run()
	{
		try {
			while((isRunning) && (!this.shutdownRequested)) {
				this.handleMessages();
				this.sleepThread();
			}
			main.removeHandler(this);
		} catch (IOException e) {
			this.main.writeMessageInWindow(e.getMessage());
		} catch (SQLException e) {
			this.main.writeMessageInWindow(e.getMessage());
		}
		
	}

	private void handleMessages() throws IOException, SQLException {
		Message message = this.connectionHandler.receiveMessage();
		if(message != null) {
			MessageParser.parseMessage(message, this.clientContext);
		}
	}

	public void initateShutdown(){
		shutdownRequested = true;
	}
	
	private void sleepThread() {
		try {Thread.sleep(1000/FREQUENCY);} 
		catch (InterruptedException e) {this.main.writeMessageInWindow(e.getMessage());}
	}
}

