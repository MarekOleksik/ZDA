package samplesGUI.gra2;

import java.awt.AWTEvent;

public class GameEvent extends AWTEvent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int GAME_EVENT = AWTEvent.RESERVED_ID_MAX + 1234;
	
	private int pickNr = 0;
	public static enum GameEventType {PICK,SHUFFLE,NEW,END};
	private GameEventType type;
	
	public GameEvent(Object source, GameEventType et) {
		super(source, GAME_EVENT );
		type = et;
	}
	
	public int getPickNr(){return pickNr;}
	public GameEventType getEventType(){return type;}
}
