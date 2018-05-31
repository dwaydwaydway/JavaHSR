import java.util.LinkedList;
public class Result1 extends Messenger {
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
	public LinkedList<Car> carList = null;
	public Result1() {
		carList = new LinkedList<Car>();
	}

	boolean OrderSuccessfully;
	void addCar(String depart, String arrive) {
		Car newCar = new Car(depart, arrive);
		carList.add(newCar);
	}
//	station depart;
//	station arrive;
//	
//	int depar_time;
//	int arrive_time;
//	passengerType passengertype;
//	seat seat;
//
//	String ID;
//	String carID;
//	int[] quantity;
}
