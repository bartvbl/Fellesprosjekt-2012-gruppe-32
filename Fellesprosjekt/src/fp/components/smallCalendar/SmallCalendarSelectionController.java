package fp.components.smallCalendar;

import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;
import fp.models.DateSelectionModel;
import fp.models.SmallCalendarModel;
import fp.views.SmallCalendarPanel;

public class SmallCalendarSelectionController implements EventHandler {

	private DateSelectionModel selectionModel;
	private EventDispatcher eventDispatcher;
	private SmallCalendarModel smallCalendarModel;

	public SmallCalendarSelectionController(EventDispatcher eventDispatcher, DateSelectionModel dateSelectionModel, SmallCalendarModel smallCalendarModel) {
		this.selectionModel = dateSelectionModel;
		this.eventDispatcher = eventDispatcher;
		this.smallCalendarModel = smallCalendarModel;
		eventDispatcher.addEventListener(this, EventType.SELECTED_WEEK_CHANGED);
	}
	
	private void updateSelection() {
//		int selectedWeek = this.selectionModel.getSelectedWeekNumber();
//		int selectedYear = this.selectionModel.getSelectedYear();
//		if(this.smallCalendarModel.isWeekCurrentlyDisplayed(selectedWeek, selectedYear)) {
//			int selectedWeekIndex = this.smallCalendarModel.getweekIndexByWeekNumber(selectedWeek);
//			SmallCalendarPanel.calendarTable.getSelectionModel().setSelectionInterval(selectedWeekIndex, selectedWeekIndex);
//		}
//		int oldSelectedWeek = this.smallCalendarModel.getCurrentWeekNumber();
//		this.updateSelectedWeek();
//		int newSelectedWeek = this.selectionModel.getCurrentWeekNumber();
//		if(oldSelectedWeek != newSelectedWeek) {
//			this.eventDispatcher.dispatchEvent(new Event<Integer>(EventType.SELECTED_WEEK_CHANGED, new Integer(newSelectedWeek)));
//		}
	}
	
	public void updateSelectedWeek() {
//		int selectedIndex = SmallCalendarPanel.calendarTable.getSelectionModel().getLeadSelectionIndex();
//		int numberOfRowsInCalendarTable = SmallCalendarPanel.calendarTable.getRowCount();
//		if((selectedIndex != -1) && (selectedIndex < numberOfRowsInCalendarTable)) {				
//			int currentWeek = this.smallCalendarModel.getWeekBySmallCalendarTableRowID(selectedIndex);
//			this.selectionModel.setSelectedWeekNumber(currentWeek, this.smallCalendarModel.getYear());
//		}
	}
	public void handleEvent(Event<?> event) {
		this.updateSelection();
	}

}
