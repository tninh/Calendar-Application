package Calendar;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Calendar {
	
	public static void main(String[] args){
		
		final JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(550, 400));
        
        CalendarModel calModel = new CalendarModel();
        final CalendarView calendar = new CalendarView(calModel);
		frame.add(calendar.headerSetUp());
		frame.add(calendar.monthPanelSetUp());
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
