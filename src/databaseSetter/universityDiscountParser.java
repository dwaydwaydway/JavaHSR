package databaseSetter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import server.*;

public class universityDiscountParser {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		JSONArray a = null;
		try {
			obj = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream
					("C:\\\\Users\\\\USER\\\\eclipse-workspace\\\\JavaHSR\\\\data\\\\universityDiscount.json"), "UTF-8")));
			a = (JSONArray) obj.get("DiscountTrains");
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Object o : a) {
			JSONObject universityDiscount = (JSONObject) o;
			//JSONObject DiscountTrains = (JSONObject)universityDiscount.get("DiscountTrains");
			String TrainNo = universityDiscount.get("TrainNo").toString();
			JSONObject ServiceDayDiscount = (JSONObject)universityDiscount.get("ServiceDayDiscount");
			String Monday = ServiceDayDiscount.get("Monday").toString();
			String Tuesday = ServiceDayDiscount.get("Tuesday").toString();
			String Wednesday = ServiceDayDiscount.get("Wednesday").toString();
			String Thursday = ServiceDayDiscount.get("Thursday").toString();
			String Friday = ServiceDayDiscount.get("Friday").toString();
			String Saturday = ServiceDayDiscount.get("Saturday").toString();
			String Sunday = ServiceDayDiscount.get("Sunday").toString();
			
			Database database = new Database();
			database.insertUniversityDiscount(TrainNo, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday);
			
		}
	}
}
