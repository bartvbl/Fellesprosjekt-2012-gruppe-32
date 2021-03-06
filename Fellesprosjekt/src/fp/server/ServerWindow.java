package fp.server;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ServerWindow {
	private JFrame jframe;
	private JTextPane outputPane;
	private final ServerMain main;
	
	public ServerWindow(ServerMain main)
	{
		this.main = main;
		this.jframe = new JFrame("Server");
		
		JScrollPane scroller = new JScrollPane();
		JTextPane outputPane = new JTextPane();
		this.outputPane = outputPane;
		outputPane.setEditable(false);
		outputPane.setAutoscrolls(true);
		scroller.setViewportView(outputPane);
		scroller.setAutoscrolls(true);
		this.jframe.setContentPane(scroller);
		this.jframe.pack();
		this.jframe.setSize(300, 300);
		this.jframe.setLocation(200, 200);
		this.jframe.setVisible(true);
		this.outputPane.setText("Calendar server v0.1");
		this.jframe.addWindowListener(new WindowListener() {public void windowOpened(WindowEvent e) {}public void windowIconified(WindowEvent e) {}public void windowDeactivated(WindowEvent e) {}public void windowClosed(WindowEvent e) {}public void windowActivated(WindowEvent e) {}public void windowDeiconified(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				startShutdown();
			}
		});
	}
	
	protected void startShutdown(){
		main.shutdown();
	}
	
	public void writeMessage(String message)
	{
		this.outputPane.setText(this.outputPane.getText() + "\n" + message);
		this.outputPane.setCaretPosition(this.outputPane.getText().length() - 1);
	}
}
