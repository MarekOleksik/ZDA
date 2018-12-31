package samplesGUI.test8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//klasa testowa dziedziczy po klasie JFrame z biblioteki swing, dziêki czemu obiekt klasy Test jest rodzajem okna
class Test extends JFrame {

	// w metodzie main jest tylko utworzenie naszego okna Test
	public static void main(String[] a) {
		// wywo³anie konstruktora klasy Test
		new Test();
	}

	// konstruktor bezargumentowy
	public Test() {
		// ustawienie braku layoutu oznacza, ¿e nale¿y samodzielnie ustawiæ wielkoœæ okna i po³o¿enie i wielkoœæ elementów
		setLayout(null);

		// utworzenie trzech przycisków
		JButton jb1 = new JButton("Poszerz");
		JButton jb3 = new JButton("inny");
		JButton jb2 = new JButton("Zwê¿");
		
		// ustawienie po³o¿enia przycisku w kontenerze i ich wielkoœci
		jb1.setBounds(10, 10, 100, 30);
		jb2.setBounds(10, 50, 100, 30);
		jb3.setBounds(10, 90, 100, 30);

		// czterech ró¿nych s³uchaczy, ka¿dy operuje na innych danych
		ActionListener slPoszerz1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Dzia³anie s³uchacza slPoszerz1");
				// poszerzanie przycisku 'jb3'
				jb3.setSize(jb3.getWidth() + 10, jb3.getHeight());
			}
		};

		ActionListener slPoszerz2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Dzia³anie s³uchacza slPoszerz2");
				// pobieranie Ÿród³a zdarzenia
				JButton src = (JButton) e.getSource();
				// poszerzanie Ÿród³a tego zdarzenia
				src.setSize(src.getWidth(), src.getHeight()+5);
			}
		};

		ActionListener slZwez1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Dzia³anie s³uchacza slZwez1");
				// zwê¿anie przycisku 'jb1'
				jb1.setSize(jb1.getWidth() - 10, jb1.getHeight());
			}
		};

		ActionListener slZwez2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Dzia³anie s³uchacza slZwez2");
				// zwê¿anie przycisku 'jb2'
				jb2.setSize(jb2.getWidth() - 20, jb2.getHeight());
				// zwê¿anie przycisku 'jb3'
				jb3.setSize(jb3.getWidth(), jb3.getHeight() - 5);
			}
		};

		// dodanie dwóch s³uchaczy do Ÿród³a bêd¹cego pierwszym przyciskiem
		jb1.addActionListener(slPoszerz1);
		jb1.addActionListener(slPoszerz2);

		// dodanie dwóch s³uchaczy do Ÿród³a bêd¹cego drugim przyciskiem
		jb2.addActionListener(slZwez1);
		jb2.addActionListener(slZwez2);

		// dodanie trzech przycisków do contentPane'a
		getContentPane().add(jb1);
		getContentPane().add(jb2);
		getContentPane().add(jb3);

		// ustawienie wielkoœci okna
		setSize(200, 300);
		// ustawienie zamykania aplikacji po zamkniêciu okna
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// pokazanie okna
		setVisible(true);

	}

}
