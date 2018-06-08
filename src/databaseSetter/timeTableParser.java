package databaseSetter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
//import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import server.*;
public class timeTableParser {

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
			String Nangang = null;
			String Yunlin = null;
			String Changhua = null;
			String Taipei = null;
			String Banciao = null;
			String Taoyuan = null;
			String Hsinchu = null;
			String Taichung = null;
			String Chiayi = null;
			String Tainan = null;
			String Zuoying = null;
			String Miaoli = null;
			
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
			String Direction = GeneralTrainInfo.get("Direction").toString();
			JSONObject StartingStationNameObj = (JSONObject)GeneralTrainInfo.get("StartingStationName");
			String StartingStationName = StartingStationNameObj.get("En").toString();
			JSONObject EndingStationNameObj = (JSONObject)GeneralTrainInfo.get("EndingStationName");
			String EndingStationName = EndingStationNameObj.get("En").toString();

			JSONArray StopTimes = (JSONArray)GeneralTimetable.get("StopTimes");
			for (int i = 0; i < StopTimes.size(); i++) {
				switch ((String) ((JSONObject)((JSONObject)StopTimes.get(i)).get("StationName")).get("En")) {
				case "Nangang":
					Nangang = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Yunlin":
					Yunlin = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Changhua":
					Changhua = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Taipei":
					Taipei = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Banciao":
					Banciao = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Taoyuan":
					Taoyuan = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Hsinchu":
					Hsinchu = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Taichung":
					Taichung = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Chiayi":
					Chiayi = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Tainan":
					Tainan = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Zuoying":
					Zuoying = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				case "Miaoli":
					Miaoli = (String) ((JSONObject)StopTimes.get(i)).get("DepartureTime");
					break;
				default:
					System.out.println("json parser switch error");
					break;
				}
			}
			JSONObject ServiceDay = (JSONObject)GeneralTimetable.get("ServiceDay");
			
				Monday = ServiceDay.get("Monday").toString();
				Tuesday = ServiceDay.get("Tuesday").toString();
				Wednesday = ServiceDay.get("Wednesday").toString();
				Thursday = ServiceDay.get("Thursday").toString();
				Friday = ServiceDay.get("Friday").toString();
				Saturday = ServiceDay.get("Saturday").toString();
				Sunday = ServiceDay.get("Sunday").toString();					
			
			Database database = new Database();
			database.insertTimeTable(TrainNo, Direction, StartingStationName, 
					EndingStationName, Nangang, Taipei, Banciao, Taoyuan, Hsinchu, 
					Miaoli, Taichung, Changhua, Yunlin, Chiayi, Tainan, Zuoying, 
					Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday);
			
		}
	}
}
