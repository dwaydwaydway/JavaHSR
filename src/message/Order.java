package message;

import java.io.Serializable;
/**
 * After the requests of the user have been verified, we should create an object of Order.
 * Information:
 * 1.SearchCar info
 * 2.carID(the finally car that the user choose)
 * 3.userID
 */
public class Order implements Serializable {
	private SearchCar info;
	private String carID;
	private String userID;
	private int sum_normal;
	private int sum_child;
	private int sum_elder;
	private int sum_disable;
	private int sum_student;
	private String early_discount;
	private String student_discount;
	
	public Order() {
		info = new SearchCar();
		sum_normal = 0;
		sum_child = 0;
		sum_elder = 0;
		sum_disable = 0;
		sum_student = 0;
		carID = "invalid";
		userID = "invalid";
	}
	
	
	public Order(SearchCar i, String carID, String userID, String early_discount, String student_discount)
	{
		this.info = i;
		this.carID = carID;
		this.userID = userID;
		this.early_discount = early_discount;
		this.student_discount = student_discount;
	}
	
	public String getCarID() {
		return this.carID;
	}
	public String getEaryDiscout(){
		return early_discount;
	}
	public String getStudentDiscount() {
		return student_discount;
	}
	public String getUserID() {
		return this.userID;
	}
	public SearchCar getInfo() {
		return this.info;
	}
	
	public int getSum_Normal() {
		Price price = new Price();
		int sum1 = this.info.quantity[0] * price.getPrice(this.info.depart, this.info.arrive);

		return sum1;
	}
	
	public int getSum_Childer() {
		Price price = new Price();
		int sum2 = this.info.quantity[1] * price.getPrice(this.info.depart, this.info.arrive) / 2;

		return sum2;
	}
	public int getSum_Elder() {
		Price price = new Price();
		int sum3 = this.info.quantity[2] * price.getPrice(this.info.depart, this.info.arrive) / 2;

		return sum3;
	}
	public int getSum_Disable() {
		Price price = new Price();
		int sum4 = this.info.quantity[3] * price.getPrice(this.info.depart, this.info.arrive) / 2;

		return sum4;
	}
	public int getSum_Student() {
		Price price = new Price();
		int sum5 = this.info.quantity[4] * price.getPrice(this.info.depart, this.info.arrive) / 2;

		return sum5;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
