/*
 * CalendarView.java
 */

package fp.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
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
        searchTextPane.setPreferredSize(new Dimension(230, 10));
        searchPanel.add(searchTextPane, BorderLayout.CENTER);
        JLabel searchIcon = new JLabel();
        searchIcon.setIcon(new ImageIcon("src/calendarapp/search.png"));
        searchIcon.setPreferredSize(new Dimension(18, 18));
        searchPanel.add(searchIcon, BorderLayout.EAST);
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        mainLayeredPane = new javax.swing.JLayeredPane();
        mainPanel = new javax.swing.JPanel();
        monthNameLabel = new javax.swing.JLabel();
        nextMonthButton = new javax.swing.JButton();
        previousMonthButton = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        pendingNotificationsButton = new javax.swing.JToggleButton();
        todayButton = new javax.swing.JButton();
        smallCalendarPanel = new SmallCalendarPanel();
        favouritesPanel = new javax.swing.JPanel();
        favouritesTabbedPane = new javax.swing.JTabbedPane();
        peopleListScrollPane = new javax.swing.JScrollPane();
        favouritePeopleList = new javax.swing.JList();
        appointmentsScrollPane = new javax.swing.JScrollPane();
        favouriteAppointmentsScrollPane = new javax.swing.JList();
        favouritesLabel = new javax.swing.JLabel();
        calendarViewerScrollPane = new javax.swing.JScrollPane();
        calendarViewerLayeredPane = new javax.swing.JLayeredPane();

        menuBar.setName("menuBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(fp.views.CalendarApp.class).getContext().getResourceMap(CalendarView.class);
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(fp.views.CalendarApp.class).getContext().getActionMap(CalendarView.class, this);
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
            .addGap(0, 269, Short.MAX_VALUE)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        pendingNotificationsButton.setIcon(resourceMap.getIcon("pendingNotificationsButton.icon")); // NOI18N
        pendingNotificationsButton.setText(resourceMap.getString("pendingNotificationsButton.text")); // NOI18N
        pendingNotificationsButton.setName("pendingNotificationsButton"); // NOI18N

        todayButton.setText(resourceMap.getString("todayButton.text")); // NOI18N
        todayButton.setName("todayButton"); // NOI18N

        smallCalendarPanel.setName("smallCalendarPanel"); // NOI18N
        smallCalendarPanel.setPreferredSize(new java.awt.Dimension(247, 176));

        favouritesPanel.setName("favouritesPanel"); // NOI18N

        favouritesTabbedPane.setName("favouritesTabbedPane"); // NOI18N
        favouritesTabbedPane.setPreferredSize(new java.awt.Dimension(263, 160));

        peopleListScrollPane.setName("peopleListScrollPane"); // NOI18N

        favouritePeopleList.setModel(new DefaultListModel());
        favouritePeopleList.setName("favouritePeopleList"); // NOI18N
        peopleListScrollPane.setViewportView(favouritePeopleList);

        favouritesTabbedPane.addTab(resourceMap.getString("peopleListScrollPane.TabConstraints.tabTitle"), peopleListScrollPane); // NOI18N

        appointmentsScrollPane.setName("appointmentsScrollPane"); // NOI18N

        favouriteAppointmentsScrollPane.setModel(new DefaultListModel());
        favouriteAppointmentsScrollPane.setName("favouriteAppointmentsScrollPane"); // NOI18N
        appointmentsScrollPane.setViewportView(favouriteAppointmentsScrollPane);

        favouritesTabbedPane.addTab(resourceMap.getString("appointmentsScrollPane.TabConstraints.tabTitle"), appointmentsScrollPane); // NOI18N

        favouritesLabel.setFont(resourceMap.getFont("favouritesLabel.font")); // NOI18N
        favouritesLabel.setIcon(resourceMap.getIcon("favouritesLabel.icon")); // NOI18N
        favouritesLabel.setText(resourceMap.getString("favouritesLabel.text")); // NOI18N
        favouritesLabel.setName("favouritesLabel"); // NOI18N

        javax.swing.GroupLayout favouritesPanelLayout = new javax.swing.GroupLayout(favouritesPanel);
        favouritesPanel.setLayout(favouritesPanelLayout);
        favouritesPanelLayout.setHorizontalGroup(
            favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favouritesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(favouritesTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addGroup(favouritesPanelLayout.createSequentialGroup()
                        .addComponent(favouritesLabel)
                        .addContainerGap(170, Short.MAX_VALUE))))
        );
        favouritesPanelLayout.setVerticalGroup(
            favouritesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favouritesPanelLayout.createSequentialGroup()
                .addComponent(favouritesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(favouritesTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
        );

        calendarViewerScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        calendarViewerScrollPane.setName("calendarViewerScrollPane"); // NOI18N

        calendarViewerLayeredPane.setName("calendarViewerLayeredPane"); // NOI18N
        calendarViewerScrollPane.setViewportView(calendarViewerLayeredPane);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(smallCalendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(favouritesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(calendarViewerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(monthNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(previousMonthButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(todayButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextMonthButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                        .addComponent(pendingNotificationsButton)
                        .addContainerGap())))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monthNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(smallCalendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(favouritesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(calendarViewerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousMonthButton)
                    .addComponent(todayButton)
                    .addComponent(nextMonthButton)
                    .addComponent(pendingNotificationsButton))
                .addContainerGap())
        );

        mainPanel.setBounds(0, 0, 850, 450);
        mainLayeredPane.add(mainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        setComponent(mainLayeredPane);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JScrollPane appointmentsScrollPane;
    public static javax.swing.JLayeredPane calendarViewerLayeredPane;
    public static javax.swing.JScrollPane calendarViewerScrollPane;
    public static javax.swing.JList favouriteAppointmentsScrollPane;
    public static javax.swing.JList favouritePeopleList;
    public static javax.swing.JLabel favouritesLabel;
    public static javax.swing.JPanel favouritesPanel;
    public static javax.swing.JTabbedPane favouritesTabbedPane;
    public static javax.swing.JLayeredPane mainLayeredPane;
    public static javax.swing.JPanel mainPanel;
    public static javax.swing.JMenuBar menuBar;
    public static javax.swing.JLabel monthNameLabel;
    public static javax.swing.JButton nextMonthButton;
    public static javax.swing.JToggleButton pendingNotificationsButton;
    public static javax.swing.JScrollPane peopleListScrollPane;
    public static javax.swing.JButton previousMonthButton;
    public static javax.swing.JPanel searchPanel;
    public static SmallCalendarPanel smallCalendarPanel;
    public static javax.swing.JButton todayButton;
    // End of variables declaration//GEN-END:variables


    private JDialog aboutBox;
}
