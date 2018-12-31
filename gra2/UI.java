package samplesGUI.gra2;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;


public class UI extends JPanel{

	private Mechanics m;

	private boolean [] result;	
	private GameInvoker [] cups;
	private JLabel score;
	private JLabel msg;
	
	UI(Mechanics mech){
		m = mech;
		result = new boolean[m.nrCups];
		
		score = new JLabel("Wynik:");
		score.setBounds(10, 100,200, 50);
		add(score);
		msg = new JLabel("Kliknij na wybrany kubek lub wymieszaj kółkiem myszy");
		msg.setBounds(10, 150, 200, 50);
		add(msg);
		
		setLayout(null);
		setBounds(0, 0, 350, 450);
		
		
		cups = new GameInvoker[m.nrCups];
		for(int i=0;i<m.nrCups;i++){
			cups[i] = new GameInvoker();
			cups[i].addGameListener(new CupListener(i));
			cups[i].addKeyboardListeners(this);
			add(cups[i]);
		}
		printCups();
	}

	
	// metody pomocnicze
	private void printCups(){
		for(int i=0;i<cups.length;i++){
			cups[i].setBounds(10+i*60, 10, 50, 50);
			cups[i].setBackground(Color.MAGENTA);
			cups[i].setBorder(BorderFactory.createEmptyBorder());
		}
	}
	private void printCupsResult(int nr){
		for(int i=0;i<cups.length;i++){
			cups[i].setBounds(10+i*60, 10, 50, 50);
			cups[i].setBorder(BorderFactory.createEmptyBorder());
			if(result[i])
				cups[i].setBackground(Color.CYAN);
			else
				cups[i].setBackground(Color.MAGENTA);
		}
		cups[nr].setBorder(BorderFactory.createLineBorder(Color.black));
	}	
	
	class CupListener implements GameListener{
		private int nr;
		CupListener(int n){
			nr = n;
		}
		@Override
		public void pick(GameEvent e){	
			try {
				result = m.checkCup(nr);
				printCupsResult(nr);
				score.setText("Wynik:"+m.getScore());
				msg.setText(result[nr]?"Trafiłeś!":"Pudło!");
			} catch (CupNrOutOfRange e1) {
				msg.setText("Zbyt duża liczba: podaj liczbę z zakresu  1:" + (m.nrCups));
			}	
		}
		@Override
		public void shuffle(GameEvent e){
			printCups();
			m.shuffle();
		}
		@Override
		public void newGame(GameEvent e){
			System.out.println("Podaj liczbę kubków");
			Scanner s = new Scanner(System.in);
			int nr = s.nextInt();
			s.close();
			m.newGame(nr);
			System.out.println("NOWA GRA");
		}
		@Override
		public void end(GameEvent e){
			System.exit(0);
		}
	}

}
