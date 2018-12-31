package cwiczenia;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerWizytowek extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ManagerWizytowek();

	}

	private JList<Wizytowka> lista;
	private JTextField t1 = new JTextField("          ");
	private JLabel l1 = new JLabel("Nazwisko");
	private JTextField t2 = new JTextField("          ");
	private JLabel l2 = new JLabel("Wzrost");
	private JButton b1 = new JButton("Zapisz");
	private JButton b2 = new JButton("Odczytaj");

	public ManagerWizytowek() {
		setSize(700, 400);
		setLocation(500, 300);
		setLayout(new GridLayout(3,1));
		JPanel p1 = new JPanel(new GridLayout(2,1));
		JPanel p2 = new JPanel(new GridLayout(2,1));

		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p2.add(b1);
		p2.add(b2);
		getContentPane().add(p1);
		getContentPane().add(p2);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a = t1.getText();
				String a1 = t2.getText();

			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}