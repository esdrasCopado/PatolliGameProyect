package chainResponsibility;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import gameObjects.Configuration;
import states.MenuState;
import states.State;

public class NumeroJugadoresMiddlewere extends Middleware{

	@Override
	public boolean check(Configuration conf) {
		String n=conf.getNumeroJugadores();
		try {
			int i=Character.getNumericValue(n.charAt(0));
			if(i==2||i==4) {
				conf.setNumeroJugadoresConvertido(i);
			}else {
				JOptionPane.showMessageDialog(null, "dato invalido: solo de 2 o 4");
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "dato invalido numero jugadores");
			return false;
			
		}
		
		
		return checkNext(conf);
	}
	
	
}
