package fp.messageParsers.client;

import fp.messageParsers.Message;
import fp.net.client.ClientConnectionContext;

public interface ClientMessageHandler {
	public void handleMessage(Message message, ClientConnectionContext context);
}
