/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MessagesPanel.java
 *
 * Created on Mar 11, 2012, 2:19:29 PM
 */
package fp.views;

/**
 *
 * @author Bart
 */
public class MessagesPanel extends javax.swing.JPanel {

    /** Creates new form MessagesPanel */
    public MessagesPanel() {
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

        acceptButton = new javax.swing.JButton();
        declineButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        makeFavouriteButton = new javax.swing.JToggleButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(prototype.calendarApp.views.CalendarApp.class).getContext().getResourceMap(MessagesPanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setBorder(null);
        setForeground(resourceMap.getColor("Form.foreground")); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Form"); // NOI18N

        acceptButton.setIcon(resourceMap.getIcon("acceptButton.icon")); // NOI18N
        acceptButton.setText(resourceMap.getString("acceptButton.text")); // NOI18N
        acceptButton.setContentAreaFilled(false);
        acceptButton.setName("acceptButton"); // NOI18N
        acceptButton.setRolloverIcon(resourceMap.getIcon("acceptButton.rolloverIcon")); // NOI18N

        declineButton.setIcon(resourceMap.getIcon("declineButton.icon")); // NOI18N
        declineButton.setText(resourceMap.getString("declineButton.text")); // NOI18N
        declineButton.setContentAreaFilled(false);
        declineButton.setName("declineButton"); // NOI18N
        declineButton.setRolloverIcon(resourceMap.getIcon("declineButton.rolloverIcon")); // NOI18N

        titleLabel.setFont(resourceMap.getFont("titleLabel.font")); // NOI18N
        titleLabel.setText(resourceMap.getString("titleLabel.text")); // NOI18N
        titleLabel.setName("titleLabel"); // NOI18N

        infoLabel.setText(resourceMap.getString("infoLabel.text")); // NOI18N
        infoLabel.setName("infoLabel"); // NOI18N

        makeFavouriteButton.setIcon(resourceMap.getIcon("makeFavouriteButton.icon")); // NOI18N
        makeFavouriteButton.setText(resourceMap.getString("makeFavouriteButton.text")); // NOI18N
        makeFavouriteButton.setContentAreaFilled(false);
        makeFavouriteButton.setName("makeFavouriteButton"); // NOI18N
        makeFavouriteButton.setSelectedIcon(resourceMap.getIcon("makeFavouriteButton.selectedIcon")); // NOI18N

        
        //byttet om p� accept og decline button slik at de kommer i riktig rekkef�lge
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(makeFavouriteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(infoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(declineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(makeFavouriteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addComponent(titleLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(infoLabel)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(declineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(acceptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton acceptButton;
    public javax.swing.JButton declineButton;
    public javax.swing.JLabel infoLabel;
    public javax.swing.JToggleButton makeFavouriteButton;
    public javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
