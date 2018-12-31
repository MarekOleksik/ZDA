package test1;

import java.awt.*;
import java.awt.event.*;

// klasa testowa dziedziczy po klasie Frame z biblioteki awt, dzi�ki czemu obiekt klasy TestAwt jest rodzajem okna
class TestAwt extends Frame {

	// w metodzie main jest tylko utworzenie naszego okna TestAwt
	public static void main(String[] a) {
		//wywo�anie konstruktora klasy TestAwt
		new TestAwt();
	}

	// konstruktor bezargumentowy
	public TestAwt() {
		// utworzenie obiektu klasy Button i przypisanie zapisanie referencji do niego do zmiennej b typu Button
		Button b = new Button("Przycisk");
		
		//wywo�anie metody add z klasy Container(Frame jest Container'em, patrz slajd "Struktura Swing") 
		//pozwalaj�cej na dodanie elementu do okna
		this.add(b);
		
		// utworzenie obiektu klasy S�uchacz i zapisanie otrzymanej referencji do zmiennej lokalnej s typu S�uchacz
		Sluchacz s = new Sluchacz();
		
		//wywo�anie metody addActionListener z klasy Button przez obiekt b. 
		//Metoda ta dodaje podanego w li�cie argument�w s�uchacza do listy s�uchaczy �r�d�a(w tym przypadku obiektu b))
		b.addActionListener(s);
		
		//wywo�anie metody pack() z klasy Frame.
		//'Spakowanie' zawarto�ci okna oznacza dostosowanie wielko�ci okna do ustalonych wielko�ci element�w
		pack();
		
		//wywo�anie metody setVisible(boolean b) z klasy Frame
		//ustawienie argumentu na true wy�wietla okno
		setVisible(true);
		
		
		// kod pozwalaj�cy na zamkni�cie aplikacji po zamkni�ciu okna (patrz slajd "Zdarzenia okna")
		// dodajemy nowego s�uchacza (obiekt anonimowej klasy dziedzicz�cej po klasie WindowAdapter (patrz slajdy "Adaptery"))
		addWindowListener(new WindowAdapter() {
			//nadpisanie wybranej metody z klasy WindowAdapter
			@Override
			public void windowClosing(WindowEvent e) {
				//kod kt�ry si� wykona podczas zamykania okna
				//zniszczenie okna
				dispose();
				//zako�czenie programu
				System.exit(0);
			}
			
		});
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