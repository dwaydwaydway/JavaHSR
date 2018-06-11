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
	
	
	public Order(SearchCar i, String carID, String userID, int price1 , int price2 , int price3 , int price4 , int price5)
	{
		this.info = i;
		this.carID = carID;
		this.userID = userID;
		this.sum_normal = price1;
		this.sum_child = price2;
		this.sum_elder = price3;
		this.sum_disable = price4;
		this.sum_student = price5;
	}
	
	public String getCarID() {
		return this.carID;
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
