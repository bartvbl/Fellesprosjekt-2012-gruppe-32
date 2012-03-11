package prototype.calendarApp.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class TestPanel extends JPanel implements ActionListener, MouseListener {
	private JFrame owner;

	public TestPanel(JFrame owner) {
		this.owner = owner;
		JLayeredPane panel = CalendarView.mainLayeredPane;
		panel.add(this, 0);
		this.setBounds(500, 140, 200, 300);
		this.add(new JLabel("test test"));
		JButton button = new JButton("test");
		button.setContentAreaFilled(false);
		this.add(button);
		this.setOpaque(true);
		this.setVisible(false);
		CalendarView.pendingInvitationsButton.addActionListener(this);
		this.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		CalendarView.calendarTable.setEnabled(!CalendarView.pendingInvitationsButton.isSelected());
		this.setVisible(CalendarView.pendingInvitationsButton.isSelected());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		arg0.consume();
	}
	
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

	
}
