package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.text.JTextComponent.KeyBinding;

import graphics.Assets;
import graphics.Text;
import input.KeyBoardInput;
import input.MouseInput;
import input.KeyBoardInput;
import math.Vector2D;

public class TextArea {
	private BufferedImage mouseOutImage;
	private BufferedImage mouseInImage;
	private boolean mouseIn;
	private Rectangle boundingBox;
	private Action action;
	private String text="";
	
	public TextArea(
			BufferedImage mouseOutImage,
			BufferedImage mouseInImage,
			int x,int y,Action action
			
			) {
		this.mouseInImage=mouseInImage;
		this.mouseOutImage=mouseOutImage;
		
		this.action=action;
		boundingBox=new Rectangle(x, y, mouseInImage.getWidth(), mouseInImage.getHeight());
		
	}
	
	public void update() {
		
		
		if(boundingBox.contains(MouseInput.X,MouseInput.Y)) {
			mouseIn=true;
			
		}else {
			mouseIn=false;
		}
		
		if(mouseIn&&KeyBoardInput.pressedEnter) {
			action.doAction();
			
		}
		if(mouseIn) {
			text=KeyBoardInput.palabra;
		}
		
		
	}
	public void draw(Graphics g) {
		
		if(mouseIn) {
			g.drawImage(mouseInImage, boundingBox.x, boundingBox.y, null);
			Text.drawText(g, text, new Vector2D(boundingBox.getX() + boundingBox.getWidth() / 2,
					boundingBox.getY() + boundingBox.getHeight()), true, Color.black, Assets.fontBig);
			
		}else {
			g.drawImage(mouseOutImage, boundingBox.x, boundingBox.y, null);
			Text.drawText(g, text, new Vector2D(boundingBox.getX() + boundingBox.getWidth() / 2,
					boundingBox.getY() + boundingBox.getHeight()), true, Color.BLACK, Assets.fontBig);
		}
		
		
	}
}
