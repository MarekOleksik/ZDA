package samplesGUI.test9;

import java.awt.AWTEvent;

public class GameEvent extends AWTEvent {

	public static final int GAME_EVENT = AWTEvent.RESERVED_ID_MAX + 123;

	public static enum GameEventType {
		PICK, SHUFFLE, NEW, END
	};

	private GameEventType type = GameEventType.END;

	public GameEvent(Object source, GameEventType et) {
		super(source, GAME_EVENT);
		type = et;
	}

	public GameEventType getEventType() {
		return type;
	}
}
