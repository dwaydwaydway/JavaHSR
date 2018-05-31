import java.io.Serializable;

public class Car implements Serializable {

	public Car(String depart, String arrive) {
		this.depart = depart;
		this.arrive = arrive;
	}
	String carID = "123";
	public String depart;
	public String arrive;
	int discount = 0; //65, 75, ~
	
}
