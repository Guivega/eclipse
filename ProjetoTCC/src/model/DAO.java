package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	private static Connection con;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/Acesso";
	private static String user = "root";
	private static String password = "Saopaulo.1620";
	
	public static Connection conectar() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
