package fp.components.smallCalendar;

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.events.EventDispatcher;
import fp.views.SmallCalendarPanel;

public class SmallCalendarController extends AbstractComponentController {

	private SmallCalendarModel model;
	
	public SmallCalendarController(EventDispatcher eventDispatcher) {
		super(ComponentControllerType.CALENDAR_VIEW_SMALL_CALENDAR, eventDispatcher);
		this.model = new SmallCalendarModel();
		this.updateCalendar();
	}
	
	public void nextMonth() {
		this.model.incrementMonth();
		this.updateCalendar();
	}
	
	public void previousMonth() {
		this.model.decrementMonth();
		this.updateCalendar();
	}
	
	private void updateCalendar() {
		DefaultTableModel model = (DefaultTableModel) SmallCalendarPanel.calendarTable.getModel();
		model.setRowCount(0);
		SmallCalendarPanel.monthLabel.setText(this.model.getMonthName() + " " + this.model.getYear());
		int[][] rows = this.model.getDateRows();
		for(int[] row : rows) {
			model.addRow(new Integer[]{new Integer(row[0]), new Integer(row[1]), new Integer(row[2]), new Integer(row[3]), new Integer(row[4]), new Integer(row[5]), new Integer(row[6])});
		}
		this.updateSelection();
		
	}

	private void updateSelection() {
		int[] currentWeekArray = this.model.getWeekNumbersOfCurrentMonth();
		int currentSelectedWeekIndex = Arrays.binarySearch(currentWeekArray, this.model.getSelectedWeekNumber());
		if((currentSelectedWeekIndex > -1) && (this.model.getYear() == this.model.getSelectedYear())) {
			SmallCalendarPanel.calendarTable.getSelectionModel().setSelectionInterval(currentSelectedWeekIndex, currentSelectedWeekIndex);
		}
	}
	
	public void updateSelectedWeek() {
		int selectedIndex = SmallCalendarPanel.calendarTable.getSelectionModel().getLeadSelectionIndex();
		int numberOfRowsInCalendarTable = SmallCalendarPanel.calendarTable.getRowCount();
		if((selectedIndex != -1) && (selectedIndex < numberOfRowsInCalendarTable)) {				
			int[] currentWeekList = this.model.getWeekNumbersOfCurrentMonth();
			this.model.setSelectedWeekNumber(currentWeekList[selectedIndex], this.model.getYear());
		}
	}
	
	public int getCurrentWeekNumber() {
		return this.model.getSelectedWeekNumber();
	}

}
