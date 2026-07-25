package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL="jdbc:mysql://localhost:3306/booking_system";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";

	public static Connection getConnection() {
		Connection con =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String [] args) {
		try(Connection con=getConnection()){
			if(con!=null) {
			System.out.println("Connected Succesfully");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
