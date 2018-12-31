package samplesGUI.test7;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dziêki czemu obiekt klasy Test jest rodzajem okna
class Test extends JFrame {

	// w metodzie main jest tylko utworzenie naszego okna Test
	public static void main(String[] a) {
		// wywo³anie konstruktora klasy Test
		new Test();
	}

	// konstruktor bezargumentowy
	public Test() {
		// ustawienie braku layoutu oznacza, ¿e nale¿y samodzielnie ustawiæ
		// wielkoœæ okna i po³o¿enie i wielkoœæ elementów
		setLayout(null);

		// utworzenie trzech przycisków
		JButton jb1 = new JButton("1");
		JButton jb2 = new JButton("2");
		JButton jb3 = new JButton("3");

		// ustawienie po³o¿enia przycisku w kontenerze i ich wielkoœci
		jb1.setBounds(10, 10, 100, 30);
		jb2.setBounds(10, 50, 100, 30);
		jb3.setBounds(10, 90, 100, 30);

		//S³uchacz myszki z zaimplementowanymi wszystkimi metodami
		jb1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("klik " + e.getClickCount() + " raz");
			}

			public void mouseEntered(MouseEvent e) {
				System.out.println("wejœcie - wsp. el :x=[" + e.getX() + ";" + e.getY() + "]");
			}

			public void mouseExited(MouseEvent e) {
				System.out.println("zejœcie - wsp X ekranu: x=[" + e.getXOnScreen() + "]");
			}

			public void mousePressed(MouseEvent e) {
				System.out.println("wciœniêcie przycisku w punkcie " + e.getPoint().toString());
			}

			public void mouseReleased(MouseEvent e) {
				System.out.println("puszczenie przycisku");
			}
		});
		
		//S³uchacz myszki z zaimplementowan¹ jedn¹ metod¹, a reszta ma puste cia³a
		jb2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("klik " + e.getClickCount() + " raz");
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		// S³uchacz myszki rozszerzaj¹cy MouseAdapter, dziêki czemu nie trzeba pisaæ pustych cia³ nieuzywanych metod
		jb3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("klik");
			}
		});

		// dodanie trzech przycisków do contentPane'a
		getContentPane().add(jb1);
		getContentPane().add(jb2);
		getContentPane().add(jb3);

		// ustawienie wielkoœci okna
		setSize(200, 300);
		// ustawienie zamykania aplikacji po zamkniêciu okna
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// pokazanie okna
		setVisible(true);

	}

}
