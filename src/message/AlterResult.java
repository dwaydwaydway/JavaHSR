package message;

import java.io.Serializable;
/**
 * This class is used to inform the client the result of the alternation.
 *
 */
public class AlterResult implements Serializable{
	public enum station {
		Nangang, Taipei, Banqiao, Taoyuan, Hsinchu, Miaoli, 
		Taichung, Tainan, Changhua, Yunlin, Chiayi, Zuoying
	}
	public enum passengerType {
		normal, child, elder, disable
	}
	public enum seat {
		none, window, aisle
	}
	
	boolean AlterSuccessfully;
	
	station depart;
	station arrive;
	
	int depart_time;
	int arrive_time;
	passengerType passengertype;
	seat seat;

	String ID;
	String carID;
	int[] quantity;
}