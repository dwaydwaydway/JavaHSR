package message;

import java.io.Serializable;
/**
 * This class contains only one information:¡@userID
 * When user want to search their order, we should generate an object of SearchOrder with the userID.
 * And then server can check the order of this ID in the database.
 */
public class SearchOrder implements Serializable {
	private String userID;
	
	public SearchOrder() {
		userID = "invalid";
	}
	
	
	public SearchOrder(String ID) {
		this.userID = ID;
	}
	
	public String getUserID() {
		return this.userID;
	}
}
