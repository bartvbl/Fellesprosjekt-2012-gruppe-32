package fp.util;

import javax.swing.JOptionPane;

public class FeedbackProvider {

	private static void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void showUnknownHostMessage() {
		showErrorMessage("Failed to create a connection to calendar server.");
	}

	public static void showLoginFailedMessage() {
		showErrorMessage("Failed to log you in. \nPlease try to enter your password again, and make sure your username is correct.");
	}

}
