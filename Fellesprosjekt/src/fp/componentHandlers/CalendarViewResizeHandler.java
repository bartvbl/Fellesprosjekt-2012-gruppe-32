package fp.componentHandlers;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

import org.dom4j.io.SAXReader;
import org.jdom.Document;

import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.views.CalendarView;

public class CalendarViewResizeHandler extends AbstractComponentHandler {
	public CalendarViewResizeHandler(EventDispatcher eventDispatcher) {
		super(ComponentHandlerType.CALENDAR_VIEW_WINDOW_RESIZE, eventDispatcher);
		this.addEventListeners();
	}

	private void addEventListeners() {
		JFrame frame = CalendarView.getJFrame();
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				resize();
			}
		});
	}

	public void resize() {
		this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.WINDOW_RESIZED));
	}
}
