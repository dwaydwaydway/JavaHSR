package databaseSetter;

import server.Database;

public class BusinessAisle {
	public static void main(String[] args) {
		DatabaseSetter database = new DatabaseSetter();
		
		database.insertBusinessAisle("6", "1", "D");
		for(int i = 2; i < 18; i++) {
			database.insertBusinessAisle("6", i + "", "C");
			database.insertBusinessAisle("6", i + "", "D");
		}
		
		
	}
}
