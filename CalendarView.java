package Calendar;
import java.awt.BorderLayout;
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
	private static final String monthLabel = "Month";
	private static final String weekLabel = "Week";
	private static final String dayLabel = "Day";
	
	private JFrame frame;
	private JButton monthButton;
	private JButton weekButton;
	private JButton dayButton;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JFrame frame2;
	private JButton addEvent;
	
	private void monthButtonSetUp(){
		monthButton = new JButton(monthLabel);
		//monthButton.addActionListener(l);
	}
	
	private void weekButtonSetUp(){
		weekButton = new JButton(weekLabel);
	}
	
	private void dayButtonSetUp(){
		dayButton = new JButton(dayLabel);
		dayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dayView presentDayView = new dayView(700);
				presentDayView.showDay();
			}
		});
			
	}
	
	private void panelSetUp(){
		panel = new JPanel();
		scrollPane = new JScrollPane(panel);
		addEvent = new JButton("Add Event");
		
		
		// month view
		/*
		panel.setLayout(new GridLayout(5, 7));
		for(int i = 1; i <32; i++ ){
			panel.add(new JButton(Integer.toString(i)));
		}
		panel.setVisible(true);*/
		
		
		panel.setLayout(new BorderLayout(2,2));
		JPanel hourLabels = new JPanel(new GridLayout(0,1,1,1));
		JPanel deleteButtons = new JPanel(new GridLayout(0,1,1,1));
		//JPanel numberPanel = new JPanel();
		//numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.PAGE_AXIS));
		for(int i = 0; i < 25; i++){
			
			hourLabels.add(new JTextField(Integer.toString(i) + ":00"));
			deleteButtons.add(new JButton("Delete"));
			//numberPanel.add(new JLabel(Integer.toString(i)));
				
		}
		
		panel.add(addEvent, BorderLayout.NORTH);
		addEvent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				eventMaker();
				
			}
		});
		panel.add(hourLabels, BorderLayout.CENTER);
		panel.add(deleteButtons, BorderLayout.EAST);
		//panel.add(numberPanel, BorderLayout.WEST);
		
		//JScrollPane scroll = new JScrollPane(panel);
		//scroll.add(scroll, BorderLayout.CENTER);
		scrollPane.setPreferredSize(new Dimension(400,200));
		scrollPane.setVisible(true);
		panel.setVisible(true);
		hourLabels.setVisible(true);
		deleteButtons.setVisible(true);
		
	
		
	}
	
	private void frameSetUp(){
		frame = new JFrame("Calendar");
		frame.setLayout(new FlowLayout());
		frame.setSize(500, 300);
		frame.setResizable(false);
		frame.add(monthButton);
		frame.add(weekButton);
		frame.add(dayButton);
		frame.add(scrollPane);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void eventMaker(){
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
	
	
	public static void main(String[] args){
		CalendarView calendar = new CalendarView();
		calendar.monthButtonSetUp();
		calendar.weekButtonSetUp();
		calendar.dayButtonSetUp();
		calendar.panelSetUp();
		calendar.frameSetUp();
		//calendar.eventMaker();
	}

}
