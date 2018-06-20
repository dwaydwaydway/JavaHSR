package databaseSetter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import server.*;
public class seatInit {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();
		JSONArray a = null;
		try {
			a = (JSONArray) parser.parse(new FileReader("C:\\Users\\USER\\eclipse-workspace\\JavaHSR\\data\\timeTable.json"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		for (Object o : a) {
			JSONObject train = (JSONObject) o;
			
			String Monday = "0";
			String Tuesday = "0";
			String Wednesday = "0";
			String Thursday = "0";
			String Friday = "0";
			String Saturday = "0";
			String Sunday = "0";

			JSONObject GeneralTimetable = (JSONObject)train.get("GeneralTimetable");
			JSONObject GeneralTrainInfo = (JSONObject)GeneralTimetable.get("GeneralTrainInfo");
			
			String TrainNo = GeneralTrainInfo.get("TrainNo").toString();
			
			JSONObject ServiceDay = (JSONObject)GeneralTimetable.get("ServiceDay");
			DatabaseSetter database = new DatabaseSetter();
				Monday = ServiceDay.get("Monday").toString();
				if("1".equals(Monday)) {
					database.insertSeatIndex(TrainNo, "33", "33", "265", "137", "265", "4", "Monday");
				}
				Tuesday = ServiceDay.get("Tuesday").toString();
				if("1".equals(Tuesday)) {
					database.insertSeatIndex(TrainNo, "33", "33", "265", "137", "265", "4", "Tuesday");
				}
				Wednesday = ServiceDay.get("Wednesday").toString();
				if("1".equals(Wednesday)) {
					database.insertSeatIndex(TrainNo, "33", "33", "265", "137", "265", "4", "Wednesday");
				}
				Thursday = ServiceDay.get("Thursday").toString();
				if("1".equals(Thursday)) {
					database.insertSeatIndex(TrainNo, "33", "33", "265", "137", "265", "4", "Thursday");
				}
				Friday = ServiceDay.get("Friday").toString();
				if("1".equals(Friday)) {
					database.insertSeatIndex(TrainNo, "33", "33", "265", "137", "265", "4", "Friday");
				}
				Saturday = ServiceDay.get("Saturday").toString();
				if("1".equals(Saturday)) {
					database.insertSeatIndex(TrainNo, "33", "33", "265", "137", "265", "4", "Saturday");
				}
				Sunday = ServiceDay.get("Sunday").toString();	
				if("1".equals(Sunday)) {
					database.insertSeatIndex(TrainNo, "33", "33", "265", "137", "265", "4", "Sunday");
				}				
			
		}
	}
}

