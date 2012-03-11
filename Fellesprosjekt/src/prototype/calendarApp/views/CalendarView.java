/*
 * CalendarView.java
 */

package prototype.calendarApp.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;

import prototype.calendarApp.core.CalendarApp;
import prototype.calendarApp.core.Main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * The application's main frame.
 */
public class CalendarView extends FrameView {

	public CalendarView(SingleFrameApplication app) {
		super(app);

		initComponents();
		searchPanel.setLayout(new BorderLayout());
		JTextPane searchTextPane = new JTextPane();
		searchTextPane.setBorder(null);
		searchTextPane.setPreferredSize(new Dimension(230, 18));
		new TestPanel(this.getFrame());
		searchPanel.add(searchTextPane, BorderLayout.CENTER);
		JLabel searchIcon = new JLabel();
		searchIcon.setIcon(new ImageIcon("res/search.png"));
		searchIcon.setPreferredSize(new Dimension(18, 18));
		searchPanel.add(searchIcon, BorderLayout.EAST);
		new FrameResizer(this.getFrame());
		new Main();
	}

	@Action
	public void showAboutBox() {
		if (aboutBox == null) {
			JFrame mainFrame = CalendarApp.getApplication().getMainFrame();
			aboutBox = new CalendarAboutBox(mainFrame);
			aboutBox.setLocationRelativeTo(mainFrame);
		}
		CalendarApp.getApplication().show(aboutBox);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		menuBar = new javax.swing.JMenuBar();
		javax.swing.JMenu fileMenu = new javax.swing.JMenu();
		javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
		javax.swing.JMenu helpMenu = new javax.swing.JMenu();
		javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
		mainLayeredPane = new javax.swing.JLayeredPane();
		mainPanel = new javax.swing.JPanel();
		monthNameLabel = new javax.swing.JLabel();
		calendarTableScrollPane = new javax.swing.JScrollPane();
		calendarTable = new javax.swing.JTable();
		nextMonthButton = new javax.swing.JButton();
		previousMonthButton = new javax.swing.JButton();
		searchPanel = new javax.swing.JPanel();
		pendingInvitationsButton = new javax.swing.JToggleButton();
		todayButton = new javax.swing.JButton();
		utilitiesPanel = new javax.swing.JPanel();
		favouritesLabel = new javax.swing.JLabel();
		favouritesListScrollPane = new javax.swing.JScrollPane();
		favouritesList = new javax.swing.JList();
		smallCalendarPanel = new javax.swing.JPanel();

		menuBar.setName("menuBar"); // NOI18N

		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(prototype.calendarApp.core.CalendarApp.class).getContext().getResourceMap(CalendarView.class);
		fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
		fileMenu.setName("fileMenu"); // NOI18N

		javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(prototype.calendarApp.core.CalendarApp.class).getContext().getActionMap(CalendarView.class, this);
		exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
		exitMenuItem.setName("exitMenuItem"); // NOI18N
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
		helpMenu.setName("helpMenu"); // NOI18N

		aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
		aboutMenuItem.setName("aboutMenuItem"); // NOI18N
		helpMenu.add(aboutMenuItem);

		menuBar.add(helpMenu);

		mainLayeredPane.setName("mainLayeredPane"); // NOI18N

		mainPanel.setName("mainPanel"); // NOI18N

		monthNameLabel.setFont(resourceMap.getFont("monthNameLabel.font")); // NOI18N
		monthNameLabel.setText(resourceMap.getString("monthNameLabel.text")); // NOI18N
		monthNameLabel.setName("monthNameLabel"); // NOI18N

		calendarTableScrollPane.setName("calendarTableScrollPane"); // NOI18N

		calendarTable.setModel(new DateCellTableModel());
		calendarTable.setName("calendarTable"); // NOI18N
		calendarTable.setRowSelectionAllowed(false);
		calendarTable.setUpdateSelectionOnSort(false);
		calendarTableScrollPane.setViewportView(calendarTable);

		nextMonthButton.setText(resourceMap.getString("nextMonthButton.text")); // NOI18N
		nextMonthButton.setName("nextMonthButton"); // NOI18N

		previousMonthButton.setText(resourceMap.getString("previousMonthButton.text")); // NOI18N
		previousMonthButton.setName("previousMonthButton"); // NOI18N

		searchPanel.setBackground(resourceMap.getColor("searchPanel.background")); // NOI18N
		searchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("searchPanel.border.lineColor"))); // NOI18N
		searchPanel.setName("searchPanel"); // NOI18N

		javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
		searchPanel.setLayout(searchPanelLayout);
		searchPanelLayout.setHorizontalGroup(
				searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 236, Short.MAX_VALUE)
				);
		searchPanelLayout.setVerticalGroup(
				searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 16, Short.MAX_VALUE)
				);

		pendingInvitationsButton.setText(resourceMap.getString("pendingInvitationsButton.text")); // NOI18N
		pendingInvitationsButton.setName("pendingInvitationsButton"); // NOI18N

		todayButton.setText(resourceMap.getString("todayButton.text")); // NOI18N
		todayButton.setName("todayButton"); // NOI18N

		utilitiesPanel.setName("utilitiesPanel"); // NOI18N

		favouritesLabel.setText(resourceMap.getString("favouritesLabel.text")); // NOI18N
		favouritesLabel.setName("favouritesLabel"); // NOI18N

		favouritesListScrollPane.setName("favouritesListScrollPane"); // NOI18N

		favouritesList.setModel(new DefaultListModel());
		favouritesList.setName("favouritesList"); // NOI18N
		favouritesListScrollPane.setViewportView(favouritesList);

		smallCalendarPanel.setName("smallCalendarPanel"); // NOI18N

		javax.swing.GroupLayout smallCalendarPanelLayout = new javax.swing.GroupLayout(smallCalendarPanel);
		smallCalendarPanel.setLayout(smallCalendarPanelLayout);
		smallCalendarPanelLayout.setHorizontalGroup(
				smallCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 212, Short.MAX_VALUE)
				);
		smallCalendarPanelLayout.setVerticalGroup(
				smallCalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 176, Short.MAX_VALUE)
				);

		javax.swing.GroupLayout utilitiesPanelLayout = new javax.swing.GroupLayout(utilitiesPanel);
		utilitiesPanel.setLayout(utilitiesPanelLayout);
		utilitiesPanelLayout.setHorizontalGroup(
				utilitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(utilitiesPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(favouritesLabel)
						.addContainerGap(151, Short.MAX_VALUE))
						.addComponent(favouritesListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
						.addComponent(smallCalendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		utilitiesPanelLayout.setVerticalGroup(
				utilitiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(utilitiesPanelLayout.createSequentialGroup()
						.addComponent(smallCalendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(favouritesLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(favouritesListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
				);

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout.setHorizontalGroup(
				mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(previousMonthButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(todayButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 566, Short.MAX_VALUE)
						.addComponent(pendingInvitationsButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(nextMonthButton)
						.addContainerGap())
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
								.addComponent(utilitiesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(mainPanelLayout.createSequentialGroup()
												.addGap(229, 229, 229)
												.addComponent(monthNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
												.addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
												.addGroup(mainPanelLayout.createSequentialGroup()
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(calendarTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))))
				);
		mainPanelLayout.setVerticalGroup(
				mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup()
						.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(mainPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(monthNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(calendarTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
												.addComponent(utilitiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(todayButton)
																.addComponent(previousMonthButton))
																.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(nextMonthButton)
																		.addComponent(pendingInvitationsButton)))
																		.addContainerGap())
				);

		mainPanel.setBounds(0, 0, 850, 450);
		mainLayeredPane.add(mainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

		setComponent(mainLayeredPane);
		setMenuBar(menuBar);
	}// </editor-fold>

	// Variables declaration - do not modify
	public static javax.swing.JTable calendarTable;
	public static javax.swing.JScrollPane calendarTableScrollPane;
	public static javax.swing.JLabel favouritesLabel;
	public static javax.swing.JList favouritesList;
	public static javax.swing.JScrollPane favouritesListScrollPane;
	public static javax.swing.JLayeredPane mainLayeredPane;
	public static javax.swing.JPanel mainPanel;
	public static javax.swing.JMenuBar menuBar;
	public static javax.swing.JLabel monthNameLabel;
	public static javax.swing.JButton nextMonthButton;
	public static javax.swing.JToggleButton pendingInvitationsButton;
	public static javax.swing.JButton previousMonthButton;
	public static javax.swing.JPanel searchPanel;
	public static javax.swing.JPanel smallCalendarPanel;
	public static javax.swing.JButton todayButton;
	public static javax.swing.JPanel utilitiesPanel;
	// End of variables declaration


	private JDialog aboutBox;
}
