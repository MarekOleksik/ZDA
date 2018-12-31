package zda.git;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

class Test2Swing extends JFrame {
	public static void main(String[] a) {
		new Test2Swing();
	}

	Test2Swing() {
		setLayout(new FlowLayout());
		JButton b = new JButton("Przycisk 1");
		JLabel l = new JLabel("Etykieta");
		JTextField tf = new JTextField("Pole tekstowe");
		getContentPane().add(b);
		getContentPane().add(l);
		getContentPane().add(tf);
		JComponent listaElementow[] = new JComponent[10];
		listaElementow[0] = new JButton("Przycisk 1");
		listaElementow[1] = new JToggleButton("Przycisk dwustanowy");
		listaElementow[2] = new JCheckBox("CheckBox");
		listaElementow[3] = new JRadioButton("RadioButton");
		listaElementow[4] = new JLabel("Etykieta");
		listaElementow[5] = new JTextField("Pole tekstowe");
		listaElementow[6] = new JPasswordField("Has�o");
		listaElementow[7] = new JFormattedTextField("Tekst sformatowany");
		listaElementow[8] = new JTextArea("Ramka tekstowa");
		listaElementow[9] = new JPanel();
		Container c = getContentPane();
		for (JComponent el : listaElementow){
		c.add(el);
		}
		pack();
		setVisible(true);
	}
}
