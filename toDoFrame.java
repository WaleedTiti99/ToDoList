import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class toDoFrame extends JFrame implements ActionListener {
	
	private ArrayList <toDo> todo = new ArrayList <toDo> ();
	private JButton left1, left2, right1,right2, edit,save,delete,add;
	private JButton []dayss;
	private JLabel [] day_name;
	private JLabel calend,ti,loc,h,m; 
	private JPanel p1,pG,p2,pCent,Pleft; 
	private Calendar cal;
	private Color tdy,event,tdy_event ; 
	private JComboBox h1,m1,h2,m2;
	private JTextArea show; 
	
	
	private String[] days = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	
	public toDoFrame () { 
		
		tdy = new Color(255,0,0);
		event = new Color (255,255,0);
		tdy_event = new Color(255,140,0);
		
		@SuppressWarnings("static-access")
		int firstDay = getDay(cal.MONTH);
		System.out.println(firstDay);		
		
		cal = new GregorianCalendar();
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		calend = new JLabel ();
		
		dayss= new JButton[42];
		day_name = new JLabel [7];
		
		for (int i = 1; i<32;i++) {
			dayss[i] = new JButton (i+"");
		}
		pG = new JPanel ();

		pG.setLayout(new GridLayout(7,7));
		
		for(int i = 0;i<7;i++) {
			day_name[i]=new JLabel (days[i]);
			pG.add(day_name[i]);
		}

	
		
		left1 = new JButton ("<<");
		 left1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		        cal.add(Calendar.YEAR, -1);
		        updateYear();
		      }
		    });
		left2 = new JButton ("<");
		 left2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		        cal.add(Calendar.MONTH, -1);
		        updateMonth();
		      }
		    });
		right1 = new JButton (">>");
		 right1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		        cal.add(Calendar.YEAR, +1);
		        updateYear();
		      }
		    });
		right2 = new JButton (">");
		 right2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		        cal.add(Calendar.MONTH, +1);
		        updateMonth();
		      }
		    });
		 
		
		JPanel pt1=new JPanel();
		JPanel pt2=new JPanel();
		JPanel pt3=new JPanel();
		pCent = new JPanel();
		pt1.setLayout(new FlowLayout());
		pt1.add(left1);
		pt1.add(left2);
		pt2.setLayout(new FlowLayout());
		pt2.add(right2);
		pt2.add(right1);
		pt3.add(calend);

		p1.add(pt2,BorderLayout.EAST);
		p1.add(pt1,BorderLayout.WEST);
		p1.add(pt3,BorderLayout.CENTER);
		
		pCent.add(p1,BorderLayout.NORTH);
		add(pCent,BorderLayout.CENTER);
		
		
		
		this.updateMonth();
		this.updateYear();
	}
	 void updateMonth() {
		    cal.set(Calendar.DAY_OF_MONTH, 1);
		 
		    String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		    int year = cal.get(Calendar.YEAR);
		    calend.setText(month + " " + year);
		 
		   
		    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		 //   int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		    
		    @SuppressWarnings("static-access")
			int firstDay = getDay(cal.MONTH);
		    int i = firstDay-1;
		    for(int day=1;day<=numberOfDays;day++){
		   // model.setValueAt(day, i/7 , i%7 );    
		      i = i + 1;
		    // update the month 
		 
		  }
	 }
	 void updateYear() {
		    cal.set(Calendar.DAY_OF_YEAR, 1);
		 
		    String year1 = cal.getDisplayName(Calendar.YEAR, Calendar.LONG, Locale.US);
		    int month1 = cal.get(Calendar.MONTH);
		    calend.setText(year1 + " " + month1);
		 
		  
		    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		    int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		    
		    // update the year
		 
		  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("static-access")
	public int getDay(int month) {
		Calendar newCal = new GregorianCalendar(); 
		newCal.set(cal.YEAR,month, 1);
		return newCal.get(newCal.DAY_OF_WEEK);
	}
	
	
	

}
