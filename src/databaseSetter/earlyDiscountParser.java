package databaseSetter;
import server.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class earlyDiscountParser {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		JSONArray a = null;
		try {
			obj = (JSONObject) parser.parse(new BufferedReader(new InputStreamReader(
					new FileInputStream(
							"C:\\\\Users\\\\USER\\\\eclipse-workspace\\\\JavaHSR\\\\data\\\\earlyDiscount.json"),
					"UTF-8")));
			a = (JSONArray) obj.get("DiscountTrains");
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Object o : a) {
			JSONObject earlyDiscount = (JSONObject) o;
			String TrainNo = earlyDiscount.get("TrainNo").toString();
			JSONObject ServiceDayDiscount = (JSONObject) earlyDiscount.get("ServiceDayDiscount");
			try {
				JSONArray MondayArray = (JSONArray) ServiceDayDiscount.get("Monday");
				for (int i = 0; i < MondayArray.size(); i++) {
					DatabaseSetter database = new DatabaseSetter();
					database.insertEearlyDiscount(TrainNo, "Monday",
							((JSONObject) MondayArray.get(i)).get("discount").toString(),
							((JSONObject) MondayArray.get(i)).get("tickets").toString());
				}
			} catch (ClassCastException e) {
				DatabaseSetter database = new DatabaseSetter();
				database.insertEearlyDiscount(TrainNo, "Monday", ServiceDayDiscount.get("Monday").toString().toString(),
						null);
			}
			try {
				JSONArray TuesdayArray = (JSONArray) ServiceDayDiscount.get("Tuesday");
				for (int i = 0; i < TuesdayArray.size(); i++) {
					DatabaseSetter database = new DatabaseSetter();
					database.insertEearlyDiscount(TrainNo, "Tuesday",
							((JSONObject) TuesdayArray.get(i)).get("discount").toString(),
							((JSONObject) TuesdayArray.get(i)).get("tickets").toString());
				}
			} catch (ClassCastException e) {
				DatabaseSetter database = new DatabaseSetter();
				database.insertEearlyDiscount(TrainNo, "Tuesday",
						ServiceDayDiscount.get("Tuesday").toString().toString(), null);
			}
			try {
				JSONArray WednesdayArray = (JSONArray) ServiceDayDiscount.get("Wednesday");
				for (int i = 0; i < WednesdayArray.size(); i++) {
					DatabaseSetter database = new DatabaseSetter();
					database.insertEearlyDiscount(TrainNo, "Wednesday",
							((JSONObject) WednesdayArray.get(i)).get("discount").toString(),
							((JSONObject) WednesdayArray.get(i)).get("tickets").toString());
				}
			} catch (ClassCastException e) {
				DatabaseSetter database = new DatabaseSetter();
				database.insertEearlyDiscount(TrainNo, "Wednesday",
						ServiceDayDiscount.get("Wednesday").toString().toString(), null);
			}
			try {

				JSONArray ThursdayArray = (JSONArray) ServiceDayDiscount.get("Thursday");
				for (int i = 0; i < ThursdayArray.size(); i++) {
					DatabaseSetter database = new DatabaseSetter();
					database.insertEearlyDiscount(TrainNo, "Thursday",
							((JSONObject) ThursdayArray.get(i)).get("discount").toString(),
							((JSONObject) ThursdayArray.get(i)).get("tickets").toString());
				}
			} catch (ClassCastException e) {
				DatabaseSetter database = new DatabaseSetter();
				database.insertEearlyDiscount(TrainNo, "Thursday",
						ServiceDayDiscount.get("Thursday").toString().toString(), null);
			}
			try {

				JSONArray FridayArray = (JSONArray) ServiceDayDiscount.get("Friday");
				for (int i = 0; i < FridayArray.size(); i++) {
					DatabaseSetter database = new DatabaseSetter();
					database.insertEearlyDiscount(TrainNo, "Friday",
							((JSONObject) FridayArray.get(i)).get("discount").toString(),
							((JSONObject) FridayArray.get(i)).get("tickets").toString());
				}

			} catch (ClassCastException e) {
				DatabaseSetter database = new DatabaseSetter();
				database.insertEearlyDiscount(TrainNo, "Friday", ServiceDayDiscount.get("Friday").toString().toString(),
						null);
			}
			try {
				JSONArray SaturdayArray = (JSONArray) ServiceDayDiscount.get("Saturday");
				for (int i = 0; i < SaturdayArray.size(); i++) {
					DatabaseSetter database = new DatabaseSetter();
					database.insertEearlyDiscount(TrainNo, "Saturday",
							((JSONObject) SaturdayArray.get(i)).get("discount").toString(),
							((JSONObject) SaturdayArray.get(i)).get("tickets").toString());
				}

			} catch (ClassCastException e) {
				DatabaseSetter database = new DatabaseSetter();
				database.insertEearlyDiscount(TrainNo, "Saturday",
						ServiceDayDiscount.get("Saturday").toString().toString(), null);
			}
			try {
				JSONArray SundayArray = (JSONArray) ServiceDayDiscount.get("Sunday");
				for (int i = 0; i < SundayArray.size(); i++) {
					DatabaseSetter database = new DatabaseSetter();
					database.insertEearlyDiscount(TrainNo, "Sunday",
							((JSONObject) SundayArray.get(i)).get("discount").toString(),
							((JSONObject) SundayArray.get(i)).get("tickets").toString());
				}

			} catch (ClassCastException e) {
				DatabaseSetter database = new DatabaseSetter();
				database.insertEearlyDiscount(TrainNo, "Sunday", ServiceDayDiscount.get("Sunday").toString().toString(),
						null);
			}

		}
	}
}
