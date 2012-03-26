package fp.events;

import fp.server.ServerClientContext;

public interface ServerEventHandler {
	public void handleEvent(ServerEvent<?> event, ServerClientContext context);
}
