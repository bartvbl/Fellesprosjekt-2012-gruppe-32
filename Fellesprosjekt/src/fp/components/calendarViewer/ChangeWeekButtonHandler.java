package fp.components.calendarViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fp.componentHandlers.AbstractComponentHandler;
import fp.componentHandlers.ComponentHandlerType;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.models.DateSelectionModel;
import fp.views.CalendarView;

public class ChangeWeekButtonHandler extends AbstractComponentHandler implements ActionListener{

	
	private DateSelectionModel model;

	public ChangeWeekButtonHandler(EventDispatcher eventDispatcher, DateSelectionModel model) {
		super(ComponentHandlerType.CHANGE_WEEK_BUTTON, eventDispatcher);
		this.addEventListeners();
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == CalendarView.previousMonthButton) {
			this.model.incrementWeek();
			this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.SELECTED_WEEK_CHANGED));
		} else if(event.getSource() == CalendarView.nextMonthButton) {
			this.model.decrementWeek();
			this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.SELECTED_WEEK_CHANGED));
		} else if(event.getSource() == CalendarView.nextMonthButton) {
			this.model.setCalendarToToday();
			this.eventDispatcher.dispatchEvent(new Event<Object>(EventType.SELECTED_WEEK_CHANGED));
		}
	}
	
	private void addEventListeners() {
		CalendarView.previousMonthButton.addActionListener(this);
		CalendarView.nextMonthButton.addActionListener(this);
		CalendarView.todayButton.addActionListener(this);
	}

}
