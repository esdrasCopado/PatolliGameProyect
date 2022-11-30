package gameObjects;

public class FichaPosicion {
	
	int Y,X,posicion;

	public FichaPosicion(int x, int y,int posicion) {
		
		Y = y;
		X = x;
		this.posicion=posicion;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}
	public int getPosicion() {
		return posicion;
	}
	
	
}
