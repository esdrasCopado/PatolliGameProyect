package states;

import java.awt.Graphics;
import java.util.ArrayList;

import graphics.Assets;
import input.KeyBoardInput;
import input.MouseInput;
import ui.Action;
import ui.Button;

public class TirarState extends State{
	
	private ArrayList<Button>  buttons;
	
	public TirarState() {
		buttons.add(new Button(Assets.greyBtn, Assets.blueBtn, 1064, 544, "hola", new Action() {
			
			@Override
			public void doAction() {
				System.out.println("hola");
				
				
			}
		}));
		

	}
	@Override
	public void update() {
		for(Button b: buttons) {
			b.update();
		}
		
	}

	@Override
	public void draw(Graphics g) {
		for(Button b: buttons) {
			b.draw(g);
		}
		
	}

}
