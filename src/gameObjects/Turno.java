package gameObjects;

import java.math.MathContext;

public class Turno {
	boolean turno;
	
	public boolean getTurno() {
		return turno;
	}
	public void setTurno(boolean turno) {
		this.turno= turno;
	}
	
	public int generarTirarCana() {
		int upBound=10;
		int lowBound=1;
		int range=(upBound-lowBound)+1;
		turno=false;
		return (int)(Math.random()*range)+lowBound;
	}
}
