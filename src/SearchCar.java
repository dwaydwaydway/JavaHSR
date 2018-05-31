//This is the first step of ordering the tickets


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




public class SearchCar extends Messenger {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


//	public enum Station {
//		NANGANG, TAIPEI, BANQIAO, TAOYUAN, HSINCHU, MIAOLI, 
//		TAICHUNG, TAINAN, CHANGHUA, YUNLIN, CHIAYI, ZUOYING
//	}
//	public enum PassengerType {
//		NORMAL, CHILD, ELDER, DISABLE, STUDENT
//	}
//	public enum Seat {
//		NONE, WINDOW, AISE
//	}
//	public enum Carriage {
//		STANDARD, BUSINESS
//	}
	
	Station depart;
	Station arrive;
	PassengerType passengertype;
	Seat seat;
	Carriage carriage;
	int[] quantity = {0,0,0,0,0};
	int total;
	Date depart_time;
	SimpleDateFormat ft2 = 
		      new SimpleDateFormat ("yyyy.MM.dd-HH:mm");

	//boolean early;   //early should be verified on server or data base
	
	
	
	
	
	public SearchCar() {
		depart = null;
		arrive = null;
		passengertype = PassengerType.NORMAL;
		seat = Seat.NONE;
		carriage = Carriage.STANDARD;
		quantity[0] = 0;
		quantity[1] = 0;
		quantity[2] = 0;
		quantity[3] = 0;
		quantity[4] = 0;
		total = getTotal();
		depart_time =  new Date();   //the current time
	}
	
	
	//for testing
	public SearchCar(int x) {
		String date_input;
		date_input = "2018.11.11-13:30";
		
		depart = Station.TAIPEI;
		arrive = Station.TAICHUNG;
		passengertype = PassengerType.NORMAL;
		seat = Seat.NONE;
		carriage = Carriage.STANDARD;
		quantity[0] = 1;
		quantity[1] = 0;
		quantity[2] = 0;
		quantity[3] = 0;
		quantity[4] = 0;
		total = getTotal();
	   try { 
           depart_time = ft2.parse(date_input);
       } 
	   catch (ParseException e) { 
           System.out.println("Unparseable using " + ft2); 
	   }
	}
	
	
	public Station getDepart() {
		return depart;
	}
	
	
	public Station getArrive() {
		return arrive;
	}
	
	public PassengerType getPassenerType() {
		return passengertype;
	}

	public Seat getSeat() {
		return seat;
	}
	
	public Carriage getCarriage() {
		return carriage;
	}
	
	public Date getDepartTime() {
		return depart_time;
		
	}
	
	
	public void setDepart(Station depart) {
		this.depart = depart;
	}
	
	public void setArrive(Station arrive) {
		this.arrive = arrive;
	}
	
	public void setPassenerType(PassengerType passengertype) {
		this.passengertype = passengertype;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	public void setCarriage(Carriage carriage) {
		this.carriage = carriage;
	}
	
	public void setDepartTime(Date date) {
		this.depart_time = date;
		
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
		output = "Depart from " + this.getDepart() + " at " + this.getDepartTime() + "\n";
		output = output + "Arrive at " + this.getArrive() + "\n";
		output = output + "PassengerType is " + this.getPassenerType() + "\n";
		output = output + "Seat is " + this.getSeat() + "\n";
		output = output + "Tickets of Normal  " + quantity[0] + "\n";
		output = output + "Tickets of Child   " + quantity[1] + "\n";
		output = output + "Tickets of Elder   " + quantity[2] + "\n";
		output = output + "Tickets of Disable " + quantity[3] + "\n";
		output = output + "Tickets of Student " + quantity[4] + "\n";
		output = output + "Sum of tickets " + this.getTotal() + "\n";
		
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
	
	
