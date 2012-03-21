package fp.components.smallCalendar;

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.events.EventDispatcher;
import fp.models.DateSelectionModel;
import fp.views.SmallCalendarPanel;

public class SmallCalendarController extends AbstractComponentController {

	private SmallCalendarModel calendarModel;
	private DateSelectionModel dateSelectionModel;
	
	public SmallCalendarController(EventDispatcher eventDispatcher, DateSelectionModel dateSelectionModel) {
		super(ComponentControllerType.CALENDAR_VIEW_SMALL_CALENDAR, eventDispatcher);
		this.calendarModel = new SmallCalendarModel();
		this.dateSelectionModel = dateSelectionModel;
		this.updateCalendar();
	}
	
	public void nextMonth() {
		this.calendarModel.incrementMonth();
		this.updateCalendar();
	}
	
	public void previousMonth() {
		this.calendarModel.decrementMonth();
		this.updateCalendar();
	}
	
	private void updateCalendar() {
		DefaultTableModel model = (DefaultTableModel) SmallCalendarPanel.calendarTable.getModel();
		model.setRowCount(0);
		SmallCalendarPanel.monthLabel.setText(this.calendarModel.getMonthName() + " " + this.calendarModel.getYear());
		int[][] rows = this.calendarModel.getDateRows();
		for(int[] row : rows) {
			model.addRow(new Integer[]{new Integer(row[0]), new Integer(row[1]), new Integer(row[2]), new Integer(row[3]), new Integer(row[4]), new Integer(row[5]), new Integer(row[6])});
		}
		this.updateSelection();
		
	}

	private void updateSelection() {
		int[] currentWeekArray = this.calendarModel.getWeekNumbersOfCurrentMonth();
		int currentSelectedWeekIndex = Arrays.binarySearch(currentWeekArray, this.dateSelectionModel.getSelectedWeekNumber());
		if((currentSelectedWeekIndex > -1) && (this.calendarModel.getYear() == this.dateSelectionModel.getSelectedYear())) {
			SmallCalendarPanel.calendarTable.getSelectionModel().setSelectionInterval(currentSelectedWeekIndex, currentSelectedWeekIndex);
		}
	}
	
	public void updateSelectedWeek() {
		int selectedIndex = SmallCalendarPanel.calendarTable.getSelectionModel().getLeadSelectionIndex();
		int numberOfRowsInCalendarTable = SmallCalendarPanel.calendarTable.getRowCount();
		if((selectedIndex != -1) && (selectedIndex < numberOfRowsInCalendarTable)) {				
			int[] currentWeekList = this.calendarModel.getWeekNumbersOfCurrentMonth();
			this.dateSelectionModel.setSelectedWeekNumber(currentWeekList[selectedIndex], this.calendarModel.getYear());
		}
	}
	
	public int getCurrentWeekNumber() {
		return this.dateSelectionModel.getSelectedWeekNumber();
	}

}
