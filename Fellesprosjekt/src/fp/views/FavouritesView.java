package fp.views;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fp.components.InteractiveList;
import fp.components.favouritePersonListItem.FavouritePersonListItem;

public class FavouritesView {
	public FavouritesView() {
		InteractiveList<JPanel> list = new InteractiveList<JPanel>();
		CalendarView.peopleListScrollPane.setViewportView(list);
		list.addInteractiveItem(new FavouritePersonListItem());
		list.addInteractiveItem(new FavouritePersonListItem());
		list.addInteractiveItem(new FavouritePersonListItem());
		list.addInteractiveItem(new FavouritePersonListItem());
		list.addInteractiveItem(new FavouritePersonListItem());
		list.addInteractiveItem(new FavouritePersonListItem());
		list.addInteractiveItem(new FavouritePersonListItem());
		list.addInteractiveItem(new FavouritePersonListItem());
		list.validate();
	}
}
