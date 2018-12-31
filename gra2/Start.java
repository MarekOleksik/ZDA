package samplesGUI.gra2;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Start extends JFrame{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
	       public void run(){
	           new Start();
	       }
	  });	
	}

	Start(){
		Data d = new Data();
		Mechanics m = new Mechanics(d);
		UI ui = new UI(m);
		
		
		setSize(ui.getWidth(), ui.getHeight());
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(ui);
		setVisible(true);
	}
	
}
