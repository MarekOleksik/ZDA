package samplesGUI.test6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;



public class Okno extends JFrame{
	private Stado stado;
	private JList<Owca> lista; 

	public Okno(int w, int h, String title,Stado s) {
		stado = s;
		setSize(w, h);
		setTitle(title);
		
		JComponent po = przygotujPanelOwcy();
		po.setPreferredSize(new Dimension(w/2, h));
		po.setBackground(Color.YELLOW);
		JComponent ps = przygotujPanelStada(w/2,h);
		//ps.setPreferredSize(new Dimension(w/2, h));
		ps.setBackground(Color.RED);
		
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(po);
		getContentPane().add(ps);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JComponent przygotujPanelStada(int w, int h) {
		JPanel panel = new JPanel();
		
		lista = new JList<Owca>(); // lista bêdzie zawiera³a referencje do obiektów typu Owca
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lista.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lista.setVisibleRowCount(-1);
		
		JScrollPane listScroller = new JScrollPane(lista); // obudowujemy listê w panel z suwakami
		listScroller.setPreferredSize(new Dimension(w, h));
		
		panel.add(listScroller);

		// s³uchacz wyœwietlaj¹cy okno dialogowe po klikniêciu w okienko listy
		lista.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseClicked(MouseEvent e) {
				// po klikniêciu pobieramy zaznaczon¹ wartoœæ na liœcie
				Owca selected = lista.getSelectedValue();
				
				if(selected == null) return;// je¿eli nie ma zaznaczenia to nie ma co robic
				
				// wyœwietlamy okno i zapisujemy decyzjê podjêt¹ przez u¿ytkownika
				int dec = JOptionPane.showConfirmDialog(panel, "Owca "+ selected.getNazwa() + " wa¿y "+selected.getWaga() +"kg" , "Dane owcy - usun¹æ?",JOptionPane.YES_NO_OPTION);
				if(dec == JOptionPane.OK_OPTION){
					stado.usun(selected);
					lista.setListData(stado.getOwce());
				}
			}
		});

		return panel;
	}

	private JComponent przygotujPanelOwcy() {
		JPanel panel = new JPanel();
		// klasa lokalna
		class SluchaczTekstu implements FocusListener {
			private String txt; 				// pole sk³adowe
			SluchaczTekstu(String t){txt=t;} 	// konstruktor inicjuje pole sk³adowe
			@Override
			public void focusLost(FocusEvent e) {
				JTextField tf = (JTextField)e.getSource(); //pobranie Ÿród³a, czyli tu okienka tekstowego
				if(tf.getText().equals(""))
					tf.setText(txt);
			}
			@Override
			public void focusGained(FocusEvent e) {
				JTextField tf = (JTextField)e.getSource();//pobranie Ÿród³a
				if(tf.getText().equals(txt))
					tf.setText("");
			}
		}
		
		// przygotowanie komponentów
		JTextField tfNazwa = new JTextField("-Nazwa-");
		tfNazwa.addFocusListener(new SluchaczTekstu("-Nazwa-"));
		
		JTextField tfWaga = new JTextField("-Waga-");
		tfWaga.addFocusListener(new SluchaczTekstu("-Waga-"));
		
		JButton dodaj = new JButton("Dodaj owce");
		// s³uchacz przycisku, który doda owcê od razu sprawdzaj¹c poprawnoœæ wprowadzonych danych
		dodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfNazwa.getText().equals("-Nazwa-") || tfWaga.getText().equals("-Waga-"))
					JOptionPane.showMessageDialog(panel, "Podaj dane owcy", "Brak danych", JOptionPane.ERROR_MESSAGE);
				else{
					int waga = 0;
					try{
						waga = Integer.parseInt(tfWaga.getText());
						//je¿eli podano pprawn¹ wagê to przechodzimy dalej
						Owca o = new Owca(tfNazwa.getText(), waga);
						stado.dodajOwce(o);
						lista.setListData(stado.getOwce());
						
					}catch(NumberFormatException ex){ // obs³uga b³êdu parsowania za pomoc¹ okna dialogowego
						JOptionPane.showMessageDialog(panel,"Waga musi byæ liczb¹","Z³y format wagi",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		panel.setLayout(new GridLayout(3,1));
		panel.add(tfNazwa);
		panel.add(tfWaga);
		panel.add(dodaj);
		return panel;
	}

}
