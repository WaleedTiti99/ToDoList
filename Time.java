public class Time {
	
private int hour ; 
private int minute; 

public Time () {
	
}

public int getHour() {
	return this.hour;
}
public int getMinute() {
	return this.minute;
}
public void setTime(int h, int m) {
	hour = ((h>=0 && h<24) ? h : 0); 
	minute = ((m>=0 && m<60) ? m : 0); 
}

public String printTime() {
	
	return this.getHour() + ":" + this.getMinute();
}



}
