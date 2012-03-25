package fp.messageParsers.client;

import fp.messageParsers.Message;
import fp.net.client.ClientConnectionContext;
import fp.util.FeedbackProvider;
import fp.views.LoginScreen;

public class RejectedMessageHandler implements ClientMessageHandler {

	@Override
	public void handleMessage(Message message, ClientConnectionContext context) {
		FeedbackProvider.showLoginFailedMessage();
		LoginScreen.loginButton.setEnabled(true);
	}

}
