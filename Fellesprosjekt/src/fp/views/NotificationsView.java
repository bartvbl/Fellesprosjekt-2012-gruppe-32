package fp.views;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fp.components.InteractiveList;

public class NotificationsView extends JPanel {
	public static InteractiveList<MessagesPanel> invitationsList;
	public static JScrollPane mainScrollPane;
	private static NotificationsView panelInstance;
	
	public NotificationsView() {
		super(new BorderLayout());
		this.invitationsList = new InteractiveList<MessagesPanel>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(invitationsList);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.mainScrollPane = scrollPane;
		this.add(mainScrollPane, BorderLayout.CENTER);
		
		CalendarView.mainLayeredPane.add(this, 3);		
	}

	public static NotificationsView getInstance() {
		return panelInstance;
	}
}
