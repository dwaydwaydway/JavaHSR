package message;
import java.io.Serializable;

public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 753539215733352664L;
	public Car(String depart, String arrive) {
		this.depart = depart;
		this.arrive = arrive;
	}
	String carID = "123";
	public String depart;
	public String arrive;
	int discount = 0; //65, 75, ~
	
}
