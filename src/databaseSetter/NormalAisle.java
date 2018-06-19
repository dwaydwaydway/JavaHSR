package databaseSetter;

import server.Database;

public class NormalAisle {
	public static void main(String[] args) {
		DatabaseSetter database = new DatabaseSetter();
		
		database.insertNormalAisle("1", "1", "C");
		for(int i = 2; i < 14; i++) {
			database.insertNormalAisle("1", i + "", "C");
			database.insertNormalAisle("1", i + "", "D");
		}
		
		database.insertNormalAisle("2", "1", "C");
		database.insertNormalAisle("2", "20", "C");
		for(int i = 2; i < 20; i++) {
			database.insertNormalAisle("2", i + "", "C");
			database.insertNormalAisle("2", i + "", "D");
		}
		
		database.insertNormalAisle("3", "1", "C");
		for(int i = 2; i < 19; i++) {
			database.insertNormalAisle("3", i + "", "C");
			database.insertNormalAisle("3", i + "", "D");
		}
		
		database.insertNormalAisle("4", "1", "C");
		database.insertNormalAisle("4", "20", "C");
		for(int i = 2; i < 20; i++) {
			database.insertNormalAisle("4", i + "", "C");
			database.insertNormalAisle("4", i + "", "D");
		}
		
		database.insertNormalAisle("5", "1", "C");
		for(int i = 2; i < 18; i++) {
			database.insertNormalAisle("5", i + "", "C");
			database.insertNormalAisle("5", i + "", "D");
		}
		
		database.insertNormalAisle("7", "12", "D");
		for(int i = 1; i < 12; i++) {
			database.insertNormalAisle("7", i + "", "C");
			database.insertNormalAisle("7", i + "", "D");
		}
		
		database.insertNormalAisle("8", "1", "C");
		database.insertNormalAisle("8", "20", "C");
		for(int i = 1; i < 20; i++) {
			database.insertNormalAisle("8", i + "", "C");
			database.insertNormalAisle("8", i + "", "D");
		}
		
		database.insertNormalAisle("9", "1", "C");
		for(int i = 1; i < 19; i++) {
			database.insertNormalAisle("9", i + "", "C");
			database.insertNormalAisle("9", i + "", "D");
		}
	}
}