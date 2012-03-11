package prototype.calendarApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class TestPanel extends JPanel implements ActionListener, MouseListener {
	private JFrame owner;

	public TestPanel(JFrame owner) {
		super(new BorderLayout());
		this.owner = owner;
		JLayeredPane panel = CalendarView.mainLayeredPane;
		panel.add(this, 0);
		this.setBounds(500, 140, 200, 300);
		this.setOpaque(true);
		this.setVisible(false);
		CalendarView.pendingInvitationsButton.addActionListener(this);
		this.addMouseListener(this);
		//this.setBorder(new LineBorder(Color.gray));
		JScrollPane scroller = new JScrollPane();
		this.add(scroller, BorderLayout.CENTER);
		DefaultListModel model = new DefaultListModel();
		model.addElement("Meeting at some random place");
		model.addElement("Lunch with a random guy");
		model.addElement("Party somewhere nearby");
		model.addElement("Group meeting (all day)");
		JList list = new JList(model);
		list.setCellRenderer(new MessagePanelRenderer());
		scroller.setViewportView(list);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		CalendarView.calendarTable.setEnabled(!CalendarView.pendingInvitationsButton.isSelected());
		DateCellTableModel model = (DateCellTableModel) CalendarView.calendarTable.getModel();
		model.setEditable(!CalendarView.pendingInvitationsButton.isSelected());
		this.setVisible(CalendarView.pendingInvitationsButton.isSelected());
		Rectangle positionRect = this.owner.getBounds();
		this.setBounds(positionRect.width-360, positionRect.height - 222, 290, 138);
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
