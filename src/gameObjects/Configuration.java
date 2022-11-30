package gameObjects;

public class Configuration {
	private Player player;
	private String numeroJugadores;
	private String MontoApuesta;
	
	private int numeroJugadoresConvertido;
	private int MontoApuestaConvertido;
	
	public Configuration(Player player) {
		this.player=player;
	}
	public String getNumeroJugadores() {
		
		return numeroJugadores;
		
		
	}
	public void setNumeroJugadores(String numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
	}
	public String getMontoApuesta() {
		return MontoApuesta;
	}
	public void setMontoApuesta(String montoApuesta) {
		MontoApuesta = montoApuesta;
	}
	public int getNumeroJugadoresConvertido() {
		return numeroJugadoresConvertido;
	}
	public void setNumeroJugadoresConvertido(int numeroJugadoresConvertido) {
		this.numeroJugadoresConvertido = numeroJugadoresConvertido;
	}
	public int getMontoApuestaConvertido() {
		return MontoApuestaConvertido;
	}
	public void setMontoApuestaConvertido(int montoApuestaConvertido) {
		MontoApuestaConvertido = montoApuestaConvertido;
	}
	
	
	
	
}
