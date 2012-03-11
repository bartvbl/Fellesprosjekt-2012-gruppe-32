package prototype.calendarApp.views;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class DateCellTableModel extends DefaultTableModel {
	private ArrayList<CalendarDate[]> dateMatrix = new ArrayList<CalendarDate[]>();
	
	public DateCellTableModel() {
		
	}
	
	public void setRowCount(int count) {
		System.out.println(this.dateMatrix.size());
		for(int i = this.dateMatrix.size()-1; i >= count; i--) {
			this.dateMatrix.remove(i);
		}
		super.setRowCount(count);
	}
	
	public Class<?> getColumnClass(int columnIndex) { 
		return CalendarDate.class; 
	}
	public int getColumnCount() { 
		return 7; 
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) { 
		return true; 
	}
	public Object getValueAt(int rowIndex, int columnIndex) { 
		return dateMatrix.get(rowIndex)[columnIndex]; 
	}
	public void addCalendarDateRow(CalendarDate[] row) {
		this.dateMatrix.add(row);
		super.addRow(row);
	}

}
