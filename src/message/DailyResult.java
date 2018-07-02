package message;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * This class is used to inform client the result of the daily train search
 *
 */
public class DailyResult implements Serializable {
	public LinkedList<SearchDaily> TicketList = new LinkedList<SearchDaily>();

	/**
	 * This function adds a SearchDaily to the SearchDaily list
	 * 
	 * @param String
	 *            carID
	 * @param String
	 *            depart_day
	 * @param String
	 *            depart_timeOfNANGANG
	 * @param String
	 *            depart_timeOfTAIPEI
	 * @param String
	 *            depart_timeOfBANCIAO
	 * @param String
	 *            depart_timeOfTAOYUAN
	 * @param String
	 *            depart_timeOfHSINCHU
	 * @param String
	 *            depart_timeOfMIAOLI
	 * @param String
	 *            depart_timeOfTAICHUNG
	 * @param String
	 *            depart_timeOfCHANGHUA
	 * @param String
	 *            depart_timeOfYUNLIN
	 * @param String
	 *            depart_timeOfCHIAYI
	 * @param String
	 *            depart_timeOfTAINAN
	 * @param String
	 *            depart_timeOfZUOYING
	 */
	public void add(String carID, String depart_day, String depart_timeOfNANGANG, String depart_timeOfTAIPEI,
			String depart_timeOfBANCIAO, String depart_timeOfTAOYUAN, String depart_timeOfHSINCHU,
			String depart_timeOfMIAOLI, String depart_timeOfTAICHUNG, String depart_timeOfCHANGHUA,
			String depart_timeOfYUNLIN, String depart_timeOfCHIAYI, String depart_timeOfTAINAN,
			String depart_timeOfZUOYING) {

		TicketList.add(new SearchDaily(carID, depart_day, depart_timeOfNANGANG, depart_timeOfTAIPEI,
				depart_timeOfBANCIAO, depart_timeOfTAOYUAN, depart_timeOfHSINCHU, depart_timeOfMIAOLI,
				depart_timeOfTAICHUNG, depart_timeOfCHANGHUA, depart_timeOfYUNLIN, depart_timeOfCHIAYI,
				depart_timeOfTAINAN, depart_timeOfZUOYING));

	}
}
