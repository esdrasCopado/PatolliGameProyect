package math;

import gameObjects.TableroPosiciones;

public class Vector2D {
	TableroPosiciones posiciones;
	
	private double X,Y;
	public Vector2D(int posicion) {
		
		posiciones=new TableroPosiciones();
		posiciones.BuscarPosicion(posicion);
		
		this.X=posiciones.getX();
		this.Y=posiciones.getY();
		
	}
	public Vector2D(double x, double y)
	{
		this.X = x;
		this.Y = y;
	}
	public Vector2D() {
		X=0;
		Y=0;
	}
	public double getX() {
		return X;
	}
	public void setX(double x) {
		X = x;
	}
	public double getY() {
		return Y;
	}
	public void setY(double y) {
		Y = y;
	}
}
