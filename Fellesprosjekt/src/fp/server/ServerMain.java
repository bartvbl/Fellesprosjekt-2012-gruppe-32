package fp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fp.database.DatabaseConnection;
import fp.events.ConcurrentEventDispatcher;

public class ServerMain implements Runnable{
	private ServerSocket serverSocket = null;
	private ServerWindow window;
	private ExecutorService threadpool;
	private ArrayList<ClientHandler> handlers;
	private ConcurrentEventDispatcher eventDispatcher;

	public ServerMain()
	{
		this.eventDispatcher = new ConcurrentEventDispatcher();
	}

	public void initialize()
	{
		DatabaseConnection.connect();
		this.window = new ServerWindow(this);
		this.handlers = new ArrayList<ClientHandler>();
		this.threadpool = Executors.newCachedThreadPool();
		try{this.serverSocket = new ServerSocket(ServerConstants.SERVER_PORT);}
		catch(IOException e){e.printStackTrace();}
		this.writeMessageInWindow("listening on port " + ServerConstants.SERVER_PORT);
	}

	public void writeMessageInWindow(String message)
	{
		this.window.writeMessage(message);
	}

	public void run()
	{
		Socket clientSocket = null;
		this.window.writeMessage("server started.");
		while(true){
			try {
				clientSocket = this.serverSocket.accept();
				ClientHandler handler = new ClientHandler(this, clientSocket, eventDispatcher);
				handlers.add(handler);
				this.threadpool.execute(handler);
				this.window.writeMessage("Accepted client from " + handler.toString());
			} catch (IOException e) {
				System.err.println("Accept failed: " + ServerConstants.SERVER_PORT );
				e.printStackTrace();
				if(e.getMessage().equals("Socket is closed")){return;}
			} 
		}
	}

	public synchronized void removeHandler(ClientHandler handler){
		handlers.remove(handler);
		this.window.writeMessage("Closing session from " + handler.toString());
	}

	public void shutdown() {
		threadpool.shutdown();
		for(ClientHandler handler : handlers){
			handler.initateShutdown();
		}
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(handlers.size() > 0){
			try{Thread.sleep(100);}catch(InterruptedException e){}
		}
		System.exit(0);
	}
}
