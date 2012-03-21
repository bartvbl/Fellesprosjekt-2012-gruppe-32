package fp.components.smallCalendar;

import fp.events.Event;
import fp.events.EventType;
import fp.models.DateSelectionModel;
import fp.views.SmallCalendarPanel;

public class SmallCalendarSelectionController {

	private DateSelectionModel selectionModel;

	public SmallCalendarSelectionController(DateSelectionModel dateSelectionModel) {
		this.selectionModel = dateSelectionModel;
		
	}
	

	private void updateSelection() {
		int selectedWeek = this.selectionModel.getSelectedWeekNumber();
		int selectedYear = this.selectionModel.getSelectedYear();
		if(this.calendarModel.isWeekCurrentlyDisplayed(selectedWeek, selectedYear)) {
			int selectedWeekIndex = this.calendarModel.getweekIndexByWeekNumber(selectedWeek);
			SmallCalendarPanel.calendarTable.getSelectionModel().setSelectionInterval(selectedWeekIndex, selectedWeekIndex);
		}
	}
	
	public void updateSelectedWeek() {
		int selectedIndex = SmallCalendarPanel.calendarTable.getSelectionModel().getLeadSelectionIndex();
		int numberOfRowsInCalendarTable = SmallCalendarPanel.calendarTable.getRowCount();
		if((selectedIndex != -1) && (selectedIndex < numberOfRowsInCalendarTable)) {				
			int currentWeek = this.calendarModel.getWeekBySmallCalendarTableRowID(selectedIndex);
			this.selectionModel.setSelectedWeekNumber(currentWeek, this.calendarModel.getYear());
		}
	}

	public void updateSelection() {
		int oldSelectedWeek = this.smallCalendarController.getCurrentWeekNumber();
		this.smallCalendarController.updateSelectedWeek();
		int newSelectedWeek = this.smallCalendarController.getCurrentWeekNumber();
		if(oldSelectedWeek != newSelectedWeek) {
			this.eventDispatcher.dispatchEvent(new Event<Integer>(EventType.SELECTED_WEEK_CHANGED, new Integer(newSelectedWeek)));
		}
	}

}
