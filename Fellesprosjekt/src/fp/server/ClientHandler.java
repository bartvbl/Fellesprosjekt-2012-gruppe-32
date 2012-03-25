package fp.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import fp.events.ConcurrentEventDispatcher;
import fp.events.Event;
import fp.events.EventType;
import fp.events.ServerEvent;
import fp.messageParsers.Message;
import fp.messageParsers.server.MessageParser;
import fp.net.ConnectionHandler;
import fp.packetBuilders.InitialHandshakePacketBuilder;
import fp.server.events.EventParser;
import fp.util.RandomStringGenerator;

public class ClientHandler implements Runnable {
	private ServerMain main;
	private boolean shutdownRequested = false;
	private boolean isRunning = true;
	private ConnectionHandler connectionHandler;
	private ServerClientContext clientContext;
	private ConcurrentEventDispatcher eventDispatcher;
	private static final int FREQUENCY = 10;
	private static final int HANDSHAKE_TIMEOUT = 3600000;

	public ClientHandler(ServerMain main, Socket clientSocket, ConcurrentEventDispatcher eventDispatcher)
	{
		this.main = main;
		this.eventDispatcher = eventDispatcher;
		this.connectionHandler = new ConnectionHandler(clientSocket);
		this.clientContext = new ServerClientContext(connectionHandler);
		this.eventDispatcher.addEventListener(EventType.SERVER_MEETING_REGISTERED, this);
	}

	public void run()
	{
		try {
			String passwordSalt = RandomStringGenerator.generateString();
			Message message = InitialHandshakePacketBuilder.generateInviteMessage(passwordSalt);
			this.clientContext.passwordSalt = passwordSalt;
			this.connectionHandler.sendMessage(message);
			while((isRunning) && (!this.shutdownRequested)) {
				this.handleMessages();
				this.handleEvents();
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

	private void handleEvents() {
		ArrayList<ServerEvent<?>> eventList = this.eventDispatcher.getEventsByListenerObject(this); 
		EventParser.parseEvents(eventList, this.clientContext);
	}

	public void initateShutdown(){
		shutdownRequested = true;
	}
	
	private void sleepThread() {
		try {Thread.sleep(1000/FREQUENCY);} 
		catch (InterruptedException e) {this.main.writeMessageInWindow(e.getMessage());}
	}
}

