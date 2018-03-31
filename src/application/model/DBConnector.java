package application.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Utility class with method connectToDb()
// main parameter to connect to mysql database
public class DBConnector {
	// jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false;
	private final static String url = "jdbc:mysql://localhost:3306/";
	private final static String database = "?autoReconnect=true&useSSL=false";
	private final static String userName = "root";
	private final static String password = "mysql123";
	private static String dataBaseName;

	static Connection connectToDb() {
		try {
			return DriverManager.getConnection(url + dataBaseName + database, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getDataBaseName() {
		return dataBaseName;
	}

	public static void setDataBaseName(String dataBaseName) {
		DBConnector.dataBaseName = dataBaseName;
	}
	
}
