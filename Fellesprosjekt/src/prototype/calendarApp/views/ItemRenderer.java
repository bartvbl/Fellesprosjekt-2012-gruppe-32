package prototype.calendarApp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class ItemRenderer implements ListCellRenderer {
	private JPanel listCell;
	private JLabel listLabel;
	
	public ItemRenderer() {
		this.listCell = new JPanel(new FlowLayout(FlowLayout.LEFT));
		listCell.setPreferredSize(new Dimension(100, 30));
		this.listLabel = new JLabel();
		listCell.add(new JCheckBox());
		listCell.add(listLabel);
		listLabel.setIcon(new ImageIcon("res/person.png"));
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		listLabel.setText((String) value);
		if(isSelected) {
			listCell.setBackground(Color.gray);
		} else {
			listCell.setBackground(Color.white);	
		}
		return listCell;
	}

}
