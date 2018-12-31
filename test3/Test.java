package samplesGUI.test3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

//klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dzi�ki czemu obiekt klasy Test jest rodzajem okna
class Test extends JFrame {
	// w metodzie main jest tylko utworzenie naszego okna Test
	public static void main(String[] a) {
		// wywo�anie konstruktora klasy Test
		new Test();
	}

	// konstruktor bezargumentowy
	public Test() {
		// utworzenie przycisku i przypisanie go do zmiennej 'b' typu JButton
		JButton b = new JButton("Przycisk");
		// dodanie przycisku do contentPane'u
		getContentPane().add(b);

		// utworzenie obiektu anonimowej klasy implementuj�cej ActionListener i
		// dodanie go do listy s�uchaczy �r�d�a 'b'
		b.addActionListener(new ActionListener() {
			// jedyna metoda interfejsu ActionListener
			@Override
			public void actionPerformed(ActionEvent e) {
				// kod wykonywany podczas obs�ugi zdarzenia
				// ActionEvent(naci�ni�cia przycisku)
				System.out.println("Klik!");
			}
		});
		
		// utworzenie obiektu anonimowej klasy implementuj�cej ActionListener i
		// dodanie go do listy s�uchaczy �r�d�a 'b' za pomoc� lambda wyra�enia
		b.addActionListener(e -> System.out.println("Klik lambda!"));

		// pakowanie zawarto�ci okna
		pack();
		// pokazanie ramki
		setVisible(true);

		// wywo�anie metody z klasy JFrame ustawiaj�cej zachowanie programu po
		// zamkni�ciu okna(patrz slajd "Zdarzenia okna - zamykanie")
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}