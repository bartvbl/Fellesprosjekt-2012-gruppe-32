package fp.views.customModels;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import fp.views.SmallCalendarPanel;



public class SmallCalendarTableModel extends DefaultTableModel {

	public SmallCalendarTableModel() {

	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	
	
	
}
