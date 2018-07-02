package message;

import java.io.Serializable;

import java.util.LinkedList;

/**
 * Goal: This class is used to return the all tickets that meet the requests of
 * an SearchOrder object. Information:
 * 
 * @SearchCar info: an object of SearchOrder that contains specific requests.
 * @boolean SearchOrderSuccessfully: If there is any ticket meeting the userID,
 *          return true. @addCar(): this function is to create the Ticket
 *          objects meeting those request. And those parameters in addTicket()
 *          are identical to Ticket object
 *
 */
public class OrderResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LinkedList<Ticket> TicketList = null;

	public OrderResult() {
		TicketList = new LinkedList<Ticket>();
	}

	// testing constructor
	public OrderResult(int x) {
		TicketList = new LinkedList<Ticket>();
		TicketList.add(new Ticket(0));
		TicketList.add(new Ticket(1));
	}

	// testing constructor2
	public OrderResult(int x, int y) {
		TicketList = new LinkedList<Ticket>();
		TicketList.add(new Ticket(0));
		// TicketList.add(new Ticket(0, 1));
	}

	/**
	 * This function add a ticket to the ticket list
	 * 
	 * @param String
	 *            transaction_number
	 * @param String
	 *            carID
	 * @param String
	 *            userID
	 * @param String
	 *            depart
	 * @param String
	 *            arrive
	 * @param String
	 *            depart_time
	 * @param String
	 *            arrive_time
	 * @param String
	 *            passenger_type
	 * @param String
	 *            carriage
	 * @param String
	 *            early_discount
	 * @param String
	 *            university_discount
	 * @param String
	 *            compartment
	 * @param String
	 *            location
	 * @param String
	 *            price
	 */
	public void addTicket(String transaction_number, String carID, String userID, String depart, String arrive,
			String depart_time, String arrive_time, String passenger_type, String carriage, String early_discount,
			String university_discount, String compartment, String location, String price) {

		Ticket newTicket = new Ticket(transaction_number, carID, userID, depart, arrive, depart_time, arrive_time,
				passenger_type, carriage, early_discount, university_discount, compartment, location, price);

		TicketList.add(newTicket);
	}

	public LinkedList<Ticket> getOrderResult() {
		return TicketList;
	}

}
