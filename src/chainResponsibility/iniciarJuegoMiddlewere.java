package chainResponsibility;

import gameObjects.Configuration;
import states.GameState;
import states.State;

public class iniciarJuegoMiddlewere extends Middleware{

	@Override
	public boolean check(Configuration conf) {
		State.changeState(new GameState(conf));
		return true;
	}

}
