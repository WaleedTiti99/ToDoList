import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalendarLayout extends JFrame {
	private ArrayList <toDo> todo = new ArrayList <toDo> ();
	private JPanel Pleft,Pright,PCalendar,p1,p2,pE1,pE2,pCal;
	private JButton monthm,monthp,yearm,yearp;
	private JLabel monthYear;
	private JTextArea todoArea;
	private JLabel [] day_name;
	private JButton [] dayss;
	private Color tdy,event,tdy_event ; 
	private String[] days = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	private GregorianCalendar cal;
	private int day;
	
	public CalendarLayout () {
		
		tdy = new Color(255,0,0);
		event = new Color (255,255,0);
		tdy_event = new Color(255,140,0);
		
		cal = new GregorianCalendar();
		String monthn = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		int year = cal.get(Calendar.YEAR);
		day = cal.get(Calendar.DAY_OF_MONTH);
		
		String label = monthn;
		label =label + String.format(" %d", year);
		monthYear = new JLabel(label);
		monthYear.setHorizontalAlignment(SwingConstants.CENTER);
	
		
		
		Pleft = new JPanel();
		Pright = new JPanel();
		PCalendar = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		pE1 = new JPanel();
		pE2 = new JPanel();
		
		todoArea = new JTextArea (20,30);
		
		
		monthm = new JButton("<");
		monthm.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		    	  System.out.println("##$#$#$#$#$#$");
		    	  cal.add(Calendar.MONTH, -1);
			        updateMonth();
			    //    monthPanel(cal);
		  
		      }
		    });
		monthp = new JButton(">");
		monthp.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		        cal.add(Calendar.MONTH, +1);
		        updateMonth();
		      }
		    });
		yearm = new JButton("<<");
		yearp = new JButton(">>");

		day_name = new JLabel [7];
		dayss = new JButton [42];
		
	
		
		
		
		
		
		Pleft.setLayout(new FlowLayout());
		Pleft.add(yearm);
		Pleft.add(monthm);
		
		Pright.setLayout(new FlowLayout());
		Pright.add(monthp);
		Pright.add(yearp);
		
		p1.setLayout(new BorderLayout());
		p1.add(Pleft,BorderLayout.WEST);
		p1.add(Pright,BorderLayout.EAST);
		p1.add(monthYear,BorderLayout.CENTER);
		
		PCalendar.setLayout(new BorderLayout());
		PCalendar.add(p1,BorderLayout.NORTH);

		
		p2.setLayout(new BorderLayout());
		p2.add(pE1,BorderLayout.NORTH);
		p2.add(pE2,BorderLayout.SOUTH);
		p2.add(todoArea,BorderLayout.CENTER);
		
		add(PCalendar,BorderLayout.CENTER);
		add(p2,BorderLayout.EAST);
		this.createMonthPanel((GregorianCalendar) cal);
		
	
		
		
		
		
		
		
		
	}
		
	int getDayOfWeek(int month) {
	    GregorianCalendar g1 = new GregorianCalendar();
	    g1.set(cal.get(cal.YEAR),month, 1);
	    return g1.get(g1.DAY_OF_WEEK);
	}

	boolean has31days(int month) {
	    boolean b = false;

	    if(month>=0&&month<=6) {
	        for(int i = 1;i<8;i++) {
	            if(month%2==0) {
	                b = true;
	            }
	        }
	    }
	    else {
	        for(int i = 7;i<12;i++) {
	            if(month%2==1) {
	                b = true;
	            }
	        }
	    }

	    return b;
	}


	void createMonthPanel(GregorianCalendar cl) {
	    pCal = new JPanel();
	    pCal.setLayout(new GridLayout(7,7));
	    int month = cl.MONTH+1;

	    //System.out.println("left");
	    int dayOfWeek = getDayOfWeek(month)-1;

	    for(int i = 0;i<7;i++) {
	        day_name[i] = new JLabel (days[i]);
	        pCal.add(day_name[i]);
	    }

	    boolean b = has31days(month);

	    if(month==1){
	        int count = 0;
	        for(int i = dayOfWeek-1 ;i>=0;i--,count++){
	            dayss[count]=new JButton(31-i+"");
	            dayss[count].setEnabled(false);
	        }
	        if(((GregorianCalendar) cl).isLeapYear(cl.YEAR)){
	            for(int i = 1;i<=29;i++,count++){
	                dayss[count]=new JButton(i+"");
	            }
	        }
	        else {
	            for(int i = 1;i<=28;i++,count++) {
	                dayss[count]=new JButton(i+"");
	            }
	        }
	        for(int i = count,c = 1;i<42;i++,c++,count++) {
	            dayss[count]=new JButton(c+"");
	            dayss[count].setEnabled(false);
	        }
	    } 
	    else if(month==2) {
	        int count = 0;
	        for(int i = dayOfWeek-1 ;i>=0;i--,count++) {
	            if(((GregorianCalendar) cl).isLeapYear(cl.YEAR)) {
	                dayss[count]=new JButton(29-i+"");
	                dayss[count].setEnabled(false);
	            }
	            else {
	                dayss[count]=new JButton(28-i+"");
	                dayss[count].setEnabled(false);
	            }

	        }
	        for(int i = 1;i<32;i++,count++) {
	            dayss[count]=new JButton(i+"");
	        }
	        for(int i = count,c = 1;i<42;i++,c++,count++) {
	            dayss[count]=new JButton(c+"");
	            dayss[count].setEnabled(false);
	        }
	    }
	    else if(!has31days(month)||month==0||month==7||month==0) {
	        int count = 0;
	        for(int i = dayOfWeek-1 ;i>=0;i--,count++) {
	            dayss[count]=new JButton(31-i+"");
	            dayss[count].setEnabled(false);
	        }
	        if(month==7||month==0) {
	            for(int i = 1;i<32;i++,count++) {
	                dayss[count]=new JButton(i+"");
	            }
	        }
	        else {  
	            for(int i = 1;i<31;i++,count++){
	                dayss[count]=new JButton(i+"");
	            }
	        }

	        for(int i = count,c = 1;i<42;i++,c++,count++){
	            dayss[count]=new JButton(c+"");
	            dayss[count].setEnabled(false);
	        }
	    }

	    else if(month!=1) {
	        int count = 0;
	        for(int i = dayOfWeek-1 ;i>=0;i--,count++) {
	            dayss[count]=new JButton(30-i+"");
	            dayss[count].setEnabled(false);
	        }
	        for(int i = 1;i<32;i++,count++) {
	            dayss[count]=new JButton(i+"");
	        }
	        for(int i = count,c = 1;i<42;i++,c++,count++)
	        {
	            dayss[count]=new JButton(c+"");
	            dayss[count].setEnabled(false);
	        }
	    }

	    for(int i = 0;i<42;i++) {
	        pCal.add(dayss[i]);
	    }

	    PCalendar.add(pCal,BorderLayout.CENTER); 
	}

	void updateMonth() {
	    cal.set(Calendar.DAY_OF_MONTH, 1);

	    String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
	    int year = cal.get(Calendar.YEAR);
	    monthYear.setText(month + " " + year);

	    createMonthPanel(cal);
	}
			   
			 
			   
			 
			
			  }
	
	 
		  
	
	
	
	
	
	
	


