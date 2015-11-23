package Calendar;

import javax.swing.JFrame;

public class DayView {
	private int size;
	public DayView(int size)
	{
		this.size = size;
	}
	
	public void showDay()
	{
		JFrame dayView = new JFrame("Day View");
		dayView.setSize(400, 500);
		dayView.setVisible(true);
		
		
	}
}
