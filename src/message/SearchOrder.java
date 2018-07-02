package message;

import java.io.Serializable;

/**
 * This class contains only one information:userID When user want to search
 * their order, we should generate an object of SearchOrder with the userID. And
 * then server can check the order of this ID in the database.
 */
public class SearchOrder implements Serializable {
	private String userID;
	private String transaction_number;

	/**
	 * This is the default constructor which set the userID "invalid"
	 */
	public SearchOrder() {
		userID = transaction_number = "invalid";

	}

	/**
	 * This is the constructor which set the userID.
	 * 
	 * @param String
	 *            ID
	 */
	public SearchOrder(String transaction_number, String ID) {
		this.transaction_number = transaction_number;
		this.userID = ID;
	}

	public String getUserID() {
		return this.userID;
	}

	public String getTransactionNumber() {
		return this.transaction_number;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setTransactionNumber(String input) {
		this.transaction_number = input;
	}

	public String toString() {
		return "Transaction Number is " + transaction_number + "\nuserID is " + userID;
	}
}