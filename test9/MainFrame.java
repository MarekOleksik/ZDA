package samplesGUI.test9;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame{
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			 @Override
		       public void run(){
		           new MainFrame();
		       }
		  });
	}
	
	
	
	public MainFrame(){
		GameListener gProsty = new ProstySluchacz();
		
		Dane d = new Dane("123");
		GameListener gInny = new InnySluchacz(d);
		
		GameListener gNaMiejscu = new GameListener(){
			String txt = "xyz";
			@Override
			public void pick(GameEvent e) {
				GameInvoker gi = (GameInvoker) e.getSource();
				gi.setNewLabel(txt,Color.RED);
				txt+=" pick";
			}
			@Override
			public void shuffle(GameEvent e) {
				GameInvoker gi = (GameInvoker) e.getSource();
				gi.setNewLabel(txt,Color.yellow);
				txt+=" shuffle";
			}
		};
		
		
		GameInvoker gi1 = new GameInvoker();
		gi1.setBounds(10, 10, 400, 200);
		gi1.setBackground(Color.GREEN);
		getContentPane().add(gi1);
		
		gi1.addGameListener(gProsty);
		
		GameInvoker gi2 = new GameInvoker();
		gi2.setBounds(10, 220, 400, 200);
		gi2.setBackground(Color.BLUE);
		getContentPane().add(gi2);
		
		gi2.addGameListener(gInny);
		gi2.addGameListener(gNaMiejscu);
		
		setLayout(null);
		setSize(440,470);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
