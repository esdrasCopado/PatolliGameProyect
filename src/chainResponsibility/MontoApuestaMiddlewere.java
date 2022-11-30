package chainResponsibility;

import javax.swing.JOptionPane;

import gameObjects.Configuration;
import states.MenuState;
import states.State;

public class MontoApuestaMiddlewere extends Middleware{

	@Override
	public boolean check(Configuration conf) {
		String n=conf.getMontoApuesta();
		try {
			String montoApuesta=n.substring(0,n.length()-1);
			int i=Integer.parseInt(montoApuesta);
			conf.setMontoApuestaConvertido(i);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "dato invalido solo numeros, sin espacios");
			return false;
			
		}
		
		
		return checkNext(conf);
		
	}

}
