package message;

import java.io.Serializable;
/**
 * This class is used to alter an order. 
 * 
 * @author Lu (B05602022)
 * @version 1.0
 * @since 2018-06-07
 *
 */
public class Alter implements Serializable {
	int ReservationNumber;
	String ID;
	int[] quantity;
	boolean AlterSuccessfully;
}
