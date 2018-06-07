package message;
import java.io.Serializable;
import java.util.LinkedList;
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
}
