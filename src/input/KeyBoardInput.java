package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardInput implements KeyListener{

	private char letra;
	public static String palabra="";
	public static boolean pressedEnter;
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==8) {
			borrarPalabra();
		}else {
			letra=e.getKeyChar();
			palabra+=letra;
		}
		if(e.getKeyCode()==10) {
			pressedEnter=true;
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void borrarPalabra() {
		String palabraAux;
		if(palabra==""||palabra.length()<=0) {
			palabra=palabra;
		}else {
			palabra=palabra.substring(0, palabra.length()-1);
		}
	}
	public void keyUpdate() {
		
	}

}
