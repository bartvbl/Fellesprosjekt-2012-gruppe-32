package fp.componentControllers;

import javax.swing.JFrame;

import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;
import fp.views.CalendarView;

public class CalendarViewResizeController extends AbstractComponentController implements EventHandler {

	private JFrame mainWindowFrame;
	private static final int vertical_offset = -60;
	private static final int horizontal_offset = -20;

	public CalendarViewResizeController(EventDispatcher eventDispatcher) {
		super(ComponentControllerType.CALENDAR_VIEW_WINDOW_RESIZE, eventDispatcher);
		this.addEventListeners();
		this.mainWindowFrame = CalendarView.getJFrame();
	}

	private void addEventListeners() {
		this.eventDispatcher.addEventListener(this, EventType.WINDOW_RESIZED);
	}

	public void handleEvent(Event<?> event) {
		if(event.eventType == EventType.WINDOW_RESIZED) {
			int width = this.mainWindowFrame.getWidth();
			int height = this.mainWindowFrame.getHeight();
			CalendarView.mainPanel.setBounds(5, 5, width + horizontal_offset, height + vertical_offset);
			this.mainWindowFrame.validate();
		}
	}

}
