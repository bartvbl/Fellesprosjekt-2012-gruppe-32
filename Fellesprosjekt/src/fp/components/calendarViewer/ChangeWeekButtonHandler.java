package fp.components.calendarViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fp.componentHandlers.AbstractComponentHandler;
import fp.componentHandlers.ComponentHandlerType;
import fp.events.EventDispatcher;
import fp.views.CalendarView;

public class ChangeWeekButtonHandler extends AbstractComponentHandler implements ActionListener{

	private CalendarViewerController controller;
	
	public ChangeWeekButtonHandler(EventDispatcher eventDispatcher, CalendarViewerController controller) {
		super(ComponentHandlerType.CHANGE_WEEK_BUTTON, eventDispatcher);
		this.controller = controller;
		this.addEventListeners();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == CalendarView.previousMonthButton) {
			this.controller.incrementSelectedWeek();
		} else if(event.getSource() == CalendarView.nextMonthButton) {
			this.controller.decrementSelectedWeek();
		} else if(event.getSource() == CalendarView.nextMonthButton) {
			this.controller.today();
	}
	}
	
	private void addEventListeners() {
		CalendarView.previousMonthButton.addActionListener(this);
		CalendarView.nextMonthButton.addActionListener(this);
		CalendarView.todayButton.addActionListener(this);
	}

}
