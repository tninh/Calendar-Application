package Calendar;

import java.util.ArrayList;

/**
 * 
 * @author Phillip, Ricardo, Tri
 * 
 */

public class Day {
	private ArrayList<Event> eventlist;
	
	public Day() {
		eventlist = new ArrayList<Event>();
	}
	
	public void add(Event e) {
		eventlist.add(e);
	}
	
	public boolean hasEvent() {
		return eventlist.isEmpty();
	}
	
	public void remove(Event e) {
		eventlist.remove(e);
	}
	
	public ArrayList<Event> getEvents() {
		return eventlist;
	}

}
