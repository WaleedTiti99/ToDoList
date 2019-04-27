import java.util.*;

public class toDo {
	private String Title = new String();
	private String Location = new String();
	private Calendar Date; 
	private Time Start; 
	private Time End; 
	
public toDo () {
		
	}
	
	public void setTitle (String Title) {
		this.Title = Title;
	}
	
	public void setLocation(String Location) {
		this.Location = Location; 
	}
	
	public void setDate (Calendar Date) {
		this.Date = Date; 
	}
	public void setStart (Time Start) {
		this.Start = Start; 
	}
	public void setEnd (Time End) {
		this.End = End; 
	}
	
	public String getTitle () {
		return this.Title;
	}
	public String getLocation () {
		return this.Location; 
	}
	
	public Calendar getDate () {
		return this.Date;
	}
	
	public int getStartH () {
		return this.Start.getHour();
	}
	public int getStartM () {
		return this.Start.getMinute();
	}
	
	public int getEndH () { 
		return this.End.getHour();
	}
	public int getEndM () { 
		return this.End.getMinute();
	}
	
	


}
