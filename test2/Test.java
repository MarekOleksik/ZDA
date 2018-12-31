package samplesGUI.test2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

// klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dziêki czemu obiekt klasy Test jest rodzajem okna
class Test extends JFrame {

	// w metodzie main jest tylko utworzenie naszego okna Test
	public static void main(String[] a) {
		// wywo³anie konstruktora klasy Test
		new Test();
	}

	// konstruktor bezargumentowy
	public Test() {
		// ustawienie layoutu na FlowLayout dziêki czemu elementy bêd¹
		// umieszczane jeden za drugim
		setLayout(new FlowLayout());

		// utworzenie dwóch przycisków i zapisanie ich referencji pod zmiennymi
		// b1 i b2 typu JButton
		JButton b1 = new JButton("Przycisk 1");
		JButton b2 = new JButton("Przycisk 2");

		// utworzenie obiektu s³uchacza klasy wewnêtrznej S³uchacz
		Sluchacz s = new Sluchacz();
		// dodanie obiektu s³uchacza(s) do Ÿróde³ b1 i b2
		b1.addActionListener(s);
		b2.addActionListener(s);

		// dodanie przycisków b1 i b2 do contentPane
		getContentPane().add(b1);
		getContentPane().add(b2);

		// spakowanie zawartoœci okna - dopasowanie wielkoœci okna i przycisków
		pack();

		// pokazanie ramki
		setVisible(true);

		// wywo³anie metody z klasy JFrame ustawiaj¹cej zachowanie programu po
		// zamkniêciu okna(patrz slajd "Zdarzenia okna - zamykanie")
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	// klasa wewnêtzna S³uchacz implementuj¹ca interfejs ActionListener
	private class Sluchacz implements ActionListener {
		// actionPerformed to jedyna metoda z interfejsu ActionListener
		// w argumencie wywo³ania e typu ActionEvent posiadamy informacje o
		// zdarzeniu
		@Override
		public void actionPerformed(ActionEvent e) {
			// pobranie informacji o Ÿródle zdarzenia (getSource()) z obiektu
			// zdarzenia ActionEvent 'e' i
			// zrzutowanie zwê¿aj¹co do typu JButton
			// zapisanie powsta³ej referencji do zmiennej 'o' typu JButton
			JButton o = (JButton) e.getSource();
			// wyœwietlenie na konsoli listy argumentów wywo³ania
			System.out.println(e.paramString());
			// wyœwietlenie na konsoli tekstu z przycisku
			// (e.getActionCommand()), typu referencji 'o'(o.getClass)
			// oraz informacji o obiekcie 'o'
			System.out.println(e.getActionCommand() + "\n" + o.getClass() + "\n" + o.toString());
		}
	}

}