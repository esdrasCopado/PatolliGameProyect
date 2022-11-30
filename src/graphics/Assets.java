package graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage player1,player2,player3,player4,tablero,imagenFondo;
	
	public static Font fontBig;
	public static Font fontMed;
	
	public static BufferedImage blueBtn;
	public static BufferedImage greyBtn;
	public static BufferedImage textAreaImage,textOutput;
	
	
	
	public static void init()
	{
		player1 = loadImage("/players/player1.png");
		player2 = loadImage("/players/player2.png");
		player3 = loadImage("/players/player3.png");
		player4 = loadImage("/players/player4.png");
		tablero=  loadImage("/Tablero.png");
		imagenFondo=Loader.ImageLoader("/Fondo.png");
		
		greyBtn = loadImage("/button/button1.png");
		blueBtn = loadImage("/button/button2.png");
		textAreaImage=loadImage("/button/textArea.png");
		textOutput=loadImage("/button/TextOutput.png");
		
		fontMed=loadFont("/fonts/Roboto-Black.ttf", 18);
		fontBig=loadFont("/fonts/Roboto-Black.ttf", 26);
		
		//fontBig = loadFont("/fonts/futureFont.ttf", 42);
		
		//fontMed = loadFont("/fonts/futureFont.ttf", 20);

	}
	
	public static BufferedImage loadImage(String path) {
		
		return Loader.ImageLoader(path);
	}
	public static Font loadFont(String path, int size) {
		
		return Loader.loadFont(path, size);
	}
	
	
	
}
