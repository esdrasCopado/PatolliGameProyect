package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import graphics.Assets;
import graphics.Text;
import input.MouseInput;
import math.Vector2D;

public class Button {

	
	private BufferedImage mouseOutImage;
	private BufferedImage mouseInImage;
	private boolean mouseIn;
	private Rectangle boundingBox;
	private Action action;
	private String text;
	
	public Button(
			BufferedImage mouseOutImage,
			BufferedImage mouseInImage,
			int x,int y,
			String text,Action action
			
			) {
		this.mouseInImage=mouseInImage;
		this.mouseOutImage=mouseOutImage;
		this.text=text;
		this.action=action;
		boundingBox=new Rectangle(x, y, mouseInImage.getWidth(), mouseInImage.getHeight());
		
	}
	
	public void update() {
		
		
		if(boundingBox.contains(MouseInput.X,MouseInput.Y)) {
			mouseIn=true;
			
		}else {
			mouseIn=false;
		}
		
		if(mouseIn&&MouseInput.mouseLeftButton) {
			action.doAction();
		}
		
	}
	public void draw(Graphics g) {
		
		if(mouseIn) {
			g.drawImage(mouseInImage, boundingBox.x, boundingBox.y, null);
			Text.drawText(g, text, new Vector2D(boundingBox.getX() + boundingBox.getWidth() / 2,
					boundingBox.getY() + boundingBox.getHeight()), true, Color.white, Assets.fontBig);
			
		}else {
			g.drawImage(mouseOutImage, boundingBox.x, boundingBox.y, null);
			Text.drawText(g, text, new Vector2D(boundingBox.getX() + boundingBox.getWidth() / 2,
					boundingBox.getY() + boundingBox.getHeight()), true, Color.BLACK, Assets.fontBig);
		}
		
		
	}
	
}
