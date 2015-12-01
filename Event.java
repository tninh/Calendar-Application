package Calendar;

import java.util.Date;

/**
 * @authors Phillip, Ricardo, Tri
 * 
 * Event class that holds an event on the calendar
 */

public class Event implements Comparable {
	
	Date startTime; //starting time of the event
	int duration; //duration of event in minutes
	String description; //description of the event
	
	public Event(Date time, int duration, String description) {
		this.startTime = time;
		this.duration = duration;
		this.description = description;
	}

	/**
	 * The natural order of an event is based on its time
	 */
	@Override
	public int compareTo(Object o) {
		Event e = (Event) o;
		return startTime.compareTo(e.getStartTime());
	}

	
	//Past this point are the getters and setters for the variables
	
	public Date getStartTime() {
		return startTime;
	}

	@Override
	public String toString() {
		return startTime.getTime()+" " + duration + " "+description;
	}

	public void setStartTime(Date time) {
		this.startTime = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDate() {
		return startTime.getDate();
	}
	
	public int getMonth() {
		return startTime.getMonth();
	}
}
