package samplesGUI.test5;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

// klasa rozszerzaj�ca ramk� JFrame
public class SimpleElements extends JFrame {
	// w metodzie main jest tylko utworzenie naszego okna SimpleElements
	public static void main(String[] a) {
		// wywo�anie konstruktora klasy SimpleElements
		new SimpleElements();
	}

	// konstruktor bezargumentowy
	public SimpleElements() {
		// ustawienie layoutu na FlowLayout dzi�ki czemu elementy b�d�
		// umieszczane jeden za drugim
		setLayout(new FlowLayout());

		// utworzenie tablicy element�w typu JComponent
		JComponent listaElementow[] = new JComponent[11];

		// tworzenie poszczeg�lnych element�w GUI i wstawianie ich do wsp�lnej
		// tablicy
		// dzi�ki temu, �e wszystkie dziedzicz� po JComponent
		listaElementow[0] = new JButton("JButton");
		listaElementow[1] = new JCheckBox("JCheckBox");
		listaElementow[2] = new JRadioButton("JRadioButton");
		listaElementow[3] = new JComboBox<String>(new String[] { "JComboBox", "element 1", "element 2" });
		listaElementow[4] = new JList<String>(new String[] { "JList", "element 1", "element 2" });
		listaElementow[5] = new JSlider(2, 10);
		listaElementow[6] = new JSpinner();
		listaElementow[7] = new JTextField("JTextField");
		listaElementow[8] = new JPasswordField("JPasswordField");
		listaElementow[9] = new JLabel("JLabel");
		listaElementow[10] = new JMenu("JMenu");

		// pobranie contentPane'a i zapisanie referencji do niego pod zmienn�
		// 'c'
		Container c = getContentPane();
		// iterowanie po elementach tablicy: 'el' jest aktualnym elementem
		for (JComponent el : listaElementow) {
			// tworzenie nowego JPanel'u
			JPanel p = new JPanel();
			// ustawianie minimalnej wielko�ci dla panelu
			p.setMinimumSize(new Dimension(30, 40));
			// ustawianie koloru t�a panelu
			p.setBackground(Color.getHSBColor((float)Math.random(), (float)Math.random(), (float)Math.random()));
			// dodawanie elementu do panelu
			p.add(el);
			// dodawanie panelu do contentPane'a
			c.add(p);
		}
		
		// spakowanie zawarto�ci okna - dopasowanie wielko�ci okna i przycisk�w
		pack();

		// pokazanie ramki
		setVisible(true);

		// wywo�anie metody z klasy JFrame ustawiaj�cej zachowanie programu po
		// zamkni�ciu okna(patrz slajd "Zdarzenia okna - zamykanie")
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
