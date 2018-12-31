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

// klasa rozszerzaj¹ca ramkê JFrame
public class SimpleElements extends JFrame {
	// w metodzie main jest tylko utworzenie naszego okna SimpleElements
	public static void main(String[] a) {
		// wywo³anie konstruktora klasy SimpleElements
		new SimpleElements();
	}

	// konstruktor bezargumentowy
	public SimpleElements() {
		// ustawienie layoutu na FlowLayout dziêki czemu elementy bêd¹
		// umieszczane jeden za drugim
		setLayout(new FlowLayout());

		// utworzenie tablicy elementów typu JComponent
		JComponent listaElementow[] = new JComponent[11];

		// tworzenie poszczególnych elementów GUI i wstawianie ich do wspólnej
		// tablicy
		// dziêki temu, ¿e wszystkie dziedzicz¹ po JComponent
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

		// pobranie contentPane'a i zapisanie referencji do niego pod zmienn¹
		// 'c'
		Container c = getContentPane();
		// iterowanie po elementach tablicy: 'el' jest aktualnym elementem
		for (JComponent el : listaElementow) {
			// tworzenie nowego JPanel'u
			JPanel p = new JPanel();
			// ustawianie minimalnej wielkoœci dla panelu
			p.setMinimumSize(new Dimension(30, 40));
			// ustawianie koloru t³a panelu
			p.setBackground(Color.getHSBColor((float)Math.random(), (float)Math.random(), (float)Math.random()));
			// dodawanie elementu do panelu
			p.add(el);
			// dodawanie panelu do contentPane'a
			c.add(p);
		}
		
		// spakowanie zawartoœci okna - dopasowanie wielkoœci okna i przycisków
		pack();

		// pokazanie ramki
		setVisible(true);

		// wywo³anie metody z klasy JFrame ustawiaj¹cej zachowanie programu po
		// zamkniêciu okna(patrz slajd "Zdarzenia okna - zamykanie")
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
