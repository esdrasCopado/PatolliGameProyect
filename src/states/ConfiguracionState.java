package states;

import java.awt.Graphics;
import java.util.ArrayList;

import chainResponsibility.GuardarConfiguracioDBMiddlewere;
import chainResponsibility.Middleware;
import chainResponsibility.MontoApuestaMiddlewere;
import chainResponsibility.NumeroJugadoresMiddlewere;
import chainResponsibility.iniciarJuegoMiddlewere;
import gameObjects.Configuration;
import gameObjects.Player;
import graphics.Assets;
import input.KeyBoardInput;
import ui.*;
public class ConfiguracionState extends State{

	private ArrayList<TextArea> texts=new ArrayList<>();
	private ArrayList<Button> buttons=new ArrayList<>();
	private Player player;
	private Configuration configuration;
	public ConfiguracionState(Player player) {
		this.player=player;
		configuration=new Configuration(player);
		texts.add(new TextArea(Assets.textAreaImage, Assets.textAreaImage, 600, 300, new Action() {

			@Override
			public void doAction() {
				configuration.setNumeroJugadores(KeyBoardInput.palabra);
				KeyBoardInput.palabra="";
				KeyBoardInput.pressedEnter=false;
			}
		}));
		texts.add(new TextArea(Assets.textAreaImage, Assets.textAreaImage, 600, 400, new Action() {

			@Override
			public void doAction() {
				configuration.setMontoApuesta(KeyBoardInput.palabra);
				KeyBoardInput.palabra="";
				KeyBoardInput.pressedEnter=false;
				

			}
		}));
		
		buttons.add(new Button(Assets.textOutput, Assets.blueBtn, 300, 200, "Jugador: "+player.getNombre().toUpperCase(), new Action() {

			@Override
			public void doAction() {
				// TODO Auto-generated method stub

			}
		}));
		buttons.add(new Button(Assets.textOutput, Assets.blueBtn, 300, 300, "numero jugadores", new Action() {

			@Override
			public void doAction() {
				// TODO Auto-generated method stub

			}
		}));

		buttons.add(new Button(Assets.textOutput, Assets.blueBtn, 300, 400, "monto apuesta", new Action() {

			@Override
			public void doAction() {
				// TODO Auto-generated method stub

			}
		}));
		buttons.add(new Button(Assets.greyBtn, Assets.blueBtn, 330, 500, "Aceptar", new Action() {

			@Override
			public void doAction() {
				Middleware middleware=Middleware.link(new NumeroJugadoresMiddlewere(),new MontoApuestaMiddlewere(),new GuardarConfiguracioDBMiddlewere(),new iniciarJuegoMiddlewere());
				middleware.check(configuration);

			}
		}));
		buttons.add(new Button(Assets.greyBtn, Assets.blueBtn, 590, 500, "Cancelar", new Action() {

			@Override
			public void doAction() {
				State.changeState(new MenuState());

			}
		}));

	}
	
	
	@Override
	public void update() {
		for(TextArea t:texts) {
			t.update();
		}
		for(Button b:buttons) {
			b.update();
		}
		
	}

	@Override
	public void draw(Graphics g) {
		for(TextArea t:texts) {
			t.draw(g);
		}
		for(Button b:buttons) {
			b.draw(g);
		}
		
		
		
		
	}

}
