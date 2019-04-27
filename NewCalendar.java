import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewCalendar extends JFrame {
	
	private JButton [] days ; 
	private JButton monthM,monthP,yearM,yearP; 
	private JLabel [] days_names; 
	private JLabel monthYear; 
	private String[] days_ = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	final int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
	private GregorianCalendar cal;
	Calendar today = Calendar.getInstance();
	int calYear,calMonth,calDayOfMon,calLastDate;
	static final int CAL_WIDTH = 7;
	final static int CAL_HEIGHT = 6;
	int calDates[][] = new int[CAL_HEIGHT][CAL_WIDTH];
	JPanel calOpPanel;
	JButton todayBut;
	JLabel todayLab;
	JButton lYearBut;
	JButton lMonBut;
	JLabel curMMYYYYLab;
	JButton nMonBut;
	JButton nYearBut;
	//ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();

JPanel calPanel;
	JButton weekDaysName[];
	JButton dateButs[][] = new JButton[6][7];
//	listenForDateButs lForDateButs = new listenForDateButs(); 

JPanel infoPanel;
	JLabel infoClock;


	JLabel selectedDate;

	JPanel frameBottomPanel;

	
	
	
	
	
	
	public NewCalendar () {
		
		
		setToday();
	}
	public void setToday(){
		calYear = today.get(Calendar.YEAR); 
		calMonth = today.get(Calendar.MONTH);
		calDayOfMon = today.get(Calendar.DAY_OF_MONTH);
		makeCalData(today);
	}
	private void makeCalData(Calendar cal){
		
		int calStartingPos = (cal.get(Calendar.DAY_OF_WEEK)+7-(cal.get(Calendar.DAY_OF_MONTH))%7)%7;
		if(calMonth == 1)
			calLastDate = calLastDateOfMonth[calMonth] + leapCheck(calYear);
		else calLastDate = calLastDateOfMonth[calMonth];

		for(int i = 0 ; i<CAL_HEIGHT ; i++){
			for(int j = 0 ; j<CAL_WIDTH ; j++){
				calDates[i][j] = 0;
			}
		}
	
		for(int i = 0, num = 1, k = 0 ; i<CAL_HEIGHT ; i++){
			if(i == 0) k = calStartingPos;
			else k = 0;
			for(int j = k ; j<CAL_WIDTH ; j++){
				if(num <= calLastDate) calDates[i][j]=num++;
			}
		}
	}
	private int leapCheck(int year){
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) return 1;
		else return 0;
	}
	public void updateMonth(int mon){ 
		calMonth += mon;
		if(calMonth>11) while(calMonth>11){
			calYear++;
			calMonth -= 12;
		} else if (calMonth<0) while(calMonth<0){
			calYear--;
			calMonth += 12;
		}
		cal = new GregorianCalendar(calYear,calMonth,calDayOfMon);
		makeCalData(cal);
	}
	
 
}
