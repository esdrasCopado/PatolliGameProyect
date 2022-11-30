package chainResponsibility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexionDB.ConexionDB;
import gameObjects.Configuration;

public class GuardarConfiguracioDBMiddlewere extends Middleware{

private int contador;
private Connection con;
private ConexionDB conexion;

public GuardarConfiguracioDBMiddlewere() {
	conexion=new ConexionDB();
}
	

	

	public void insertarDatos(Configuration conf) {
		String sql;
		PreparedStatement ps;
		if(contador==0) {
		try {
			
			contador++;
			con=conexion.getConection();
			sql="insert into configuracion(numeroJugadores, montoApuesta, montoMinimo) values(?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,conf.getNumeroJugadoresConvertido());
			ps.setInt(2, conf.getMontoApuestaConvertido());
			ps.setString(3, null);
		
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		}
	}
	@Override
	public boolean check(Configuration conf) {
		insertarDatos(conf);
		
		return checkNext(conf);
	}
}
