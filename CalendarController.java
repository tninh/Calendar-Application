package Calendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarController {
	
	 private CalendarModel calModel;
	 private CalendarView calView;
	
	public CalendarController(CalendarModel calModel, CalendarView calView){
		this.calModel = calModel;
		this.calView = calView;
	}
	
	
	public ActionListener changeMonth(int num) {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

}
