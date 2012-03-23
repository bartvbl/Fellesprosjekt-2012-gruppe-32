package fp.net.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ClientConnectionReceiverWorker implements ActionListener {
	private ClientConnector connector;

	public ClientConnectionReceiverWorker(ClientConnector connector) {
		this.connector = connector;
		Timer timer = new Timer(100, this);
		timer.start(); 
	}

	public void actionPerformed(ActionEvent arg0) {
		this.connector.receive();
	}

}
