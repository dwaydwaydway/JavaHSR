package message;
import java.io.Serializable;
import java.util.LinkedList;

public class Available implements Serializable {
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
