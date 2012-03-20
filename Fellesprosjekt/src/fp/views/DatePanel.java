/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DatePanel.java
 *
 * Created on Mar 8, 2012, 9:38:08 PM
 */
package fp.views;

import javax.swing.ImageIcon;

/**
 *
 * @author Bart
 */
public class DatePanel extends javax.swing.JPanel {

    /** Creates new form DatePanel */
    public DatePanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        meetingViewLayeredPane = new javax.swing.JLayeredPane();
        headerPanel = new javax.swing.JPanel();
        dateDayLabel = new javax.swing.JLabel();
        dayNameLabel = new javax.swing.JLabel();
        addNewMeetingButton = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(fp.views.CalendarApp.class).getContext().getResourceMap(DatePanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("Form.border.lineColor"))); // NOI18N
        setEnabled(false);
        setName("Form"); // NOI18N

        meetingViewLayeredPane.setName("meetingViewLayeredPane"); // NOI18N
        meetingViewLayeredPane.setOpaque(true);

        headerPanel.setBackground(resourceMap.getColor("headerPanel.background")); // NOI18N
        headerPanel.setName("headerPanel"); // NOI18N

        dateDayLabel.setFont(resourceMap.getFont("dateDayLabel.font")); // NOI18N
        dateDayLabel.setText(resourceMap.getString("dateDayLabel.text")); // NOI18N
        dateDayLabel.setName("dateDayLabel"); // NOI18N

        dayNameLabel.setFont(resourceMap.getFont("dayNameLabel.font")); // NOI18N
        dayNameLabel.setText(resourceMap.getString("dayNameLabel.text")); // NOI18N
        dayNameLabel.setName("dayNameLabel"); // NOI18N

        addNewMeetingButton.setIcon(new ImageIcon("res/plus_small.png")); // NOI18N
        addNewMeetingButton.setText(resourceMap.getString("addNewMeetingButton.text")); // NOI18N
        addNewMeetingButton.setContentAreaFilled(false);
        addNewMeetingButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addNewMeetingButton.setName("addNewMeetingButton"); // NOI18N
        addNewMeetingButton.setRolloverIcon(new ImageIcon("res/plus_small.png")); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(dayNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(addNewMeetingButton))
                    .addComponent(dateDayLabel))
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(dayNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateDayLabel))
                    .addComponent(addNewMeetingButton))
                .addContainerGap(3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(meetingViewLayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meetingViewLayeredPane, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton addNewMeetingButton;
    public static javax.swing.JLabel dateDayLabel;
    public static javax.swing.JLabel dayNameLabel;
    public static javax.swing.JPanel headerPanel;
    public static javax.swing.JLayeredPane meetingViewLayeredPane;
    // End of variables declaration//GEN-END:variables
}
