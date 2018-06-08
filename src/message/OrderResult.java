package message;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * After checking the SearchOrder in the database, we should create an object of OrderResult, and
 * returnif to Client.
 * 
 * Information:
 * 1.carID;
 * 2.userID;
 * 3.depart station;
 * 4.arrive station;
 * 5.depart_time;
 * 6.arrive_time;
 * 7.passenger_type;
 * 8.carriage;
 * 9.early_discount(65,75...or none)
 *
 */
public class OrderResult implements Serializable {
	private String carID;
	private String userID;
	private String depart;
	private String arrive;
	private String depart_time;
	private String arrive_time;
	private String passenger_type;
	private String carriage;
	private String early_discount;  //65,75...or none
	
	public OrderResult(String carID, String userID, String depart, String arrive, 
			String depart_time, String arrive_time, String passenger_type, String carriage, String early_discount)
	{
		this.carID = carID;
		this.userID = userID;
		this.depart = depart;
		this.arrive = arrive;
		this.arrive_time = arrive_time;
		this.depart_time = depart_time;
		this.passenger_type = passenger_type;
		this.carriage = carriage;
		this.early_discount = early_discount;
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
	public String getArriveTime() {
		return this.arrive_time;
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
	
}
