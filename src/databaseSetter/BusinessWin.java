package databaseSetter;

import server.Database;

public class BusinessWin {
	public static void main(String[] args) {
		DatabaseSetter database = new DatabaseSetter();
		
		database.insertBusinessWin("6", "1", "E");
		for(int i = 2; i < 18; i++) {
			database.insertBusinessWin("6", i + "", "A");
			database.insertBusinessWin("6", i + "", "E");
		}
		
		
	}
}