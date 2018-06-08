package message;

import java.io.Serializable;

public class SearchOrder implements Serializable {
	private String userID;
	
	public SearchOrder(String ID) {
		this.userID = ID;
	}
	
	public String getUserID() {
		return this.userID;
	}
}
