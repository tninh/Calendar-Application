package Calendar;

import javax.swing.JFrame;

public class dayView {
	private int size;
	public dayView(int size)
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
