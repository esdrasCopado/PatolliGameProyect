package states;

import java.awt.Graphics;
import java.util.ArrayList;

import gameObjects.Player;
import graphics.Assets;
import input.KeyBoardInput;
import ui.Action;
import ui.Button;
import ui.TextArea;

public class MenuState extends State{
	
	private ArrayList<Button> buttons=new ArrayList<>();
	private TextArea text;
	private ArrayList<TextArea> texts=new ArrayList<>();
	private Player player;
	private String advertencia="";
	public MenuState() {
		player=new Player();
		buttons.add(new Button(Assets.greyBtn, Assets.blueBtn, 0, 0, "Crear Partida", new Action() {
			
			@Override
			public void doAction() {
				if(player.getNombre()!=null) {
					State.changeState(new ConfiguracionState(player));
				}else {
					advertencia="Introdusca Nombre";
				}
				
				
			}
		}));
		buttons.add(new Button(Assets.greyBtn, Assets.blueBtn, 0, 70, "Unirse Partida", new Action() {
			
			@Override
			public void doAction() {
				if(player.getNombre()!=null) {
					State.changeState(new BuscarPartidaState());
				}else {
					advertencia="Introdusca Nombre";
				}
				
				
			}
		}));
		buttons.add(new Button(Assets.greyBtn, Assets.blueBtn, 1010, 750, "Nombre Usuario", new Action() {
			
			@Override
			public void doAction() {
				if(player.getNombre()==null||player.getNombre()==" ") {
					advertencia="Introdusca Nombre";
				}else {
					
					advertencia="Nombre Guardado";
				}
				
			}
		}));
		texts.add(new TextArea(Assets.textAreaImage, Assets.textAreaImage, 1010, 690,new Action() {
			
			@Override
			public void doAction() {
				player.setNombre(KeyBoardInput.palabra);
				KeyBoardInput.palabra="";
				KeyBoardInput.pressedEnter=false;
				advertencia="Nombre Guardado";
				
			}
		}));
		
	}
	@Override
	public void update() {
		for(Button b:buttons) {
			b.update();
		}
		for(TextArea t:texts) {
			t.update();
			
		}
		
	}

	@Override
	public void draw(Graphics g) {
		for(Button b:buttons) {
			b.draw(g);
		}
		for(TextArea t:texts) {
			t.draw(g);
		}
		g.drawString(advertencia, 1010, 670);
		
	}

}
