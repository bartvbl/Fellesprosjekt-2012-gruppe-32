package fp.components.smallCalendar;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class SmallCalendarTableTableCellRenderer extends DefaultTableCellRenderer {
	private static final Integer ZERO = new Integer(0);
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, false, row, column);
		Integer intValue = (Integer) value;
		if(value == null) { return label; }
		if(value.equals(ZERO)) {
			label.setText("");
		} else {
			label.setText(intValue.toString());
		}
		if(isSelected) {
			label.setBackground(Color.gray);
		} else {
			label.setBackground(Color.white);
		}
		return label;
	}
}
