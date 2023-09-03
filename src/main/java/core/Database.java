package core;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	private static String url = "jdbc:mysql://localhost:3306/crud";
	private static String user = "root";
	private static String password = "";
	private static Connection link = null; 
	
	
	public void connection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			link = DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	public Connection getConnection() {
		return link;
	}
	
}
