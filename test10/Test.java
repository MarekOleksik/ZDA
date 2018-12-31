package samplesGUI.test10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Test extends JFrame {
	public static void main(String[] a) {
		new Test();
	}

	Test() { 
		// tworzymy w�asny przycisk i dodajemy do ramki
		MojPrzycisk b = new MojPrzycisk("Przycisk");
		getContentPane().add(b);
		
		// ustawiamy s�uchacza, kt�ry zareaguje na klikni�cie przycisku
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				b.clickNr++;
				//b.repaint() //niepotrzebne, bo i tak przycisk musi si� odrysowa�(�eby zmieni� wygl�d z klikni�tego na wypuk�y)
			}
		});
		
		
		// tworzymy w�asny panel i dodajemy do ramki
		MojPanel p = new MojPanel();
		getContentPane().add(p);
		//ustawialy mu wygl�d
		p.setPreferredSize(new Dimension(100, 100));
		p.setBackground(Color.yellow);
		
		//dodajemy s�uchacza na klik myszki (panel nie ma actionListenera, bo nie ma �adnej 'akcji')
		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.clickNr++;
				//odmalowujemy panel
				p.repaint(); // potrzebne, bo panelu si� sam z siebie nie od�wie�y
			}
		});

		setLayout(new FlowLayout());
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// klasa opisuj�ca przycisk
	private class MojPrzycisk extends JButton {
		private int clickNr = 0; //wewn�trzny licznik

		public MojPrzycisk(String txt) {
			super(txt);
		}

		@Override
		protected void paintComponent(Graphics g) {
			// wywo�anie metody z nadklasy dzi�ki czemu MojPrzycisk b�dzie mia� wygl�d JButton
			// zakomentowanie tej linii spowoduje brak wy�wietlania tekstu i gradientu na przycisku
			super.paintComponent(g);
			
			//metoda ustawiaj�ca kolor 'p�dzla'
			g.setColor(Color.red);
			for(int i=0;i<clickNr;i++)
				//rysowanie k� w takiej liczbie ile by�o m�wi wewn�trzny licznik
				g.drawOval(i*10, 0, 10, 10);

			// ustawianie czcionki kontekstu graficznego (ale nie tekstu na przycisku)
		    g.setFont(new Font("Courier New", 1, 17));
		    // ustawienia koloru za pomoc� przestrzeni barw HSB(hue(barwa),saturation(nasycenie),brightness(jasno��))
		    g.setColor(Color.getHSBColor(0.3f, 0.5f, 0.6f));
		    // rysowanie tekstu
		    g.drawString("JAVA", 30, 30);
		}
	}
	class MojPanel extends JPanel {
		int clickNr = 0;

		//metoda analogiczna jak w przypadku klasy MojPrzycisk
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.red);
			for(int i=0;i<clickNr;i++)
				g.drawOval(i*10, 0, 10, 10);

		    g.setFont(new Font("Courier New", 1, 17));
		     
		    g.setColor(Color.getHSBColor(0.3f, 0.5f, 0.6f));
		    g.drawString("JAVA", 30, 30);
		}
	}
	
}