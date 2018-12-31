package samplesGUI.test8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

//klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dziêki czemu obiekt klasy TestXtra jest rodzajem okna
class TestXtra extends JFrame {

	// w metodzie main jest tylko utworzenie naszego okna TestXtra
	public static void main(String[] a) {
		// wywo³anie konstruktora klasy TestXtra
		new TestXtra();
	}

	// konstruktor bezargumentowy
	public TestXtra() {
		// ustawienie braku layoutu oznacza, ¿e nale¿y samodzielnie ustawiæ
		// wielkoœæ okna i po³o¿enie i wielkoœæ elementów
		setLayout(null);

		// utworzenie trzech przycisków
		JButton jb1 = new JButton("Poszerz");
		JButton jb3 = new JButton("inny");
		JButton jb2 = new JButton("Zwê¿");

		// ustawienie po³o¿enia przycisku w kontenerze i ich wielkoœci
		jb1.setBounds(10, 10, 100, 30);
		jb2.setBounds(10, 50, 100, 30);
		jb3.setBounds(10, 90, 100, 30);

		// jeden s s³uchacz operuj¹cy na wielu obiektach:
		// w konstruktorze przekazujemy mu tablicê referencji do obiektów
		// którymi bêdzie operowa³
		SluchaczPoszerz slPoszerz = new SluchaczPoszerz(new JComponent[] { jb1, jb2, jb3 });
		// dodajemy tego s³uchacza tylko do przycisku 'jb1'
		jb1.addActionListener(slPoszerz);

		// w konstruktorze przekazujemy mu tablicê referencji do obiektów
		// którymi bêdzie operowa³
		SluchaczZwez slZwez = new SluchaczZwez(new JComponent[] { jb1, jb2 });
		// dodajemy tego s³uchacza tylko do przycisku 'jb2'
		jb2.addActionListener(slZwez);

		// do trzeciego przycisku dodajemy obydwu s³uchaczy
		jb3.addActionListener(slZwez);
		jb3.addActionListener(slPoszerz);

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

	// wewnêtrzna klasa s³uchacza implementuj¹ca interfejs ActionListener
	private class SluchaczPoszerz implements ActionListener {
		// prywatne pole sk³adowe tej klasy
		private JComponent[] komponentySluchacza;

		// konstruktor z argumentem w postaci tablicy komponentów
		private SluchaczPoszerz(JComponent[] jc) {
			// przypisanie argumentu wywo³ania do pola sk³adowego
			komponentySluchacza = jc;
		}

		// implementacja metody actionPerformed z interfejsu ActionListener
		@Override
		public void actionPerformed(ActionEvent ae) {
			// ta sama operacja wykonywana dla ka¿dego z komponentów s³uchacza
			for (JComponent jc : komponentySluchacza) {
				// zmiana wielkoœci - poszerzenie o 10 pikseli
				jc.setSize(jc.getWidth() + 10, jc.getHeight());
			}
		}
	}

	// wewnêtrzna klasa s³uchacza implementuj¹ca interfejs ActionListener
	private class SluchaczZwez implements ActionListener {
		// prywatne pole sk³adowe tej klasy
		private JComponent[] komponentySluchacza;

		SluchaczZwez(JComponent[] jc) {
			// przypisanie argumentu wywo³ania do pola sk³adowego
			komponentySluchacza = jc;
		}

		// implementacja metody actionPerformed z interfejsu ActionListener
		@Override
		public void actionPerformed(ActionEvent ae) {
			// ta sama operacja wykonywana dla ka¿dego z komponentów s³uchacza
			for (JComponent jc : komponentySluchacza) {
				// zmiana wielkoœci - zwê¿enie o 10 pikseli
				jc.setSize(jc.getWidth() - 10, jc.getHeight());
			}
		}
	}

}
