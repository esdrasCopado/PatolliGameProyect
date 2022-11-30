package chainResponsibility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexionDB.ConexionDB;
import gameObjects.Configuration;
import gameObjects.Player;

public class principal {
	private static Connection con;

	public static void main(String[] args) {
		int id=2;
		String sql = "SELECT numeroJugadores FROM configuracion WHERE id=";
		ConexionDB conexion = new ConexionDB();
		con = conexion.getConection();
		try {
			
			Statement stam = con.createStatement();

			ResultSet rs = stam.executeQuery(sql+id);
			int numeroJugadores=0;
			while(rs.next()) {
				numeroJugadores=rs.getInt("numeroJugadores");
			}
			rs.close();
			stam.close();
			
			
			System.out.println(numeroJugadores);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}
