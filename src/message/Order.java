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
	
	public Order(SearchCar i, String carID, String userID) {
		this.info = i;
		this.carID = carID;
		this.userID = userID;
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
}
