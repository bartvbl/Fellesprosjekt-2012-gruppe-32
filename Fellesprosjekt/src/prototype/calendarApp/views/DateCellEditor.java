package prototype.calendarApp.views;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;



public class DateCellEditor extends AbstractCellEditor implements TableCellEditor {

	DateField field;

	public DateCellEditor() {
		field = new DateField();
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		CalendarDate date = (CalendarDate) value;
		field.setValues(date);
		field.setVisuals(isSelected);
		if(column == 4) {
			field.addButton.setVisible(true);
		} else {
			field.addButton.setVisible(false);
		}
		return field;
	}
	
	public boolean isCellEditable(EventObject ev) {	
		return true;
	}

	public Object getCellEditorValue() {
		return null;
	}
}
