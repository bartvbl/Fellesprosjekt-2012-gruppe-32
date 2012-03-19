package fp.componentHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import fp.componentControllers.SmallCalendarController;
import fp.events.EventDispatcher;
import fp.views.CalendarView;
import fp.views.SmallCalendarPanel;

public class SmallCalendarHandler extends AbstractComponentHandler implements ActionListener {

	private SmallCalendarController smallCalendarController;

	public SmallCalendarHandler(EventDispatcher eventDispatcher, SmallCalendarController smallCalendarController) {
		super(ComponentHandlerType.CALENDAR_VIEW_SMALL_CALENDAR, eventDispatcher);
		this.smallCalendarController = smallCalendarController;
		this.addEventListeners();
	}

	private void addEventListeners() {
		SmallCalendarPanel.prevMonthButton.addActionListener(this);
		SmallCalendarPanel.nextMonthButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == SmallCalendarPanel.nextMonthButton) {
			this.smallCalendarController.nextMonth();
		} else if(event.getSource() == SmallCalendarPanel.prevMonthButton) {
			this.smallCalendarController.previousMonth();
		}
	}
	
}
