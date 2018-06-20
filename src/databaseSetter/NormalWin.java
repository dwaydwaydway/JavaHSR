package databaseSetter;

import server.Database;

public class NormalWin {
	public static void main(String[] args) {
		DatabaseSetter database = new DatabaseSetter();
		
		database.insertNormalWin("1", "1", "A");
		for(int i = 2; i < 14; i++) {
			database.insertNormalWin("1", i + "", "A");
			database.insertNormalWin("1", i + "", "E");
		}
		
		database.insertNormalWin("2", "1", "A");
		for(int i = 2; i < 20; i++) {
			database.insertNormalWin("2", i + "", "A");
			database.insertNormalWin("2", i + "", "E");
		}
		
		database.insertNormalWin("3", "1", "A");
		for(int i = 2; i < 19; i++) {
			database.insertNormalWin("3", i + "", "A");
			database.insertNormalWin("3", i + "", "E");
		}
		
		database.insertNormalWin("4", "1", "A");
		for(int i = 2; i < 20; i++) {
			database.insertNormalWin("4", i + "", "A");
			database.insertNormalWin("4", i + "", "E");
		}
		
		database.insertNormalWin("5", "1", "A");
		for(int i = 2; i < 18; i++) {
			database.insertNormalWin("5", i + "", "A");
			database.insertNormalWin("5", i + "", "E");
		}
		
		database.insertNormalWin("7", "12", "E");
		for(int i = 1; i < 12; i++) {
			database.insertNormalWin("7", i + "", "A");
			database.insertNormalWin("7", i + "", "E");
		}
		
		database.insertNormalWin("8", "1", "A");
		for(int i = 2; i < 20; i++) {
			database.insertNormalWin("8", i + "", "A");
			database.insertNormalWin("8", i + "", "E");
		}
		
		database.insertNormalWin("9", "1", "A");
		for(int i = 2; i < 19; i++) {
			database.insertNormalWin("9", i + "", "A");
			database.insertNormalWin("9", i + "", "E");
		}
	}
}