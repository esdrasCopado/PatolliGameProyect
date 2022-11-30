package conexionDB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

	public static final String URL = "jdbc:mysql://localhost/patolligame";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";

	public Connection getConection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return con;
	}

}
