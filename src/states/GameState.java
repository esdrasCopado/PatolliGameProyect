package states;

import java.awt.Graphics;
import java.util.ArrayList;

import gameObjects.Configuration;
import gameObjects.FichaPosicion;
import gameObjects.TableroPosiciones;
import gameObjects.Turno;
import graphics.Assets;
import math.Vector2D;
import soket.ChatClient;
import soket.ChatServer;
import soket.MessageClient;
import ui.Action;
import ui.Button;
import ui.Ficha;

public class GameState extends State{
	
	private ArrayList<Ficha> fichas=new ArrayList<>();
	private Ficha ficha1;
	private Ficha ficha2;
	private Ficha ficha3;
	private Ficha ficha4;
	private TableroPosiciones posicion;
	private int pos=1;
	private Button button;
	private Turno turno;
	private TableroPosiciones posicionesTablero;
	private FichaPosicion fichaPos;
	private ChatClient client;
	private Configuration config;
	private int numeroJugadores;
	private boolean updatte=false;
	private int contador=0,playerAnterior;
	
	public GameState(Configuration config) {
		this.config=config;
		client=new ChatClient("localhost", 8002);
		client.execute();
		turno=new Turno();
		posicionesTablero=new TableroPosiciones();
		int jugadores=config.getNumeroJugadoresConvertido();
		
			
		numeroJugadores=jugadores;
		
		if(numeroJugadores==2) {
			ficha1=new Ficha(Assets.player1, Assets.player1,1);
			ficha2=new Ficha(Assets.player3, Assets.player3,39);
		}
		if(numeroJugadores==4) {
			ficha1=new Ficha(Assets.player1, Assets.player1,1);	
			ficha2=new Ficha(Assets.player2, Assets.player2,22);
			ficha3=(new Ficha(Assets.player3, Assets.player3,39));
			ficha4=new Ficha(Assets.player4, Assets.player4,56);
		}

		//jugadorPrincipal=Character.getNumericValue(a.charAt(0));

		button=new Button(Assets.greyBtn, Assets.blueBtn, 1000, 750, "tirar caña", new Action() {
			
			@Override
			public void doAction() {
					int pos=turno.generarTirarCana();
					
					client.escribir(""+pos);
					updatte=true;
			}
		
		}
			
		);
		
		
		
		
	}

	public void update() {
		String a = client.mensaje;
		
		if (a != null) {
			System.out.println(a);
			int jugador = Character.getNumericValue(a.charAt(0));
			String pos = a.substring(1, a.length());
			int posInt = Integer.parseInt(pos);
			fichaPos = posicionesTablero.BuscarPosicion(posInt);
			if(jugador!=playerAnterior) {
				contador=0;
			}

			if (contador==0) {
				
				if (jugador == 1) {
					int i = ficha1.getNumeroPosicion() + posInt;
					System.out.println(ficha1.getNumeroPosicion()+" "+posInt+" "+i);
					
					ficha1.setNumeroPosicion(i);
					ficha1.update(fichaPos);
				}
				if (jugador == 2) {
					int i = ficha2.getNumeroPosicion() + posInt;
					
					fichaPos = posicionesTablero.BuscarPosicion(i);
					ficha2.setNumeroPosicion(i);
					ficha2.update(fichaPos);

				}
				if (jugador == 3) {
					int i = ficha3.getNumeroPosicion() + posInt;
					
					fichaPos = posicionesTablero.BuscarPosicion(i);
					ficha3.setNumeroPosicion(i);
					ficha3.update(fichaPos);

				}
				if (jugador == 4) {
					int i = ficha4.getNumeroPosicion() + posInt;
					
					fichaPos = posicionesTablero.BuscarPosicion(i);
					ficha4.setNumeroPosicion(i);
					ficha4.update(fichaPos);

				}
				playerAnterior=jugador;
				contador++;
			}

			
		}

		button.update();
	}
	public void draw(Graphics g) {
		g.drawImage(Assets.tablero,200, 0, null);
		if(numeroJugadores==2) {
			ficha1.draw(g);
			ficha2.draw(g);
		}
		if(numeroJugadores==4) {
			ficha1.draw(g);
			ficha2.draw(g);
			ficha3.draw(g);
			ficha4.draw(g);
		}
		button.draw(g);
	}
	
	public void setPos(int pos) {
		this.pos=pos;
	}
	
	
}
