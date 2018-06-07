package message;

import java.io.Serializable;

public class Order implements Serializable {
	private SearchCar info;
	private String carID;
	private String userID;
	
	public Order(SearchCar i, String carID, String userID) {
		this.info = i;
		this.carID = carID;
		this.userID = userID;
	}
	
	
}
