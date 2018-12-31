package cwiczenia;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

// klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dzi�ki czemu obiekt klasy TestSwing jest rodzajem okna
class TestSwing extends JFrame {

	// w metodzie main jest tylko utworzenie naszego okna TestSwing
	public static void main(String[] a) {
		// wywo�anie konstruktora klasy TestSwing
		new TestSwing();

	}

	// utworzenie obiektu klasy JButton i przypisanie zapisanie referencji
	// do niego do zmiennej b typu JButton
	private JButton b = new JButton("Przycisk1");
	private JButton b1 = new JButton("Przycisk2");
	private JButton b2 = new JButton("Przycisk3");

	// konstruktor bezargumentowy
	public TestSwing() {

		setLayout(new FlowLayout());

		// wywo�anie metody add z klasy Container(contentPane jest Container'em
		// patrz slajd "Struktura Swing")
		// pozwalaj�cej na dodanie elementu do okna przez obiekt
		// contentPane(patz slajd "Kolejno�c warstw")
		getContentPane().add(b);
		getContentPane().add(b1);
		getContentPane().add(b2);

		// utworzenie obiektu klasy S�uchacz i zapisanie otrzymanej referencji
		// do zmiennej lokalnej s typu S�uchacz
		Sluchacz s = new Sluchacz();

		// wywo�anie metody addActionListener z klasy Button przez obiekt b.
		// Metoda ta dodaje podanego w li�cie argument�w s�uchacza (s) do listy
		// s�uchaczy �r�d�a(w tym przypadku obiektu b))
		b.addActionListener(s);
		b1.addActionListener(s);
		b2.addActionListener(s);

		// wywo�anie metody pack() z klasy Frame.
		// 'Spakowanie' zawarto�ci okna oznacza dostosowanie wielko�ci okna do
		// ustalonych wielko�ci element�w
		pack();

		// wywo�anie metody setVisible(boolean b) z klasy Frame
		// ustawienie argumentu na true wy�wietla okno
		setVisible(true);

		// wywo�anie metody z klasy JFrame ustawiaj�cej zachowanie programu po
		// zamkni�ciu okna(patrz slajd "Zdarzenia okna - zamykanie")
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	// utworzenie klasy wewn�trznej S�uchacz implementuj�cej interfejs
	// ActionListener

	public class Sluchacz implements ActionListener {
		// actionPerformed to jedyna metoda z interfejsu ActionListener
		// w argumencie wywo�ania e typu ActionEvent posiadamy informacje o
		// zdarzeniu

		public int count = 0;
		public int count1 = 0;
		public int count2 = 0;

		public void actionPerformed(ActionEvent e) {
			// kod wewn�trz metody actionPerformed zostanie wykonany gdy nast�pi
			// zdarzenie naci�ni�cia przycisku(ActionEvent)
			if (e.getActionCommand() == ("Przycisk1")) {
				count = count + 1;
				System.out.println("Klik Przycisk 1 numer: " + count);
				b.setEnabled(false);
				b1.setEnabled(true);
				b2.setEnabled(true);
			}
			if (e.getActionCommand() == ("Przycisk2")) {
				count1 = count1 + 1;
				System.out.println("Klik Przycisk 2 numer: " + count1);
				b.setEnabled(true);
				b1.setEnabled(false);
				b2.setEnabled(true);
			}
			if (e.getActionCommand() == ("Przycisk3")) {
				count2 = count2 + 1;
				System.out.println("Klik Przycisk 3 numer: " + count2);
				b.setEnabled(true);
				b1.setEnabled(true);
				b2.setEnabled(false);
			}
			System.out.println("Kliknięć razem: " + (count + count1 + count2));
		}

	}
}
