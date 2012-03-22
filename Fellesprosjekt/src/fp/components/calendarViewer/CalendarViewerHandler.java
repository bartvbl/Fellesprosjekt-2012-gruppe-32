package fp.components.calendarViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import fp.componentHandlers.AbstractComponentHandler;
import fp.componentHandlers.ComponentHandlerType;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;
import fp.models.DateSelectionModel;
import fp.views.CalendarView;

public class CalendarViewerHandler extends AbstractComponentHandler implements ActionListener {
	private DateSelectionModel selectionModel;

	public CalendarViewerHandler(EventDispatcher eventDispatcher, DateSelectionModel selectionModel) {
		super(ComponentHandlerType.CALENDAR_VIEW_CALENDAR_VIEWER, eventDispatcher);
		this.selectionModel = selectionModel;
		this.addEventListeners();
	}

	private void addEventListeners() {
		CalendarView.nextMonthButton.addActionListener(this);
		CalendarView.previousMonthButton.addActionListener(this);
		CalendarView.todayButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == CalendarView.nextMonthButton) {
			this.selectionModel.incrementWeek();
		} else if(event.getSource() == CalendarView.previousMonthButton) {
			this.selectionModel.decrementWeek();
		} else if(event.getSource() == CalendarView.todayButton) {
			this.selectionModel.reset();
		}
	}

}
