package message;
//This is the first step of ordering the tickets
//all string


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * After the users input their order, we should generate a SearchCar object to check 
 * whether there is any car meeting their order in the database.
 *Information:
 * 1.depart station
 * 2.arrive station
 * 3.passenger type(NORMAL, CHILD, ELDER, DISABLE, STUDENT)
 * 4.seat(NONE, WINDOW, AISE)
 * 5.carriage(STANDARD, BUSINESS)
 * 6.quantity(it means the numbers of different kinds of tickets the user want to buy)
 * 7.total(the total number of the tickets that user wants to buy)
 * 8.depart time
 */
public class SearchCar implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String depart;
	String arrive;
	String seat;
	String carriage;
	public int[] quantity = {0,0,0,0,0};
	int total;
	Date depart_day_temp; // day save in 
	
	String depart_day;
	String depart_dayofweek;
	SimpleDateFormat ft2 = 
		      new SimpleDateFormat ("yyyy-MM-dd");
	
	SimpleDateFormat dayofweek = new SimpleDateFormat("E", Locale.ENGLISH);
	
	int hour;
	int minute;

	//boolean early;   //early should be verified on server or data base
	
	
	
	
	
	public SearchCar() {
		depart = "TAIPEI";
		arrive = "ZUOYING";
		seat = "NONE";
		carriage = "STANDARD";
		quantity[0] = 0;
		quantity[1] = 0;
		quantity[2] = 0;
		quantity[3] = 0;
		quantity[4] = 0;
		total = getTotal();
		hour = 00;
		minute = 30;
		depart_day_temp =  new Date();   //the current time
		
		depart_day = ft2.format(depart_day_temp);
		
		depart_dayofweek = dayofweek.format(depart_day_temp);
	}
	
	
	//for testing
	public SearchCar(int x) {
		String date_input;
		date_input = "2018-11-11";
		
		depart = "BANQIAO";
		arrive = "HSINCHU";
		seat = "NONE";
		carriage = "STANDARD";
		quantity[0] = 1;
		quantity[1] = 0;
		quantity[2] = 0;
		quantity[3] = 0;
		quantity[4] = 0;
		total = getTotal();
		hour = 13;
		minute = 20;
		
	   try { 
           depart_day_temp = ft2.parse(date_input);
       } 
	   catch (ParseException e) { 
           System.out.println("Unparseable using " + ft2); 
	   }
	   
	   
		depart_day = ft2.format(depart_day_temp);
		
		depart_dayofweek = dayofweek.format(depart_day_temp);
	}
	
	
	public String getDepart() {
		return depart;
	}
	
	
	public String getArrive() {
		return arrive;
	}
	
	public String getTime() {
		return hour + ":" + minute;
	}
	public String getSeat() {
		return seat;
	}
	
	public String getCarriage() {
		return carriage;
	}
	
	public String getDepartDay() {
		return depart_day;
		
	}
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	
	public String getDayofWeek() {
		return depart_dayofweek;
	}
	
	
	
	public void setDepart(String string) {
		this.depart = string;
	}
	
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	


	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	public void setCarriage(String carriage) {
		this.carriage = carriage;
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
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	
	
	
	
	public int getTotal() {
		int temp = 0;
		for(int i=0; i<5; i++) {
			temp = quantity[i] + temp;
		}
		return temp;
	}
	
	public String toString() {
		String output = null;
		output = "Depart from " + this.getDepart() + " at " + this.getDepartDay() + " at " + this.getHour() + " : " + this.getMinute() + "\n";
		output = output + "Arrive at " + this.getArrive() + "\n";
		output = output + "Seat is " + this.getSeat() + "\n";
		output = output + "Tickets of Normal  " + quantity[0] + "\n";
		output = output + "Tickets of Child   " + quantity[1] + "\n";
		output = output + "Tickets of Elder   " + quantity[2] + "\n";
		output = output + "Tickets of Disable " + quantity[3] + "\n";
		output = output + "Tickets of Student " + quantity[4] + "\n";
		output = output + "Sum of tickets " + this.getTotal() + "\n";
		output = output + "Day of week is " + this.getDayofWeek();
		
		return output;

	}
	
	
	public static void main(String args[]) {
//		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
//		SimpleDateFormat ft2 = 
//			      new SimpleDateFormat ("yyyy.MM.dd-HH:mm");
//	      String input = args.length == 0 ? "1818.11.11-13:30 " : args[0]; 
//
//	      System.out.print(input + " Parses as "); 
//
//	      Date t; 
//
//	      try { 
//	          t = ft2.parse(input); 
//	          System.out.println(t); 
//	          //System.out.println("2: " + ft2.format(t));
//	          
//	      } catch (ParseException e) { 
//	          System.out.println("Unparseable using " + ft); 
//	          
//	        
//	      }
		
		SearchCar test1 = new SearchCar();
		SearchCar test2 = new SearchCar(1);
		System.out.println("test1 " + test1.toString());
		System.out.println("test2 " + test2.toString());
	   }
	}
	
	
