package fp.components.loginScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fp.net.client.ClientConnectionContext;
import fp.views.LoginScreen;

public class LoginScreenHandler implements ActionListener, KeyListener {
	public LoginScreenHandler() {
		this.addEventListeners();
	}

	private void addEventListeners() {
		LoginScreen.loginButton.addActionListener(this);
		LoginScreen.usernameTextPane.addKeyListener(this);
		LoginScreen.passwordTextPane.addKeyListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		String userName = LoginScreen.usernameTextPane.getText();
		String password = new String(LoginScreen.passwordTextPane.getPassword());
		ClientConnectionContext context = ClientConnectionContext.getInstance();
		LoginRequestSender.sendLoginRequest(userName, password, context.passwordSalt);
	}

	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_TAB) {
			LoginScreen.passwordTextPane.requestFocus();
			event.consume();
		}
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			LoginScreen.loginButton.doClick();
		}
	}
	public void keyTyped(KeyEvent arg0) {}
	public void keyReleased(KeyEvent event) {}

}
