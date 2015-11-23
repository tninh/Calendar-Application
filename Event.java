package Calendar;

import java.sql.Date;
import java.util.Calendar;

/**
 * @authors Phillip, Ricardo, Tri
 * 
 * Event class that holds an event on the calendar
 */

public class Event implements Comparable{
	
	Calendar time;
	String name;
	String description;
	
	public Event(Calendar time, String name, String description) {
		this.time = time;
		this.name = name;
		this.description = description;
	}

	/**
	 * The natural order of an event is based on its time
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Event e = (Event) o;
		return time.compareTo(e.getTime());
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
