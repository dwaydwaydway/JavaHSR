package databaseSetter;

import server.Database;

public class Disable {
	public static void main(String[] args) {
		Database database = new Database();
		
		database.insertDisable("7", "13", "A");
		database.insertDisable("7", "14", "A");
		database.insertDisable("7", "13", "E");
		database.insertDisable("7", "14", "E");
		
		
	}
}
