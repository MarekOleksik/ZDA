package samplesGUI.test2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

// klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dzi�ki czemu obiekt klasy Test jest rodzajem okna
class Test extends JFrame {

	// w metodzie main jest tylko utworzenie naszego okna Test
	public static void main(String[] a) {
		// wywo�anie konstruktora klasy Test
		new Test();
	}

	// konstruktor bezargumentowy
	public Test() {
		// ustawienie layoutu na FlowLayout dzi�ki czemu elementy b�d�
		// umieszczane jeden za drugim
		setLayout(new FlowLayout());

		// utworzenie dw�ch przycisk�w i zapisanie ich referencji pod zmiennymi
		// b1 i b2 typu JButton
		JButton b1 = new JButton("Przycisk 1");
		JButton b2 = new JButton("Przycisk 2");

		// utworzenie obiektu s�uchacza klasy wewn�trznej S�uchacz
		Sluchacz s = new Sluchacz();
		// dodanie obiektu s�uchacza(s) do �r�de� b1 i b2
		b1.addActionListener(s);
		b2.addActionListener(s);

		// dodanie przycisk�w b1 i b2 do contentPane
		getContentPane().add(b1);
		getContentPane().add(b2);

		// spakowanie zawarto�ci okna - dopasowanie wielko�ci okna i przycisk�w
		pack();

		// pokazanie ramki
		setVisible(true);

		// wywo�anie metody z klasy JFrame ustawiaj�cej zachowanie programu po
		// zamkni�ciu okna(patrz slajd "Zdarzenia okna - zamykanie")
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	// klasa wewn�tzna S�uchacz implementuj�ca interfejs ActionListener
	private class Sluchacz implements ActionListener {
		// actionPerformed to jedyna metoda z interfejsu ActionListener
		// w argumencie wywo�ania e typu ActionEvent posiadamy informacje o
		// zdarzeniu
		@Override
		public void actionPerformed(ActionEvent e) {
			// pobranie informacji o �r�dle zdarzenia (getSource()) z obiektu
			// zdarzenia ActionEvent 'e' i
			// zrzutowanie zw�aj�co do typu JButton
			// zapisanie powsta�ej referencji do zmiennej 'o' typu JButton
			JButton o = (JButton) e.getSource();
			// wy�wietlenie na konsoli listy argument�w wywo�ania
			System.out.println(e.paramString());
			// wy�wietlenie na konsoli tekstu z przycisku
			// (e.getActionCommand()), typu referencji 'o'(o.getClass)
			// oraz informacji o obiekcie 'o'
			System.out.println(e.getActionCommand() + "\n" + o.getClass() + "\n" + o.toString());
		}
	}

}