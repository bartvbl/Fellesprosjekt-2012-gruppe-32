package prototype.calendarApp.views;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditingHandler implements MouseListener {
	public EditingHandler() {
		CalendarView.calendarTable.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int row = CalendarView.calendarTable.getSelectedRow();
		int column = CalendarView.calendarTable.getSelectedColumn();
		CalendarView.calendarTable.editCellAt(row, column);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
