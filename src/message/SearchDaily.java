package message;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * This class is used to search the train of a day.
 *
 */
public class SearchDaily implements Serializable {
	private static final long serialVersionUID = 1L;
	Date depart_day_temp; // day save in
	String depart_dayofweek;
	SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dayofweek = new SimpleDateFormat("E", Locale.ENGLISH);

	private String carID;
	private String depart_day; // in the form of "1995-02-03"

	public SearchDaily() {

	}

	public SearchDaily(String carID, String depart_day, String depart_timeOfNANGANG, String depart_timeOfTAIPEI,
			String depart_timeOfBANCIAO, String depart_timeOfTAOYUAN, String depart_timeOfHSINCHU,
			String depart_timeOfMIAOLI, String depart_timeOfTAICHUNG, String depart_timeOfCHANGHUA,
			String depart_timeOfYUNLIN, String depart_timeOfCHIAYI, String depart_timeOfTAINAN,
			String depart_timeOfZUOYING) {
		this.carID = carID;
		this.depart_day = depart_day;
		this.depart_timeOfNANGANG = depart_timeOfNANGANG;
		this.depart_timeOfTAIPEI = depart_timeOfTAIPEI;
		this.depart_timeOfBANCIAO = depart_timeOfBANCIAO;
		this.depart_timeOfTAOYUAN = depart_timeOfTAOYUAN;
		this.depart_timeOfHSINCHU = depart_timeOfHSINCHU;
		this.depart_timeOfMIAOLI = depart_timeOfMIAOLI;
		this.depart_timeOfTAICHUNG = depart_timeOfTAICHUNG;
		this.depart_timeOfCHANGHUA = depart_timeOfCHANGHUA;
		this.depart_timeOfYUNLIN = depart_timeOfYUNLIN;
		this.depart_timeOfCHIAYI = depart_timeOfCHIAYI;
		this.depart_timeOfTAINAN = depart_timeOfTAINAN;
		this.depart_timeOfZUOYING = depart_timeOfZUOYING;
	}

	private String depart_timeOfNANGANG;
	private String depart_timeOfTAIPEI;
	private String depart_timeOfBANCIAO;
	private String depart_timeOfTAOYUAN;
	private String depart_timeOfHSINCHU;
	private String depart_timeOfMIAOLI;
	private String depart_timeOfTAICHUNG;
	private String depart_timeOfCHANGHUA;
	private String depart_timeOfYUNLIN;
	private String depart_timeOfCHIAYI;
	private String depart_timeOfTAINAN;
	private String depart_timeOfZUOYING;

	/**
	 * THe getter of informations.
	 * 
	 * @return String
	 */
	public String getDepart_dayofweek() {
		switch (depart_dayofweek) {
		case "Mon":
			return "Monday";
		case "Tue":
			return "Tuesday";
		case "Wed":
			return "Wednesday";
		case "Thu":
			return "Thursday";
		case "Fri":
			return "Friday";
		case "Sat":
			return "Saturday";
		case "Sun":
			return "Sunday";
		}
		return null;
	}

	public String getDepart_timeOfNANGANG() {
		return depart_timeOfNANGANG;
	}

	public void setDepart_timeOfNANGANG(String depart_timeOfNANGANG) {
		this.depart_timeOfNANGANG = depart_timeOfNANGANG;
	}

	public String getDepart_timeOfTAIPEI() {
		return depart_timeOfTAIPEI;
	}

	public void setDepart_timeOfTAIPEI(String depart_timeOfTAIPEI) {
		this.depart_timeOfTAIPEI = depart_timeOfTAIPEI;
	}

	public String getDepart_timeOfBANCIAO() {
		return depart_timeOfBANCIAO;
	}

	public void setDepart_timeOfBANCIAO(String depart_timeOfBANCIAO) {
		this.depart_timeOfBANCIAO = depart_timeOfBANCIAO;
	}

	public String getDepart_timeOfTAOYUAN() {
		return depart_timeOfTAOYUAN;
	}

	public void setDepart_timeOfTAOYUAN(String depart_timeOfTAOYUAN) {
		this.depart_timeOfTAOYUAN = depart_timeOfTAOYUAN;
	}

	public String getDepart_timeOfHSINCHU() {
		return depart_timeOfHSINCHU;
	}

	public void setDepart_timeOfHSINCHU(String depart_timeOfHSINCHU) {
		this.depart_timeOfHSINCHU = depart_timeOfHSINCHU;
	}

	public String getDepart_timeOfMIAOLI() {
		return depart_timeOfMIAOLI;
	}

	public void setDepart_timeOfMIAOLI(String depart_timeOfMIAOLI) {
		this.depart_timeOfMIAOLI = depart_timeOfMIAOLI;
	}

	public String getDepart_timeOfTAICHUNG() {
		return depart_timeOfTAICHUNG;
	}

	public void setDepart_timeOfTAICHUNG(String depart_timeOfTAICHUNG) {
		this.depart_timeOfTAICHUNG = depart_timeOfTAICHUNG;
	}

	public String getDepart_timeOfCHANGHUA() {
		return depart_timeOfCHANGHUA;
	}

	public void setDepart_timeOfCHANGHUA(String depart_timeOfCHANGHUA) {
		this.depart_timeOfCHANGHUA = depart_timeOfCHANGHUA;
	}

	public String getDepart_timeOfYUNLIN() {
		return depart_timeOfYUNLIN;
	}

	public void setDepart_timeOfYUNLIN(String depart_timeOfYUNLIN) {
		this.depart_timeOfYUNLIN = depart_timeOfYUNLIN;
	}

	public String getDepart_timeOfCHIAYI() {
		return depart_timeOfCHIAYI;
	}

	public void setDepart_timeOfCHIAYI(String depart_timeOfCHIAYI) {
		this.depart_timeOfCHIAYI = depart_timeOfCHIAYI;
	}

	public String getDepart_timeOfTAINAN() {
		return depart_timeOfTAINAN;
	}

	public void setDepart_timeOfTAINAN(String depart_timeOfTAINAN) {
		this.depart_timeOfTAINAN = depart_timeOfTAINAN;
	}

	public String getDepart_timeOfZUOYING() {
		return depart_timeOfZUOYING;
	}

	public void setDepart_timeOfZUOYING(String depart_timeOfZUOYING) {
		this.depart_timeOfZUOYING = depart_timeOfZUOYING;
	}

	public String getCarID() {
		return this.carID;
	}

	public String getDepartDay() {
		return this.depart_day;
	}

	public void setCarID(String input) {
		this.carID = input;
	}

	public void setDepartDay(String inputDate) {

		// input(string) turn into date in depart_day_temp;
		try {
			depart_day_temp = ft2.parse(inputDate);
		} catch (ParseException e) {
			System.out.println("Unparseable using " + ft2);
		}

		// use depart_day_temp(date) to print out depart_day(String) and
		// depart_dayofweek

		depart_day = ft2.format(depart_day_temp);
		depart_dayofweek = dayofweek.format(depart_day_temp);

	}
}
