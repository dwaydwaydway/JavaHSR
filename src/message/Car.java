package message;
import java.io.Serializable;
/**
 * This class contains what kinds of information a Car object should have
 */
public class Car implements Serializable {
	private static final long serialVersionUID = 753539215733352664L;
	
	private String carID;
	private String depart;
	private String arrive;
	private String depart_time;
	private String arrive_time;
	private String remained_window_business_seat;
	private String remained_aisle_business_seat;
	private String remained_window_standard_seat;
	private String remained_none_standard_seat;
	private String remained_aisle_standard_seat;
	private String early_discount;  //65,75...or none
	private String student_discount;
	/**
	 * Constructor of Car
	 */
	public Car(String carID, String depart, String arrive, String depart_time, String arrive_time, 
			String remained_window_business_seat, String remained_aisle_business_seat, String remained_window_standard_seat, 
			String remained_none_standard_seat, String remained_aisle_standard_seat, String early_discount, String student_discount)
	{
		this.carID = carID;
		this.depart = depart;
		this.arrive = arrive;
		this.arrive_time = arrive_time;
		this.depart_time = depart_time;
		this.remained_aisle_business_seat = remained_aisle_business_seat;
		this.remained_aisle_standard_seat = remained_aisle_standard_seat;
		this.remained_none_standard_seat = remained_none_standard_seat;
		this.remained_window_business_seat = remained_window_business_seat;
		this.remained_window_standard_seat = remained_window_standard_seat;
		this.early_discount = early_discount;
		this.student_discount = student_discount;
	}
	
	public String getCarID() {
		return this.carID;
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
	public String getRemained_Aisle_Business_Seat() {
		return this.remained_aisle_business_seat;
	}
	public String getRemained_Aisle_Standard_Seat() {
		return this.remained_aisle_standard_seat;
	}
	public String getRemained_None_Standard_Seat() {
		return this.remained_none_standard_seat;
	}
	public String getRemained_Window_Business_Seat() {
		return this.remained_window_business_seat;
	}
	public String getRemained_Window_Standard_Seat() {
		return this.remained_window_standard_seat;
	}
	public String getStudent_discount(){
		return student_discount;
	}
}
