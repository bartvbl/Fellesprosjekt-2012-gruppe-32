package prototype.calendarApp.views;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class FrameResizer {
	private JFrame frame;

	public FrameResizer(JFrame frame) {
		ComponentAdapter adapter = new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				resize();
			}
		};
		frame.addComponentListener(adapter);
		this.frame = frame;
	}
	
	public void resize()
	{
		CalendarView.mainPanel.setBounds(0, 0, frame.getWidth()-20, frame.getHeight()-50);
		frame.validate();
		//int width = this.frame.getWidth();
		//int height = this.frame.getHeight();
	}	
}
