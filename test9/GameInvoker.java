package samplesGUI.test9;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameInvoker extends JPanel implements Runnable {

	private ArrayList<JLabel> etykietki = new ArrayList<JLabel>();

	
	public void setNewLabel(String txt, Color c) {
		JLabel jl = new JLabel(txt);
		jl.setOpaque(true);
		jl.setBackground(c);
		etykietki.add(jl);
		this.add(jl);
		this.revalidate();
		this.repaint();
	}


	GameInvoker() {
		this.setLayout(new FlowLayout());
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			GameEvent ge1 = new GameEvent(this, GameEvent.GameEventType.PICK);
			queue.postEvent(ge1);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			
			GameEvent ge2 = new GameEvent(this, GameEvent.GameEventType.SHUFFLE);
			queue.postEvent(ge2);
		}
	}

	public void addGameListener(GameListener listener) {
		listenerList.add(GameListener.class, listener);
	}

	public void removeGameListener(GameListener listener) {
		listenerList.remove(GameListener.class, listener);
	}

	@Override
	public void processEvent(AWTEvent evt) {
		GameListener[] listeners = listenerList.getListeners(GameListener.class);
		if (evt instanceof GameEvent) {
			for (int i = 0; i < listeners.length; i++) {
				GameEvent ge = (GameEvent) evt;
				switch (ge.getEventType()) {
				case PICK:
					listeners[i].pick(ge);
					break;
				case SHUFFLE:
					listeners[i].shuffle(ge);
					break;
				}
			}
		} else {
			super.processEvent(evt);
		}
	}
}
