package prototype.calendarApp.core;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class ItemRenderer implements ListCellRenderer {
	private JPanel listCell;
	private JLabel listLabel;
	
	public ItemRenderer() {
		this.listCell = new JPanel();
		listCell.setPreferredSize(new Dimension(100, 30));
		this.listLabel = new JLabel();
		listCell.add(listLabel);
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		listLabel.setText("blurk");
		if(isSelected) {
			listCell.setBackground(Color.gray);
		} else {
			listCell.setBackground(Color.white);	
		}
		return listCell;
	}

}
