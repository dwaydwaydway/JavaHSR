package message;

import java.io.Serializable;

public class Order implements Serializable {
//	public enum station {
//		Nangang, Taipei, Banqiao, Taoyuan, Hsinchu, Miaoli, 
//		Taichung, Tainan, Changhua, Yunlin, Chiayi, Zuoying
//	}
//	public enum passengerType {
//		normal, child, elder, disable
//	}
//	public enum seat {
//		none, window, aisle
//	}
//	public enum carriage {
//		standard, business
//	}
	//日期
	//時間
	String depart;
	String arrive;
	String passengertype;
	String seat;
	
	String carriage;
	String Code;
	String Uid;
	int[] quantity;
	public String getCode() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUid() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getTicketsType() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getTicketsCount() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getStart() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEnd() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPayDeadline() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getpayment() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getRow() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSeatType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
