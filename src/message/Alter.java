package message;

import java.io.Serializable;

public class Alter implements Serializable {
	int ReservationNumber;
	String ID;
	int[] quantity;
	
	boolean AlterSuccessfully;
}
