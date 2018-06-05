package message;
import java.util.LinkedList;

public class Available extends Messenger {
	public LinkedList<Car> carList = null;
	public Available() {
		carList = new LinkedList<Car>();
	}

	boolean OrderSuccessfully;
	public void addCar(String depart, String arrive) {
		Car newCar = new Car(depart, arrive);
		carList.add(newCar);
	}
}
