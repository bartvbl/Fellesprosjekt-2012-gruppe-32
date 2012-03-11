package prototype.calendarApp.views;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DateCellRenderer implements TableCellRenderer {
	  DateField panel;

	  public DateCellRenderer() {
	    panel = new DateField();
	  }

	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		CalendarDate field = (CalendarDate) value;
		panel.setValues(field);
	    return panel;
	  }
	}

