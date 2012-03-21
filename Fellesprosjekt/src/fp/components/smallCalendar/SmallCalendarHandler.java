package fp.components.smallCalendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fp.componentHandlers.AbstractComponentHandler;
import fp.componentHandlers.ComponentHandlerType;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventType;
import fp.views.CalendarView;
import fp.views.SmallCalendarPanel;

public class SmallCalendarHandler extends AbstractComponentHandler implements ActionListener, ListSelectionListener {

	private SmallCalendarController smallCalendarController;

	public SmallCalendarHandler(EventDispatcher eventDispatcher, SmallCalendarController smallCalendarController) {
		super(ComponentHandlerType.CALENDAR_VIEW_SMALL_CALENDAR, eventDispatcher);
		this.smallCalendarController = smallCalendarController;
		this.addEventListeners();
	}

	private void addEventListeners() {
		SmallCalendarPanel.prevMonthButton.addActionListener(this);
		SmallCalendarPanel.nextMonthButton.addActionListener(this);
		SmallCalendarPanel.calendarTable.getSelectionModel().addListSelectionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == SmallCalendarPanel.nextMonthButton) {
			this.smallCalendarController.nextMonth();
		} else if(event.getSource() == SmallCalendarPanel.prevMonthButton) {
			this.smallCalendarController.previousMonth();
		}
	}

	public void valueChanged(ListSelectionEvent event) {
		DefaultListSelectionModel model = (DefaultListSelectionModel)event.getSource();
		if(model.getLeadSelectionIndex() != -1) {
			int oldSelectedWeek = this.smallCalendarController.getCurrentWeekNumber();
			this.smallCalendarController.updateSelectedWeek();
			int newSelectedWeek = this.smallCalendarController.getCurrentWeekNumber();
			if(oldSelectedWeek != newSelectedWeek) {
				this.eventDispatcher.dispatchEvent(new Event<Integer>(EventType.SELECTED_WEEK_CHANGED, new Integer(newSelectedWeek)));
			}
		}
	}
	
}
