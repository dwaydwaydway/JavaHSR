package message;

import java.io.Serializable;

import java.util.LinkedList;

/**
 * Goal: This class is used to return the all cars that meet the requests of an
 * SearchCar object. Information:
 * 
 * @SearchCar info: an object of SearchCar that contains specific requests.
 * @boolean OrderSuccessfully: If there is any car meeting the SearchCar info,
 *          return true. @addCar(): this function is to create the Car objects
 *          meeting those request. And those parameters in addCar() are
 *          identical to Car object
 *
 */
public class Available implements Serializable {
	public LinkedList<Car> carList = null;
	public SearchCar info;

	public Available() {
		carList = new LinkedList<Car>();
	}

	/**
	 * TESTING Constructor
	 */
	public Available(int x) {
		carList = new LinkedList<Car>();
		carList.add(new Car(1));
	}

	private boolean OrderSuccessfully;

	/**
	 * This function adds a train to the train list
	 * 
	 * @param String
	 *            carID
	 * @param String
	 *            depart
	 * @param String
	 *            arrive
	 * @param String
	 *            depart_time
	 * @param String
	 *            arrive_time
	 * @param String
	 *            remained_window_business_seat
	 * @param String
	 *            remained_aisle_business_seat
	 * @param String
	 *            remained_window_standard_seat
	 * @param String
	 *            remained_none_standard_seat
	 * @param String
	 *            remained_aisle_standard_seat
	 * @param String
	 *            early_discount
	 * @param String
	 *            university_discount
	 */
	public void addCar(String carID, String depart, String arrive, String depart_time, String arrive_time,
			String remained_window_business_seat, String remained_aisle_business_seat,
			String remained_window_standard_seat, String remained_none_standard_seat,
			String remained_aisle_standard_seat, String early_discount, String university_discount) {

		Car newCar = new Car(carID, depart, arrive, depart_time, arrive_time, remained_window_business_seat,
				remained_aisle_business_seat, remained_window_standard_seat, remained_none_standard_seat,
				remained_aisle_standard_seat, early_discount, university_discount);
		carList.add(newCar);
	}

	/**
	 * The getter of informations
	 */
	public SearchCar getInfo() {
		return this.info;
	}

	public LinkedList<Car> getAvailable() {
		return carList;
	}
}
