package cwiczenia;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

// klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dzi�ki czemu obiekt klasy TestSwing jest rodzajem okna
class LiczPrzycisk extends JFrame {

	// w metodzie main jest tylko utworzenie naszego okna TestSwing
	public static void main(String[] a) {
		// wywo�anie konstruktora klasy TestSwing
		new TestSwing();
	}

	// konstruktor bezargumentowy
	public LiczPrzycisk() {
		// utworzenie obiektu klasy JButton i przypisanie zapisanie referencji
		// do niego do zmiennej b typu JButton
		JButton b = new JButton("Przycisk");

		// wywo�anie metody add z klasy Container(contentPane jest Container'em
		// patrz slajd "Struktura Swing")
		// pozwalaj�cej na dodanie elementu do okna przez obiekt
		// contentPane(patz slajd "Kolejno�c warstw")
		getContentPane().add(b);

		// utworzenie obiektu klasy S�uchacz i zapisanie otrzymanej referencji
		// do zmiennej lokalnej s typu S�uchacz
		Sluchacz s = new Sluchacz();
		
		// wywo�anie metody addActionListener z klasy Button przez obiekt b.
		// Metoda ta dodaje podanego w li�cie argument�w s�uchacza (s) do listy s�uchaczy �r�d�a(w tym przypadku obiektu b))
		b.addActionListener(s);
		
		//wywo�anie metody pack() z klasy Frame.
		//'Spakowanie' zawarto�ci okna oznacza dostosowanie wielko�ci okna do ustalonych wielko�ci element�w
		pack();
		
		//wywo�anie metody setVisible(boolean b) z klasy Frame
		//ustawienie argumentu na true wy�wietla okno		
		setVisible(true);
		
		//wywo�anie metody z klasy JFrame ustawiaj�cej zachowanie programu po zamkni�ciu okna(patrz slajd "Zdarzenia okna - zamykanie")
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	// utworzenie klasy wewn�trznej S�uchacz implementuj�cej interfejs ActionListener
	public class Sluchacz implements ActionListener {
		//actionPerformed to jedyna metoda z interfejsu ActionListener
		//w argumencie wywo�ania e typu ActionEvent posiadamy informacje o zdarzeniu
		@Override
		public void actionPerformed(ActionEvent e) {
			//kod wewn�trz metody actionPerformed zostanie wykonany gdy nast�pi zdarzenie naci�ni�cia przycisku(ActionEvent)
			System.out.println("Klik");
		}
	}

}