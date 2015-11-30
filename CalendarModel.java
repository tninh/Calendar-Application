package Calendar;

import java.util.GregorianCalendar;

public class CalendarModel {

	private GregorianCalendar gCal;
	private GregorianCalendar currentMonth;
	private String[] months = new String[12];
	private int day;
	
	
	public CalendarModel()
	{
		gCal = new GregorianCalendar();
		currentMonth = new GregorianCalendar(gCal.get(GregorianCalendar.YEAR), gCal.get(GregorianCalendar.MONTH), 1);
		months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September","October","November","December"};
	}
	
	public GregorianCalendar getGCal(){
		return gCal;
	}
	
	public int getDay(){
		return day;
	}
	
	public void setDay(int newDay){
		day = newDay;
	}
	
	public int getDayOfTheWeek_MONTH() {
		int firstDay = currentMonth.get(GregorianCalendar.DAY_OF_WEEK);
		return firstDay;
		 
	}
	
	public int numOfDays_Month() {
		int numOfDays = currentMonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		return numOfDays;
	}
	
	
	public int getMonth(){
		return gCal.get(GregorianCalendar.MONTH);
	}
	
	public String getMonthName(){
		return months[getMonth()]; // changed from CalendarExample
	}
	
	public void updateMonth(int newMonth){
		gCal.set(GregorianCalendar.MONTH, newMonth);
	}
	
	public int getYear() {
		return gCal.get(GregorianCalendar.YEAR);
	}
	
	
}
