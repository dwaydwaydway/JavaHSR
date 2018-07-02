package message;

import java.io.Serializable;


/**
 * After checking the SearchOrder in the database, we should create an object of OrderResult, and
 * return it to Client.
 * 
 * Information:
 * 0.transaction_number
 * 1.carID;
 * 2.userID;
 * 3.depart station;
 * 4.arrive station;
 * 5.depart_time;
 * 6.arrive_time;
 * 7.passenger_type;
 * 8.carriage;
 * 9.early_discount(65,75...or none)
 * 10.compartment
 * 11.location
 *
 */
public class Ticket implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    private String transaction_number;     // sending server ==null                        sending to client = valid number.
		private String carID;
		private String userID;
		private String depart;
		private String arrive;
		private String depart_time;  //include day and hour, minute in the form of "1995-02-03,18:03"
		private String arrive_time;  //include day and hour, minute in the form of "1995-02-03,18:03"
		private String passenger_type;
		private String carriage;
		private String early_discount;  //"0.65", "0.8", "0.9" or "NONE"
		private String university_discount; //"0.5", "0.7", "0.85" or "NONE"
		private String compartment;  //sending to server == null                                sending to client = int
		private String location;    // sending to sever == seat Type {WINDOW, NONE, AISLE}      sending to client = A2  E19.....
		private String price;       //sending to sever price will be correct
 
		
		
		/**
		 * This is the default constructor which will set each element into "invalid"
		 * @param nothing
		 */
		public Ticket() {
			transaction_number = carID = userID =  depart = arrive = depart_time = arrive_time = passenger_type = 
					carriage = early_discount = university_discount= compartment = location = price = "invalid";

		}
		
		
		
		
		//for testing
		public Ticket(int x) {
			this.transaction_number = "gggg";
			this.carID = "0205";
			this.userID = "shaopoo";
			this.depart = "NTU";
			this.arrive = "HELL";
			this.arrive_time = "1995-02-03,18:03";
			this.depart_time = "1997-10-03,14:15";
			this.passenger_type = "STUDENT";
			this.carriage = "STANDER";
			this.early_discount = "NONE";
			this.university_discount = "NONE";
			this.compartment = "1";
			this.location = "A1";
			this.price = "1240";
			
		}
		
		//for testing2
		public Ticket(int x, int y) {
			this.transaction_number = "cc";
			this.carID = "0305";
			this.userID = "isaiah";
			this.depart = "NTU";
			this.arrive = "HAVEN";
			this.arrive_time = "1993-12-03,18:03";
			this.depart_time = "1997-04-03,14:15";
			this.passenger_type = "STUDENT";
			this.carriage = "STANDER";
			this.early_discount = "NONE";
			this.university_discount = "NONE";
			this.compartment = "1";
			this.location = "A1";
			this.price = "1240";
			
		}
		
		
		
		/**
		 *This is the constructor which will set all the elements into right value 
		 *@param (String transaction_number, String carID, String userID, String depart, String arrive, 
				String depart_time, String arrive_time, String passenger_type, String carriage,
				String early_discount,String university_discount, String compartment, String location, String price)
		 */
		public Ticket(String transaction_number, String carID, String userID, String depart, String arrive, 
				String depart_time, String arrive_time, String passenger_type, String carriage,
				String early_discount, String university_discount, String compartment, String location, String price)
		{
			
			this.transaction_number = transaction_number;
			this.carID = carID;
			this.userID = userID;
			this.depart = depart;
			this.arrive = arrive;
			this.arrive_time = arrive_time;
			this.depart_time = depart_time;
			this.passenger_type = passenger_type;
			this.carriage = carriage;
			this.early_discount = early_discount;
			this.university_discount = university_discount;
			this.compartment = compartment;
			this.location = location;
			this.price = price;
			//System.out.println("Constructed Ticket");
		}
		

		public String getCarID() {
			return this.carID;
		}
		public String getUserID() {
			return this.userID;
		}
		public String getDepart(){
			return this.depart;
		}
		public String getArrive() {
			return this.arrive;
		}
		public String getDepartTime() {
			return this.depart_time;
		}
		public String getDBDepartDate() {
			String[] cutted = depart_time.split(",");
			return cutted[0];
		}
		public String getDBDepartTime() {
			String[] cutted = depart_time.split(",");
			return cutted[1];
		}
		public String getArriveTime() {
			return this.arrive_time;
		}
		public String getDBArriveTime() {
			String[] cutted = arrive_time.split(",");
			return cutted[1];
		}
		public String getPassengerType() {
			return this.passenger_type;
		}
		public String getCarriage() {
			return this.carriage;
		}
		public String getEarlyDiscount() {
			return this.early_discount;
		}
		public String getUniversityDisciont() {
			return this.university_discount;
		}
		
		public String getTransactionNumber() {
			return transaction_number;
		}
		
		
		public String getCompartment() {
			return this.compartment;
		}
		public String getLocation() {
			return this.location;
		}
		
		public String getPrice() {
			return this.price;
		}
		
		
		
		/**
		 * server will need this
		 * @param input
		 */
		public void setCompartment(String input) {
			this.compartment = input;
		}
		public void setLocation(String input) {
			this.location = input;
		}
		public void setTransaction_number(String input) {
			this.transaction_number = input;
		}
		
		public String toString() {
			String output = null;
			output = "TransactionNO " +  this.getTransactionNumber()+ "\n";
			output = output + "carID " + this.getCarID()+ "\n";
			output = output + "userID " + this.getUserID()+ "\n";
			output = output + "Depart from " + this.getDepart()+ "\n";
			output = output + "Arrive at " + this.getArrive() + "\n";
			output = output + "Depart Time " + this.getDBDepartDate() + "," + this.getDBDepartTime() + "\n";
			output = output + "Arrive Time " + this.getDBDepartDate() + "," + this.getDBArriveTime() + "\n";
			output = output + "Passenger Type " + this.getPassengerType() + "\n";
			output = output + "Carriage " + this.getCarriage() + "\n";
			output = output + "Early Discount " + this.getEarlyDiscount() + "\n";
			output = output + "University Discount " + this.getUniversityDisciont() + "\n";
			output = output + "Compartment " + this.getCompartment() + "\n";
			output = output + "Location " + this.getLocation() + "\n";
			output = output + "Price " + this.getPrice() + "\n";

			
			return output;

		}
		public static void main(String args[]) {
			Ticket a = new Ticket(1);
			Ticket b = new Ticket(1,1);
			
			System.out.println(a.toString());
			System.out.println(b.toString());
		}
		
	}
	