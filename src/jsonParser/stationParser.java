package jsonParser;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
//import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import server.*;
public class stationParser {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();
		JSONArray a = null;
		try {
			a = (JSONArray) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream
				("C:\\\\Users\\\\USER\\\\eclipse-workspace\\\\JavaHSR\\\\data\\\\station.json"), "UTF-8")));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Object o : a) {
			JSONObject station = (JSONObject) o;
			String StationID = station.get("StationID").toString();
			JSONObject StationName = (JSONObject)station.get("StationName");
			String Zh_tw = StationName.get("Zh_tw").toString();
			String En = StationName.get("En").toString();
			String StationAddress = station.get("StationAddress").toString();
			
			Database database = new Database();
			database.insertStation(StationID, Zh_tw, En, StationAddress);
			
		}
	}
}