package fp.components.favouritePersonListItem;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FavouritePersonListItemMouseHandler implements MouseListener {

	private FavouritePersonListItem component;

	public FavouritePersonListItemMouseHandler(FavouritePersonListItem favouritePersonListItem) {
		this.component = favouritePersonListItem;
	}

	public void mouseEntered(MouseEvent event) {
		this.component.setBackground(Color.gray);
	}

	public void mouseExited(MouseEvent event) {
		this.component.setBackground(Color.white);
	}

	public void mouseClicked(MouseEvent event) {}
	public void mousePressed(MouseEvent event) {}
	public void mouseReleased(MouseEvent event) {}

}
