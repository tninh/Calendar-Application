package Calendar;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DayPanel extends JPanel {
	
	private static final int HOURS_IN_DAY = 24;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 800;
	
	Date date;
	ArrayList<Event> events;
	
	public DayPanel(Date date, ArrayList<Event> events) {
		this.date = date;
		this.events = events;
		this.add(populate());
	}
	
	public JScrollPane populate() {
		JPanel base = new JPanel();
		base.setPreferredSize(new Dimension(WIDTH, HEIGHT*3));
		for (int i=0;i<HOURS_IN_DAY;i++) {
			for (Event e: events) {
				if (e.getHour()==i) {
					base.add(new EventPanel(e, i));
				}
				else base.add(new EventPanel(i));
			}
		}
		JScrollPane scroll = new JScrollPane(base);
		scroll.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		return scroll;
	}
	
	class EventPanel extends JPanel {
		private static final int EVENT_HEIGHT = 25;
		private static final int LABEL_WIDTH = 50;
		
		Event event;
		int hour;
		
		EventPanel(int hour){
			event = null;
			this.hour=hour;
			setUp();
		}
		
		EventPanel(Event e, int hour) {
			event = e;
			this.hour=hour;
			setUp();
		}
		
		void setUp() {
			this.setPreferredSize(new Dimension(WIDTH-10, EVENT_HEIGHT));
			
			JLabel time = new JLabel(hour+":00");
			time.setPreferredSize(new Dimension(LABEL_WIDTH, EVENT_HEIGHT-5));
			
			JLabel description = new JLabel();
			description.setPreferredSize(new Dimension(500, EVENT_HEIGHT));
			if (event!=null) {
				description.setText(event.getDescription());
			}
			
			this.add(time);
			this.add(description);
		}
	}
}
