package fp.components.calendarViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewMeetingHandler implements ActionListener {

	public void actionPerformed(ActionEvent event) {
		String actionCommand = event.getActionCommand();
		int dayIndex = Integer.parseInt(actionCommand.split(" ")[4]);
		
	}

}
