
public class SearchCar extends Messenger {
	public enum station {
		Nangang, Taipei, Banqiao, Taoyuan, Hsinchu, Miaoli, 
		Taichung, Tainan, Changhua, Yunlin, Chiayi, Zuoying
	}
	public enum passengerType {
		normal, child, elder, disable, student
	}
	public enum seat {
		none, window, aisle
	}
	public enum carriage {
		standard, business
	}
	//日期
	//時間
	station depart;
	station arrive;
	passengerType passengertype;
	seat seat;
	carriage carriage;
	int[] quantity;
	boolean early;
	
	public SearchCar();
	
	
	
	
	
	
}
