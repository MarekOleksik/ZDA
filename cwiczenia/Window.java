package cwiczenia;

import java.awt.FlowLayout;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cwiczenia.TestSwing.Sluchacz;

public class Window extends JFrame {

	public static void main(String[] a) {

		new Window();
	}

	private JTextField t = new JTextField("          ");
	private JButton b = new JButton("Przycisk");
	private JLabel l = new JLabel("Etykieta");
	private JList<String> list  = new JList<String>( new String[] {"fdfs", "fdfds", "fdfd"});

	public Window() {
		setSize(700, 400);
		setLocation(500, 300);

		setLayout(new FlowLayout());

		getContentPane().add(t);

		getContentPane().add(b);

		getContentPane().add(l);

		getContentPane().add(list);
		
		setVisible(true);
		
		

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l.setText("Etykieta");
				b.setText("Przycisk");
				t.setText("            ");

			}
		});
		t.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a = t.getText();
				l.setText(a);
				b.setText(a);
			}
		});

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
