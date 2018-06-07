package message;
import java.io.Serializable;
import java.util.LinkedList;

public class Available implements Serializable {
	public LinkedList<Car> carList = null;
	public SearchCar info;
	public Available() {
		carList = new LinkedList<Car>();
	}

	boolean OrderSuccessfully;
	public void addCar(String carID, String depart, String arrive, String depart_time, String arrive_time, 
			String remained_window_business_seat, String remained_none_business_seat, 
			String remained_aisle_business_seat, String remained_window_standard_seat, 
			String remained_none_standard_seat, String remained_aisle_standard_seat, String early_discount) {

		
		Car newCar = new Car(carID, depart, arrive, depart_time, arrive_time, 
				remained_window_business_seat, remained_none_business_seat, 
				remained_aisle_business_seat, remained_window_standard_seat, 
				remained_none_standard_seat, remained_aisle_standard_seat, early_discount);
		carList.add(newCar);
	}
}

