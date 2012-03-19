package fp.componentControllers;

import java.util.Calendar;
import java.util.Locale;

import javax.swing.table.DefaultTableModel;

import fp.components.smallCalendar.SmallCalendarModel;
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
	}

}
