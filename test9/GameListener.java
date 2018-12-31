package samplesGUI.test9;

import java.util.EventListener;

public interface GameListener extends EventListener{
public abstract void pick(GameEvent e);
public abstract void shuffle(GameEvent e);
}

