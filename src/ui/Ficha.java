package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gameObjects.FichaPosicion;
import gameObjects.TableroPosiciones;
import graphics.Assets;
import graphics.Text;
import input.KeyBoardInput;
import input.MouseInput;
import math.Vector2D;

public class Ficha {
	private BufferedImage mouseOutImage;
	private BufferedImage mouseInImage;
	private boolean mouseIn;
	private int x,y;
	private FichaPosicion fpos;
	private int numeroPosicion;

	public Ficha(BufferedImage mouseOutImage, BufferedImage mouseInImage
			,int posInicial
	) {
		this.mouseInImage = mouseInImage;
		this.mouseOutImage = mouseOutImage;
		TableroPosiciones tablero=new TableroPosiciones();
		fpos=tablero.BuscarPosicion(posInicial);
		numeroPosicion=posInicial;
		
		x=fpos.getX();
		y=fpos.getY();
		
	}

	public void update(FichaPosicion fpos) {
		if(fpos!=null) {
			x=fpos.getX();
			y=fpos.getY();
		}
		
	}

	public void draw(Graphics g) {

		g.drawImage(mouseInImage, x, y, null);

	}
	public void setNumeroPosicion(int posicion) {
		numeroPosicion=posicion;
	}
	public int getNumeroPosicion() {
		return numeroPosicion;
	}

}
