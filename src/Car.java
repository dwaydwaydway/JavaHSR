import SearchCar.station;

public class Car {
	public enum Station {
		NANGANG, TAIPEI, BANQIAO, TAOYUAN, HSINCHU, MIAOLI, 
		TAICHUNG, TAINAN, CHANGHUA, YUNLIN, CHIAYI, ZUOYING
	}
	public enum PassengerType {
		NORMAL, CHILD, ELDER, DISABLE, STUDENT
	}
	public enum Seat {
		NONE, WINDOW, AISE
	}
	public enum Carriage {
		STANDARD, BUSINESS
	}
	
	String carID;
	// ���
	// �ɶ�
	Station depart;
	Station arrive;
	int discount; //65, 75, ~
	
}
