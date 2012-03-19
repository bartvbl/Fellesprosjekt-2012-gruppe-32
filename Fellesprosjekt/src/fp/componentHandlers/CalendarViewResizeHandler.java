package fp.componentHandlers;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.views.CalendarView;

public class CalendarViewResizeHandler extends AbstractComponentHandler implements ComponentListener {

	private EventDispatcher eventDispatcher;

	public CalendarViewResizeHandler(EventDispatcher eventDispatcher) {
		super(ComponentHandlerType.CALENDAR_VIEW_WINDOW_RESIZE);
		this.eventDispatcher = eventDispatcher;
		this.addEventListeners();
	}

	private void addEventListeners() {
		JFrame frame = CalendarView.getJFrame();
		frame.addComponentListener(this);
	}

	public void componentResized(ComponentEvent arg0) {
		this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.WINDOW_RESIZED));
	}

	public void componentHidden(ComponentEvent arg0) {}
	public void componentMoved(ComponentEvent arg0) {}
	public void componentShown(ComponentEvent arg0) {}
}
