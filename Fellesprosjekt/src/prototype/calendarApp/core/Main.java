package prototype.calendarApp.core;

import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import prototype.calendarApp.views.CalendarDate;
import prototype.calendarApp.views.CalendarView;
import prototype.calendarApp.views.DateCellEditor;
import prototype.calendarApp.views.DateCellRenderer;
import prototype.calendarApp.views.DateCellTableModel;
import prototype.calendarApp.views.EditingHandler;
import prototype.calendarApp.views.ItemRenderer;
import prototype.calendarApp.views.SmallCalendar;


public class Main {
	public Main() {
		DateCellTableModel model = (DateCellTableModel) CalendarView.calendarTable.getModel();
		model.setColumnCount(0);
		model.addColumn("Monday");
		model.addColumn("Tuesday");
		model.addColumn("Wednesday");
		model.addColumn("Thursday");
		model.addColumn("Friday");
		model.addColumn("Saturday");
		model.addColumn("Sunday");
		model.addCalendarDateRow(new CalendarDate[]{new CalendarDate(29, false), new CalendarDate(30, false), new CalendarDate(31, false), new CalendarDate(1, true), new CalendarDate(2, true), new CalendarDate(3, true), new CalendarDate(4, true)});
		//model.addCalendarDateRow(new CalendarDate[]{new CalendarDate(5, true), new CalendarDate(6, true), new CalendarDate(7, true), new CalendarDate(8, true), new CalendarDate(9, true), new CalendarDate(10, true), new CalendarDate(11, true)});
		//model.addCalendarDateRow(new CalendarDate[]{new CalendarDate(12, true), new CalendarDate(13, true), new CalendarDate(14, true), new CalendarDate(15, true), new CalendarDate(16, true), new CalendarDate(17, true), new CalendarDate(18, true)});
		//model.addCalendarDateRow(new CalendarDate[]{new CalendarDate(19, true), new CalendarDate(20, true), new CalendarDate(21, true), new CalendarDate(22, true), new CalendarDate(23, true), new CalendarDate(24, true), new CalendarDate(25, true)});
		//model.addCalendarDateRow(new CalendarDate[]{new CalendarDate(26, true), new CalendarDate(27, true), new CalendarDate(28, true), new CalendarDate(29, true), new CalendarDate(30, true), new CalendarDate(31, true), new CalendarDate(1, false)});
		CalendarView.calendarTable.setRowHeight(400);
		CalendarView.calendarTable.getTableHeader().setResizingAllowed(false);
		CalendarView.calendarTable.getTableHeader().setReorderingAllowed(false);
		CalendarView.calendarTable.getTableHeader().setEnabled(false);
		CalendarView.calendarTable.setDefaultRenderer(CalendarDate.class, new DateCellRenderer());
		CalendarView.calendarTable.setDefaultEditor(CalendarDate.class, new DateCellEditor());
		CalendarView.calendarTable.setRowSelectionAllowed(true);
		CalendarView.calendarTable.setColumnSelectionAllowed(false);
		CalendarView.calendarTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		new EditingHandler();
		CalendarView.favouritePeopleList.setCellRenderer(new ItemRenderer());
		((DefaultListModel) CalendarView.favouritePeopleList.getModel()).addElement("Jack Sparrow");
		((DefaultListModel) CalendarView.favouritePeopleList.getModel()).addElement("Commander Shepard");
		((DefaultListModel) CalendarView.favouritePeopleList.getModel()).addElement("Darth Vader");
		((DefaultListModel) CalendarView.favouritePeopleList.getModel()).addElement("Wall-E");
		((DefaultListModel) CalendarView.favouritePeopleList.getModel()).addElement("Indiana Jones");
	}
}
