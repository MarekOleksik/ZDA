package samplesGUI.gra2;

import java.util.EventListener;

public interface GameListener extends EventListener{
	public abstract void pick(GameEvent e);
	public abstract void shuffle(GameEvent e);
	public abstract void newGame(GameEvent e);
	public abstract void end(GameEvent e);
	

}
