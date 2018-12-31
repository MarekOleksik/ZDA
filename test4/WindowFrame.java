package test4;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JWindow;

//klasa posiadaj�ca jedynie metod� main()
//pokazuj�c� r�nic� pomi�dzy JFrame a JWindow
public class WindowFrame {
	
	public static void main(String[] args) {
		//utworzenie ramki
		JFrame f = new JFrame("The Frame");
		//ustawienie wielko�ci i po�o�enia
		f.setSize(300, 300);
		f.setLocation(100, 100);

		//utworzenie okna
		JWindow w = new JWindow();
		//ustawienie wielko�ci i po�o�enia
		w.setSize(300, 300);
		w.setLocation(500, 100);
		
		//utworzenie okna dialogowego dla ramki 'f'
		JDialog d = new JDialog(f,"The dialog");
		//ustawienie wielko�ci i po�o�enia
		d.setSize(100, 100);
		d.setLocation(200, 100);

		//pokazanie okna i ramki
		f.setVisible(true);
		w.setVisible(true);
		d.setVisible(true);
	}
}