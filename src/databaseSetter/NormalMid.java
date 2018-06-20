package databaseSetter;

import server.Database;

public class NormalMid {
	public static void main(String[] args) {
		DatabaseSetter database = new DatabaseSetter();
		
		
		database.insertNormalMid("1", "1", "B");
		for(int i = 2; i < 14; i++) {
			database.insertNormalMid("1", i + "", "B");
		}
		
		database.insertNormalMid("2", "1", "B");
		database.insertNormalMid("2", "20", "B");
		for(int i = 2; i < 20; i++) {
			database.insertNormalMid("2", i + "", "B");
		}
		
		database.insertNormalMid("3", "1", "B");
		for(int i = 2; i < 19; i++) {
			database.insertNormalMid("3", i + "", "B");
		}
		
		database.insertNormalMid("4", "1", "B");
		database.insertNormalMid("4", "20", "B");
		for(int i = 2; i < 20; i++) {
			database.insertNormalMid("4", i + "", "B");
		}
		
		database.insertNormalMid("5", "1", "B");
		for(int i = 2; i < 18; i++) {
			database.insertNormalMid("5", i + "", "B");
		}
		
		for(int i = 1; i < 12; i++) {
			database.insertNormalMid("7", i + "", "B");
		}
		
		database.insertNormalMid("8", "1", "B");
		database.insertNormalMid("8", "20", "B");
		for(int i = 2; i < 20; i++) {
			database.insertNormalMid("5", i + "", "B");
		}
		
		database.insertNormalMid("9", "1", "B");
		for(int i = 2; i < 19; i++) {
			database.insertNormalMid("9", i + "", "B");
		}
	}
}
