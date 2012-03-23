package fp.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import fp.events.ConcurrentEventDispatcher;

public class ClientHandler implements Runnable {
	private Socket clientSocket;
	private BufferedWriter output;
	private BufferedReader input;
	private ServerMain main;
	private boolean shutdownRequested = false;
	private boolean connected;
	private ConcurrentEventDispatcher eventDispatcher;
	/** 
	 * When this task is waiting for a response from client,
	 * it will check again this many times a second.
	 */
	private static final int FREQUENCY = 10;
	private static final int HANDSHAKE_TIMEOUT = 10000;

	public ClientHandler(ServerMain main,Socket clientSocket, ConcurrentEventDispatcher eventDispatcher)
	{
		this.eventDispatcher = eventDispatcher;
		this.clientSocket = clientSocket;
		this.main = main;
		try {
			this.input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			this.output = new BufferedWriter(new PrintWriter(clientSocket.getOutputStream()));
		} catch (IOException e) {
			this.main.writeMessageInWindow(e.getMessage());
		}
	}

	public void run()
	{
		this.connected = true;
		try {
			
			while(connected) {
				if(this.waitForInput()) {
					output.write("I don't understand you!");
					ConnectionUtils.flush(output);
				}
					
			}
			main.removeHandler(this);
		} catch (IOException e) {
			this.main.writeMessageInWindow(e.getMessage());
		}
		
	}

	public void initateShutdown(){
		shutdownRequested = true;
	}
	
	private boolean waitForInput() throws IOException{
		int waits = 0;
		while(!input.ready() && waits < HANDSHAKE_TIMEOUT/(1000/FREQUENCY)){
			waits++;
			try {Thread.sleep(1000/FREQUENCY);} catch (InterruptedException e) {this.main.writeMessageInWindow(e.getMessage());}
		}
		return input.ready();
	}
	
	public String toString(){
		return clientSocket.getRemoteSocketAddress().toString();
	}
}

