package Calendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class CalendarView {
	
	private static final int TEXTWIDTH = 10;
	private static final int ROWS = 7;
	private static final int COLUMNS = 7;
	private static final int DAYS_IN_A_WEEK = 7;
	private static final String monthLabel = "Month";
	private static final String weekLabel = "Week";
	private static final String dayLabel = "Day";
	
	private CalendarModel calModel;
    private CalendarController calController;
	private JButton monthButton;
	private JButton weekButton;
	private JButton dayButton;
	private JPanel headerPanel;
	private JPanel monthPanel;
	private JPanel monthPanelHeader;
	private JPanel monthCalendarPanel;
	private JPanel weekPanel;
	private JScrollPane dayScrollPane;
	private JFrame frame2;
	private JButton addEvent;
	
	public CalendarView(CalendarModel calModel) {
		this.calModel = calModel;
		calController = new CalendarController(calModel, this);
		monthPanel = new JPanel();
		weekPanel = new JPanel();
		dayScrollPane = new JScrollPane();
		
	}
	
	public void monthButtonSetUp(){
		monthButton = new JButton(monthLabel);
		monthButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//return monthButton;
	}
	
	public void weekButtonSetUp(){
		weekButton = new JButton(weekLabel);
		weekButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				monthPanel.setVisible(false);
				dayScrollPane.setVisible(false);
			}
		});
	}
	
	public void dayButtonSetUp(){
		dayButton = new JButton(dayLabel);
		dayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				monthPanel.setVisible(false);
				weekPanel.setVisible(false);
			}
		});
	
		//return dayButton;
	}
	
	public JPanel headerSetUp() {
		headerPanel = new JPanel(new FlowLayout());
		monthButtonSetUp();
		weekButtonSetUp();
		dayButtonSetUp();
		headerPanel.add(monthButton);
		headerPanel.add(weekButton);
		headerPanel.add(dayButton);
		return headerPanel;
	}
	
	public JPanel monthPanelSetUp(){
		monthPanel.setLayout(new BorderLayout(2,2));
		monthCalendarPanel = new JPanel();
		
		monthPanelHeader = new JPanel(new FlowLayout());
		JButton prevMonthButton = new JButton("<");
		JButton nextMonthButton = new JButton(">");
		JLabel currentMonthLabel = new JLabel(calModel.getMonthName());

		
		prevMonthButton.addActionListener(calController.changeMonth(-1));
		nextMonthButton.addActionListener(calController.changeMonth(1));
		
		monthPanelHeader.add(prevMonthButton);
		monthPanelHeader.add(currentMonthLabel);
		monthPanelHeader.add(nextMonthButton);
		
		
		JLabel[] daysOfWeek = {new JLabel("Su", SwingConstants.CENTER), new JLabel("Mo", SwingConstants.CENTER), 
								new JLabel("Tu",SwingConstants.CENTER), new JLabel("We", SwingConstants.CENTER), 
								new JLabel("Th", SwingConstants.CENTER), new JLabel("Fr", SwingConstants.CENTER), new JLabel("Sa", SwingConstants.CENTER)};
		
		monthCalendarPanel.setLayout(new GridLayout(ROWS, COLUMNS));
			
		for(int i = 0; i < (ROWS * COLUMNS); i++)
		{
			if(i < DAYS_IN_A_WEEK){
				monthCalendarPanel.add(daysOfWeek[i]);
			}
			else{
				monthCalendarPanel.add(new JButton(Integer.toString(i)));
			}
		}
		
		monthPanel.add(monthPanelHeader, BorderLayout.NORTH);
		monthPanel.add(monthCalendarPanel, BorderLayout.CENTER);
		
		return monthPanel;
	}
	
	public JPanel weekPanelSetUp() {
		
		return weekPanel;
	}
	
	public void eventMaker(){
		frame2 = new JFrame("Event Maker");
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.pack();
		frame2.setSize(500,300);
		JPanel eventPanel = new JPanel();
		JPanel monthPanel = new JPanel();
		eventPanel.setLayout(new BorderLayout(2,2));
		monthPanel.setLayout(new BorderLayout(2,2));
		JPanel chooseDatePanel = new JPanel(new FlowLayout());
		JPanel chooseTimePanel = new JPanel(new BorderLayout(2,2));
		JPanel submitPanel = new JPanel(new FlowLayout());
		JPanel textAreaPanel = new JPanel(new FlowLayout());
		JPanel northTime = new JPanel(new FlowLayout());
		
		eventPanel.setVisible(true);
		northTime.setVisible(true);
		chooseTimePanel.setVisible(true);
		textAreaPanel.setVisible(true);
		eventPanel.add(new JLabel("Choose a date and time then write a description and save!", SwingConstants.CENTER), BorderLayout.NORTH);
		
		String[] months = {"January", "February", "March","April","May","June","July","August","September","October","November","December"};
		SpinnerListModel monthModel = new SpinnerListModel(months);
		JSpinner spinner = new JSpinner(monthModel);
		
		int[] days = new int[31];
		for(int i = 0; i < 31; i++){
			days[i] = i + 1;
		}
		SpinnerNumberModel dayModel = new SpinnerNumberModel(1,1,31,1);
		JSpinner daySpinner = new JSpinner(dayModel);
		int[] time = new int[24];
		for(int j = 0; j < 24; j++){
			time[j] = j;
		}
		String[] years = {"2015", "2016"};
		SpinnerListModel yearModel = new SpinnerListModel(years);
		JSpinner yearSpinner = new JSpinner(yearModel);
		SpinnerNumberModel timeModel = new SpinnerNumberModel(1,1,12,1);
		JSpinner timeSpinner = new JSpinner(timeModel);
		
		String[] TOD = {"a.m", "p.m"};
		SpinnerListModel TODModel = new SpinnerListModel(TOD);
		JSpinner TODSpinner = new JSpinner(TODModel);
		
		chooseDatePanel.add(spinner);
		chooseDatePanel.add(daySpinner);
		chooseDatePanel.add(yearSpinner);
		northTime.add(timeSpinner);
		northTime.add(TODSpinner);
		chooseTimePanel.add(northTime, BorderLayout.NORTH);
		chooseTimePanel.add(new JTextArea(1,1), BorderLayout.CENTER);
		submitPanel.add(new JButton("Submit"));
		//monthPanel.add(timeSpinner);
		monthPanel.add(chooseDatePanel, BorderLayout.NORTH);
		monthPanel.add(chooseTimePanel, BorderLayout.CENTER);
	
		eventPanel.add(monthPanel, BorderLayout.CENTER);
		
		monthPanel.add(submitPanel, BorderLayout.SOUTH);
		frame2.add(eventPanel);
		
		//frame2
		
		
	}
	/*
	private void testEventFrame(){
		JFrame testEventFrame = new JFrame();
		testEventFrame.setLayout(new FlowLayout());
		
		JPanel test = new JPanel();
		//testEventFrame.add
	}*/
	
	/*
	public static void main(String[] args){
		CalendarView calendar = new CalendarView();
		calendar.monthButtonSetUp();
		calendar.weekButtonSetUp();
		calendar.dayButtonSetUp();
		calendar.panelSetUp();
		calendar.frameSetUp();
		//calendar.eventMaker();
	}*/

}
