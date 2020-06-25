package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/ojee_db";
	public static final String USER = "sandeep";
	public static final String PASSWORD = "sandeep";
	public static Connection getConnetion( )throws Exception{
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
