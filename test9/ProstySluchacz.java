package samplesGUI.test9;

public class ProstySluchacz implements GameListener {
	public void pick(GameEvent e) {
		System.out.println("PICK:" + e.getSource());
	};

	public void shuffle(GameEvent e) {
		System.out.println("SHUFFLE:" + e.getSource());
	};
}
