package fp.components.loginScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fp.net.client.ClientConnectionContext;
import fp.views.LoginScreen;

public class LoginScreenHandler implements ActionListener {
	public LoginScreenHandler() {
		this.addEventListeners();
	}

	private void addEventListeners() {
		LoginScreen.loginButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		String userName = LoginScreen.usernameTextPane.getText();
		String password = new String(LoginScreen.passwordTextPane.getPassword());
		ClientConnectionContext context = ClientConnectionContext.getInstance();
		LoginRequestSender.sendLoginRequest(userName, password, context.passwordSalt);
	}
}
