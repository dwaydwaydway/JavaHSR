package message;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SearchDaily implements Serializable{
	private static final long serialVersionUID = 1L;
	Date depart_day_temp; // day save in 
	String depart_dayofweek;
	SimpleDateFormat ft2 = 
		      new SimpleDateFormat ("yyyy-MM-dd");
	SimpleDateFormat dayofweek = new SimpleDateFormat("E", Locale.ENGLISH);
	
	private String carID;
	private String depart_time;
	private String depart_day;  // in the form of "1995-02-03"
	
	public String getCarID() {
		return this.carID;
	}
	public String getDepart(){
		return this.depart_time;
	}
	public String getDepartDay() {
		return this.depart_day;
	}
	
	
	public void setCarID(String input) {
		this.carID = input;
	}
	public void setDepart_time(String string) {
		this.depart_time = string;
	}

	public void setDepartDay(String inputDate) {
		
		
		//input(string) turn into date in depart_day_temp;
		try { 
	           depart_day_temp = ft2.parse(inputDate);
	       } 
		   catch (ParseException e) { 
	           System.out.println("Unparseable using " + ft2); 
		   }
		
		//use depart_day_temp(date) to print out depart_day(String) and depart_dayofweek

		depart_day = ft2.format(depart_day_temp);
		depart_dayofweek = dayofweek.format(depart_day_temp);
		
	}
}
