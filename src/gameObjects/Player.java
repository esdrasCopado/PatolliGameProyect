package gameObjects;

public class Player {
	private String nombre, apellido;
	public Player() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void imprimir() {
		System.out.println(nombre+" "+apellido);
	}
	
}
