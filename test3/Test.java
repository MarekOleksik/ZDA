package samplesGUI.test3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

//klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dziêki czemu obiekt klasy Test jest rodzajem okna
class Test extends JFrame {
	// w metodzie main jest tylko utworzenie naszego okna Test
	public static void main(String[] a) {
		// wywo³anie konstruktora klasy Test
		new Test();
	}

	// konstruktor bezargumentowy
	public Test() {
		// utworzenie przycisku i przypisanie go do zmiennej 'b' typu JButton
		JButton b = new JButton("Przycisk");
		// dodanie przycisku do contentPane'u
		getContentPane().add(b);

		// utworzenie obiektu anonimowej klasy implementuj¹cej ActionListener i
		// dodanie go do listy s³uchaczy Ÿród³a 'b'
		b.addActionListener(new ActionListener() {
			// jedyna metoda interfejsu ActionListener
			@Override
			public void actionPerformed(ActionEvent e) {
				// kod wykonywany podczas obs³ugi zdarzenia
				// ActionEvent(naciœniêcia przycisku)
				System.out.println("Klik!");
			}
		});
		
		// utworzenie obiektu anonimowej klasy implementuj¹cej ActionListener i
		// dodanie go do listy s³uchaczy Ÿród³a 'b' za pomoc¹ lambda wyra¿enia
		b.addActionListener(e -> System.out.println("Klik lambda!"));

		// pakowanie zawartoœci okna
		pack();
		// pokazanie ramki
		setVisible(true);

		// wywo³anie metody z klasy JFrame ustawiaj¹cej zachowanie programu po
		// zamkniêciu okna(patrz slajd "Zdarzenia okna - zamykanie")
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}