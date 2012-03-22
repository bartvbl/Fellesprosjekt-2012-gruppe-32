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
import fp.models.DateSelectionModel;
import fp.models.SmallCalendarModel;
import fp.views.CalendarView;
import fp.views.SmallCalendarPanel;

public class SmallCalendarHandler extends AbstractComponentHandler implements ActionListener, ListSelectionListener {

	private SmallCalendarModel calendarModel;
	private DateSelectionModel dateModel;

	public SmallCalendarHandler(EventDispatcher eventDispatcher, SmallCalendarModel calendarModel, DateSelectionModel dateModel) {
		super(ComponentHandlerType.CALENDAR_VIEW_SMALL_CALENDAR, eventDispatcher);
		this.calendarModel = calendarModel;
		this.dateModel = dateModel;
		this.addEventListeners();
	}

	private void addEventListeners() {
		SmallCalendarPanel.prevMonthButton.addActionListener(this);
		SmallCalendarPanel.nextMonthButton.addActionListener(this);
		SmallCalendarPanel.calendarTable.getSelectionModel().addListSelectionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == SmallCalendarPanel.nextMonthButton) {
			this.calendarModel.incrementMonth();
		} else if(event.getSource() == SmallCalendarPanel.prevMonthButton) {
			this.calendarModel.decrementMonth();
		}
	}

	public void valueChanged(ListSelectionEvent event) {
		int selectedTableIndex = event.getFirstIndex();
		//System.out.println("received selection event " + event.getValueIsAdjusting());
		if((selectedTableIndex > -1) && (!event.getValueIsAdjusting())) {
			this.invokeSelectionUpdate(selectedTableIndex);
		}
	}

	private void invokeSelectionUpdate(int selectedTableIndex) {
		this.calendarModel.setSelectedTableIndex(selectedTableIndex);
		int weekNumber = this.calendarModel.getWeek();
		int yearNumber = this.calendarModel.getYear();
		this.dateModel.setSelectedWeekNumber(weekNumber, yearNumber);
	}
	
}
