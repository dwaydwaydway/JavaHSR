package message;

import java.io.Serializable;
import java.util.LinkedList;
/**
 * This class is used to inform client the result of the daily train search
 *
 */
public class DailyResult implements Serializable {
	public LinkedList<SearchDaily> TicketList = new LinkedList<SearchDaily>();
	
	public void add(String carID, String depart_day, String depart_timeOfNANGANG, String depart_timeOfTAIPEI,
			String depart_timeOfBANCIAO, String depart_timeOfTAOYUAN, String depart_timeOfHSINCHU,
			String depart_timeOfMIAOLI, String depart_timeOfTAICHUNG, String depart_timeOfCHANGHUA,
			String depart_timeOfYUNLIN, String depart_timeOfCHIAYI, String depart_timeOfTAINAN,
			String depart_timeOfZUOYING) {
		
		TicketList.add(new SearchDaily(carID, depart_day, depart_timeOfNANGANG, depart_timeOfTAIPEI,
			depart_timeOfBANCIAO, depart_timeOfTAOYUAN, depart_timeOfHSINCHU,
			depart_timeOfMIAOLI, depart_timeOfTAICHUNG, depart_timeOfCHANGHUA,
			depart_timeOfYUNLIN, depart_timeOfCHIAYI, depart_timeOfTAINAN,
			depart_timeOfZUOYING));
		
	}
}
