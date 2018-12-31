import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class TestSwing extends JFrame {
	public static void main(String[] a) {
		new TestSwing();
	}

	private JButton b1,b2,b3;
	
	public TestSwing() {
		setLayout (new FlowLayout());
		JButton b1 = new JButton("Przycisk1");
		JButton b2 = new JButton("Przycisk2");
		JButton b3 = new JButton("Przycisk3");
		getContentPane().add(b1);
		getContentPane().add(b2);
		getContentPane().add(b3);
		b1.addActionListener(e ->{
			b1.setEnabled(false);
			b2.setEnabled(true);
			b3.setEnabled(true);
			});
			b2.addActionListener(e -> {
			b1.setEnabled(true);
			b2.setEnabled(false);
			b3.setEnabled(true);
			});
			b3.addActionListener(e-> {
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(false);
			});
		pack();
		setVisible(true);
	}

}