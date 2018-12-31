package samplesGUI.test8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

//klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dzi�ki czemu obiekt klasy TestXtra jest rodzajem okna
class TestXtra extends JFrame {

	// w metodzie main jest tylko utworzenie naszego okna TestXtra
	public static void main(String[] a) {
		// wywo�anie konstruktora klasy TestXtra
		new TestXtra();
	}

	// konstruktor bezargumentowy
	public TestXtra() {
		// ustawienie braku layoutu oznacza, �e nale�y samodzielnie ustawi�
		// wielko�� okna i po�o�enie i wielko�� element�w
		setLayout(null);

		// utworzenie trzech przycisk�w
		JButton jb1 = new JButton("Poszerz");
		JButton jb3 = new JButton("inny");
		JButton jb2 = new JButton("Zw�");

		// ustawienie po�o�enia przycisku w kontenerze i ich wielko�ci
		jb1.setBounds(10, 10, 100, 30);
		jb2.setBounds(10, 50, 100, 30);
		jb3.setBounds(10, 90, 100, 30);

		// jeden s s�uchacz operuj�cy na wielu obiektach:
		// w konstruktorze przekazujemy mu tablic� referencji do obiekt�w
		// kt�rymi b�dzie operowa�
		SluchaczPoszerz slPoszerz = new SluchaczPoszerz(new JComponent[] { jb1, jb2, jb3 });
		// dodajemy tego s�uchacza tylko do przycisku 'jb1'
		jb1.addActionListener(slPoszerz);

		// w konstruktorze przekazujemy mu tablic� referencji do obiekt�w
		// kt�rymi b�dzie operowa�
		SluchaczZwez slZwez = new SluchaczZwez(new JComponent[] { jb1, jb2 });
		// dodajemy tego s�uchacza tylko do przycisku 'jb2'
		jb2.addActionListener(slZwez);

		// do trzeciego przycisku dodajemy obydwu s�uchaczy
		jb3.addActionListener(slZwez);
		jb3.addActionListener(slPoszerz);

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

	// wewn�trzna klasa s�uchacza implementuj�ca interfejs ActionListener
	private class SluchaczPoszerz implements ActionListener {
		// prywatne pole sk�adowe tej klasy
		private JComponent[] komponentySluchacza;

		// konstruktor z argumentem w postaci tablicy komponent�w
		private SluchaczPoszerz(JComponent[] jc) {
			// przypisanie argumentu wywo�ania do pola sk�adowego
			komponentySluchacza = jc;
		}

		// implementacja metody actionPerformed z interfejsu ActionListener
		@Override
		public void actionPerformed(ActionEvent ae) {
			// ta sama operacja wykonywana dla ka�dego z komponent�w s�uchacza
			for (JComponent jc : komponentySluchacza) {
				// zmiana wielko�ci - poszerzenie o 10 pikseli
				jc.setSize(jc.getWidth() + 10, jc.getHeight());
			}
		}
	}

	// wewn�trzna klasa s�uchacza implementuj�ca interfejs ActionListener
	private class SluchaczZwez implements ActionListener {
		// prywatne pole sk�adowe tej klasy
		private JComponent[] komponentySluchacza;

		SluchaczZwez(JComponent[] jc) {
			// przypisanie argumentu wywo�ania do pola sk�adowego
			komponentySluchacza = jc;
		}

		// implementacja metody actionPerformed z interfejsu ActionListener
		@Override
		public void actionPerformed(ActionEvent ae) {
			// ta sama operacja wykonywana dla ka�dego z komponent�w s�uchacza
			for (JComponent jc : komponentySluchacza) {
				// zmiana wielko�ci - zw�enie o 10 pikseli
				jc.setSize(jc.getWidth() - 10, jc.getHeight());
			}
		}
	}

}
