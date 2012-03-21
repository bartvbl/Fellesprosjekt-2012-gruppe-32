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
		int[][] rows = this.calendarModel.generateDateRowsOfSmallCalendarTable();
		for(int[] row : rows) {
			model.addRow(new Integer[]{new Integer(row[0]), new Integer(row[1]), new Integer(row[2]), new Integer(row[3]), new Integer(row[4]), new Integer(row[5]), new Integer(row[6])});
		}
		this.updateSelection();
	}

	
	public int getCurrentWeekNumber() {
		return this.dateSelectionModel.getSelectedWeekNumber();
	}
}
