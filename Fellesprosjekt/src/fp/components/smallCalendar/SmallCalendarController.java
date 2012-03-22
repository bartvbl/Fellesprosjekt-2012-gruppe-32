package fp.components.smallCalendar;

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

import fp.componentControllers.AbstractComponentController;
import fp.componentControllers.ComponentControllerType;
import fp.events.Event;
import fp.events.EventDispatcher;
import fp.events.EventHandler;
import fp.events.EventType;
import fp.models.DateSelectionModel;
import fp.models.SmallCalendarModel;
import fp.views.SmallCalendarPanel;

public class SmallCalendarController extends AbstractComponentController implements EventHandler {

	private SmallCalendarModel calendarModel;
	private DateSelectionModel dateSelectionModel;
	
	public SmallCalendarController(EventDispatcher eventDispatcher, DateSelectionModel dateSelectionModel, SmallCalendarModel smallCalendarModel) {
		super(ComponentControllerType.CALENDAR_VIEW_SMALL_CALENDAR, eventDispatcher);
		this.eventDispatcher.addEventListener(this, EventType.SELECTED_WEEK_CHANGED);
		this.eventDispatcher.addEventListener(this, EventType.SMALL_CALENDAR_MONTH_CHANGED);
		this.calendarModel = smallCalendarModel;
		this.dateSelectionModel = dateSelectionModel;
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
		//System.out.println("clearing rows ");
		model.setRowCount(0);
		SmallCalendarPanel.monthLabel.setText(this.calendarModel.getMonthName() + " " + this.calendarModel.getYear());
		int[][] rows = this.calendarModel.getDateTableRows();
		//System.out.println("creating rows");
		for(int[] row : rows) {
			model.addRow(new Integer[]{new Integer(row[0]), new Integer(row[1]), new Integer(row[2]), new Integer(row[3]), new Integer(row[4]), new Integer(row[5]), new Integer(row[6])});
		}
	}

	
	public int getCurrentWeekNumber() {
		return this.dateSelectionModel.getSelectedWeekNumber();
	}

	public void handleEvent(Event<?> event) {
		this.updateCalendar();
	}
}
