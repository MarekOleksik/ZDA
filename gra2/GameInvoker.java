package samplesGUI.gra2;

import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;
import samplesGUI.gra2.GameEvent.GameEventType;

public class GameInvoker extends JPanel implements Runnable{

	/* Część odpowiadająca za listę słuchaczy(odziedziczoną z JPanel) oraz przetwarzanie zdarzeń z kolejki */
	public void addGameListener(GameListener listener) {
		listenerList.add(GameListener.class, listener);
	}
	public void removeGameListener(GameListener listener) {
		listenerList.remove(GameListener.class, listener);
	}
	@Override
	public void processEvent(AWTEvent evt) {
		GameListener[] listeners = listenerList.getListeners(GameListener.class);
		if (evt instanceof GameEvent){
			for (int i = 0; i < listeners.length; i++) {
				GameEvent ge = (GameEvent)evt;
				switch(ge.getEventType()){
				case PICK:
					listeners[i].pick(ge);
					break;
				case SHUFFLE:
					listeners[i].shuffle(ge);
					break;
				case END:
					listeners[i].end(ge);
					break;
				case NEW:
					listeners[i].newGame(ge);
					break;
				}
			}
		}else{
			super.processEvent(evt);
		}
	}

	/* metoda działania wątku w EDT */
	@Override
	public void run() {
		EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}

			if(newEvent){
				GameEvent ge = new GameEvent(this,get);
				queue.postEvent(ge);
				newEvent = false;
			}
		}
	}

	/* pola prywatne pozwalające na przekazywanie informacji ze słuchaczy do głównego wątku */
	private GameEventType get; 
	private boolean newEvent = false;

	/* konstruktor */
	GameInvoker(){

		/* Utworzenie wątku i uruchomienie go */
		Thread t = new Thread(this);
		t.start();

		/*dodanie słuchaczy do JPanelu*/
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				get = GameEventType.PICK;
				newEvent = true;
			}
		});
		addMouseWheelListener(new MouseAdapter(){
			@Override
			public void mouseWheelMoved(MouseWheelEvent e){
				get = GameEventType.SHUFFLE;
				newEvent = true;
			}
		});

	}

	public void addKeyboardListeners(JComponent parent){
		parent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					get = GameEventType.END;
					newEvent = true;
				}
				else if(e.getKeyCode() == KeyEvent.VK_N){
					get = GameEventType.NEW;
					newEvent = true;
				}
			}
		});
	}
}
