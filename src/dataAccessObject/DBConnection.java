package dataAccessObject;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class DBConnection {
	static Scanner sc = new Scanner(System.in);
	static String url = "jdbc:mysql://localhost:3306/employee_payroll";
	private static String username = "root";
	private static String password = "root";
	public static Connection con = null;
	
	public static boolean makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		try {
			con = DriverManager.getConnection(url, username, password);
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void destroyConnection() {
		 try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}
