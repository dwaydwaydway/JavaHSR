import SearchCar.station;

public class Car {
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
	
	String carID;
	// 日期
	// 時間
	station depart;
	station arrive;
	int discount; //65, 75, ~
	
}
