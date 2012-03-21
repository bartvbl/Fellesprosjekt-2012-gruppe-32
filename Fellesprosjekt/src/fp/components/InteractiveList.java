package fp.components;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class InteractiveList<ListItemDataType extends JPanel> extends JLayeredPane {
	private ArrayList<ListItemDataType> listContents = new ArrayList<ListItemDataType>();
	
	public InteractiveList() {
		
	}
	
	public void addInteractiveItem(ListItemDataType item) {
		this.add(item, this.listContents.size());
		this.listContents.add(item);
	}
	
	public void clearListContents() {
		this.listContents.clear();
		this.removeAll();
	}
	
	public void validate() {
		int offset = 0;
		for(ListItemDataType listItem : listContents) {
			
			Dimension preferredSize = listItem.getPreferredSize();
			listItem.setBounds(0, offset, preferredSize.width, preferredSize.height);
			offset += preferredSize.height;
		}
		int preferredWidth = this.getPreferredSize().width;
		this.setPreferredSize(new Dimension(preferredWidth, offset));
		super.validate();
	}
}
