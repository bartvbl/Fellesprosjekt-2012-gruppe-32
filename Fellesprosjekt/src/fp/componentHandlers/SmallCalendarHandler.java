package fp.componentHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fp.events.EventDispatcher;
import fp.views.CalendarView;
import fp.views.SmallCalendarPanel;

public class SmallCalendarHandler extends AbstractComponentHandler implements ActionListener {

	public SmallCalendarHandler(EventDispatcher eventDispatcher) {
		super(ComponentHandlerType.CALENDAR_VIEW_SMALL_CALENDAR);
		this.addEventListeners();
	}

	private void addEventListeners() {
		SmallCalendarPanel.prevMonthButton.addActionListener(this);
		SmallCalendarPanel.nextMonthButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}