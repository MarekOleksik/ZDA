package samplesGUI.test7;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dzi�ki czemu obiekt klasy Test jest rodzajem okna
class Test extends JFrame {

	// w metodzie main jest tylko utworzenie naszego okna Test
	public static void main(String[] a) {
		// wywo�anie konstruktora klasy Test
		new Test();
	}

	// konstruktor bezargumentowy
	public Test() {
		// ustawienie braku layoutu oznacza, �e nale�y samodzielnie ustawi�
		// wielko�� okna i po�o�enie i wielko�� element�w
		setLayout(null);

		// utworzenie trzech przycisk�w
		JButton jb1 = new JButton("1");
		JButton jb2 = new JButton("2");
		JButton jb3 = new JButton("3");

		// ustawienie po�o�enia przycisku w kontenerze i ich wielko�ci
		jb1.setBounds(10, 10, 100, 30);
		jb2.setBounds(10, 50, 100, 30);
		jb3.setBounds(10, 90, 100, 30);

		//S�uchacz myszki z zaimplementowanymi wszystkimi metodami
		jb1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("klik " + e.getClickCount() + " raz");
			}

			public void mouseEntered(MouseEvent e) {
				System.out.println("wej�cie - wsp. el :x=[" + e.getX() + ";" + e.getY() + "]");
			}

			public void mouseExited(MouseEvent e) {
				System.out.println("zej�cie - wsp X ekranu: x=[" + e.getXOnScreen() + "]");
			}

			public void mousePressed(MouseEvent e) {
				System.out.println("wci�ni�cie przycisku w punkcie " + e.getPoint().toString());
			}

			public void mouseReleased(MouseEvent e) {
				System.out.println("puszczenie przycisku");
			}
		});
		
		//S�uchacz myszki z zaimplementowan� jedn� metod�, a reszta ma puste cia�a
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

		// S�uchacz myszki rozszerzaj�cy MouseAdapter, dzi�ki czemu nie trzeba pisa� pustych cia� nieuzywanych metod
		jb3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("klik");
			}
		});

		// dodanie trzech przycisk�w do contentPane'a
		getContentPane().add(jb1);
		getContentPane().add(jb2);
		getContentPane().add(jb3);

		// ustawienie wielko�ci okna
		setSize(200, 300);
		// ustawienie zamykania aplikacji po zamkni�ciu okna
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// pokazanie okna
		setVisible(true);

	}

}
