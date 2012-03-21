package fp.components.favouritePersonListItem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

public class FavouritePersonListItem extends JPanel {
	public FavouritePersonListItem() {
		super(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(250, 30));
		MouseListener mouseHandler = new FavouritePersonListItemMouseHandler(this);
		this.addMouseListener(mouseHandler);
		JButton button = new JButton();
		button.setIcon(new ImageIcon("res/star_minus.png"));
		button.setRolloverIcon(new ImageIcon("res/star_minus_hover.png"));
		button.addMouseListener(mouseHandler);
		button.setContentAreaFilled(false);
		button.setPreferredSize(new Dimension(30, 30));
		this.add(button);
	}
}
