package fp.util;

import javax.swing.JOptionPane;

public class FeedbackProvider {
	public static void showConnectionFailedMessage(String reason) {
		showError("Connection to server failed. Please check your config file.\nReason: " + reason);
	}
	
	
	
	private static void showError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	private static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
	}
}
