import SearchCar.carriage;
import SearchCar.passengerType;
import SearchCar.seat;
import SearchCar.station;

public class Order extends Messenger {
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
	String ID;
	int[] quantity;
}
