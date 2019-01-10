import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormularzFaktury extends JFrame {

	GregorianCalendar cal = new GregorianCalendar();
	int currYear = cal.get(GregorianCalendar.YEAR);
	int currDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
	int currMnth = cal.get(GregorianCalendar.MONTH);
	private JLabel lNrFaktury, NrFaktury, dataFakturyLabel, nazwaKlienta, nazwaSprzedawcy, klientImie, sprzedawcaImie,
			klientNazwisko, sprzedawcaNazwisko, klientNIP, sprzedawcaNIP, pozFakt, listaNabywcy;
	private JTextField klientImieText, klientNazwiskoText, klientNIPText;
	private JFormattedTextField dataFaktury;
	private String[] kolumny;
	private Object[][] wiersze;
	private JTable tablePozFakt;
	private JButton wstawPozFakt;
	private JComboBox pozFaktCombo;
	private DefaultTableModel tableModel;
	private double wartosc, cenaBrutto;
	String selected;

	private static final JLabel kodProduktu = new JLabel("Kod produktu", JLabel.CENTER),
			nazwaProduktu = new JLabel("Nazwa produktu", JLabel.LEFT), ilosc = new JLabel("Ilo��", JLabel.CENTER),
			cenaNetto = new JLabel("Cena netto", JLabel.CENTER), vat = new JLabel("Vat", JLabel.CENTER),
			kwotaDoZaplatyTxt = new JLabel("Kwota do zap�aty:"), kwotaDoZaplaty = new JLabel("____");

	public static final JTextField txt_kodProduktu = new JTextField("", 5), txt_nazwaProduktu = new JTextField("", 10),
			txt_ilosc = new JTextField("", 5), txt_cenaNetto = new JTextField("", 5), txt_vat = new JTextField("", 5);

	public static JButton wyczysc = new JButton("wyczy��"), zapisz = new JButton("zapisz faktur�"),
			wstaw = new JButton("wstaw"), usun = new JButton("usu�"), anuluj = new JButton("anuluj");

	public static JComboBox cbox = new JComboBox();
	public static JCheckBox fakturaZamknieta = new JCheckBox("Czy faktura zamkni�ta?");
	int ileWierszy = OknoFaktury.tableModel.getRowCount();

	public FormularzFaktury() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Formularz faktury");
		frame.setSize(700, 750);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// panel z numerem i dat� faktury faktury
		JPanel panel1 = new JPanel();
		lNrFaktury = new JLabel("Numer Faktury");
		NrFaktury = new JLabel("________");

		dataFakturyLabel = new JLabel("Data faktury: ");
		dataFaktury = new JFormattedTextField(currDay + ":" + (currMnth + 1) + ":" + currYear);
		panel1.add(Box.createRigidArea(new Dimension(140, 80)));
		panel1.add(lNrFaktury);
		panel1.add(NrFaktury);
		panel1.add(Box.createRigidArea(new Dimension(200, 80)));
		panel1.add(dataFakturyLabel);
		panel1.add(dataFaktury);
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

		// panel z polami tesktowymi klienta i sprzedawcy
		JPanel panel2 = new JPanel();
		nazwaKlienta = new JLabel("Nabywca:");
		nazwaSprzedawcy = new JLabel("Wystawca:");
		panel2.add(Box.createRigidArea(new Dimension(50, 0)));
		panel2.add(nazwaKlienta);
		panel2.add(Box.createRigidArea(new Dimension(240, 0)));
		panel2.add(nazwaSprzedawcy);
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel3 = new JPanel();
		klientImie = new JLabel("Imi�: ");
		klientImieText = new JTextField("", 10);
		sprzedawcaImie = new JLabel("Imi�:  Marek");
		panel3.add(Box.createRigidArea(new Dimension(50, 0)));
		panel3.add(klientImie);
		panel3.add(klientImieText);
		panel3.add(Box.createRigidArea(new Dimension(150, 0)));
		panel3.add(sprzedawcaImie);
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel4 = new JPanel();
		klientNazwisko = new JLabel("Nazwisko: ");
		klientNazwiskoText = new JTextField("", 10);
		sprzedawcaNazwisko = new JLabel("Nazwisko:  Oleksik");
		panel4.add(Box.createRigidArea(new Dimension(50, 0)));
		panel4.add(klientNazwisko);
		panel4.add(klientNazwiskoText);
		panel4.add(Box.createRigidArea(new Dimension(120, 0)));
		panel4.add(sprzedawcaNazwisko);
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel5 = new JPanel();
		klientNIP = new JLabel("NIP: ");
		klientNIPText = new JTextField("", 10);
		sprzedawcaNIP = new JLabel("NIP: 768-101-00-00");
		panel5.add(Box.createRigidArea(new Dimension(50, 0)));
		panel5.add(klientNIP);
		panel5.add(klientNIPText);
		panel5.add(Box.createRigidArea(new Dimension(155, 0)));
		panel5.add(sprzedawcaNIP);
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel6 = new JPanel();
		cbox = new JComboBox();
		listaNabywcy = new JLabel("Wybierz Nabywc� z listy: ");
		cbox.addItem("");
		cbox.addItem("Jan Kowalski 234-234-23-23");
		cbox.addItem("Jerzy Nowak 123-123-12-11");
		cbox.addItem("Sylwester Stalone 987-098-11-11");
		cbox.addItem("Jackie Chan 111-222-33-33");

		cbox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String wybranyelement = (String) cbox.getSelectedItem();

				String splited = new String(wybranyelement);
				String[] splitedArray = null;
				splitedArray = splited.split(" ");
				klientImieText.setText(splitedArray[0]);
				klientNazwiskoText.setText(splitedArray[1]);
				klientNIPText.setText(splitedArray[2]);

			}
		});

		panel6.add(listaNabywcy);
		panel6.add(cbox);
		panel6.add(Box.createRigidArea(new Dimension(0, 50)));
		panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel7 = new JPanel();
		pozFakt = new JLabel("Pozycje Fakturowe:");
		panel7.add(Box.createRigidArea(new Dimension(50, 0)));
		panel7.add(pozFakt);
		panel7.setLayout(new FlowLayout(FlowLayout.LEFT));

		// panel z tabel�
		// nag��wek tabeli
		kolumny = new String[] { "Kod Produktu", "Nazwa Produktu", "Ilo��", "Cena netto", "Vat", "Warto�� brutto" };
		// wiersze tabeli
		wiersze = new Object[][] {};
		tablePozFakt = new JTable(wiersze, kolumny);
		tableModel = new DefaultTableModel(wiersze, kolumny) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablePozFakt.setModel(tableModel);
		JScrollPane panel8 = new JScrollPane(tablePozFakt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JPanel panel9 = new JPanel();
		panel9.add(kodProduktu);
		panel9.add(txt_kodProduktu);
		panel9.add(nazwaProduktu);
		panel9.add(txt_nazwaProduktu);
		panel9.add(ilosc);
		panel9.add(txt_ilosc);
		panel9.add(cenaNetto);
		panel9.add(txt_cenaNetto);
		panel9.add(vat);
		panel9.add(txt_vat);
		panel9.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel panel10 = new JPanel();
		panel10.add(wyczysc);

		wyczysc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_kodProduktu.setText("");
				txt_nazwaProduktu.setText("");
				txt_ilosc.setText("");
				txt_cenaNetto.setText("");
				txt_vat.setText("");
			}
		});

		panel10.add(wstaw);

		wstaw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Produkty prod = new Produkty(txt_kodProduktu.getText(), txt_nazwaProduktu.getText(),
							Integer.parseInt(txt_ilosc.getText()), Double.parseDouble(txt_cenaNetto.getText()),
							Integer.parseInt(txt_vat.getText()));

					cenaBrutto = prod.getCenaNetto() * prod.getVat() / 100 + prod.getCenaNetto();
					wartosc = prod.getIlosc() * cenaBrutto;
					tableModel.addRow(new Object[] { prod.getKodProduktu(), prod.getNazwaProduktu(), prod.getIlosc(),
							prod.getCenaNetto(), prod.getVat(), String.valueOf(wartosc) });

					double suma = wartosc;
					int ileWierszy = tableModel.getRowCount();
					for (int i = 1; i < ileWierszy; i++) {
						suma += wartosc;
					}

					kwotaDoZaplaty.setText(String.valueOf(suma));

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panel,
							"Warto�ci liczbowe nie mog� by� tekstem lub pola nie mog� by� puste", "Z�y format pola",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Wyst�pi� b��d:  " + e2, "B��d", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		panel10.add(usun);

		usun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int zaznaczonyWiersz = tablePozFakt.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) tablePozFakt.getModel();
					model.removeRow(tablePozFakt.getSelectedRow());
				} catch (java.lang.ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(panel, "Prosz� zaznaczy� wiersz", "Wiersz nie zaznaczony",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JPanel panel11 = new JPanel();
		panel11.setLayout(new FlowLayout(FlowLayout.RIGHT));

		panel11.add(kwotaDoZaplatyTxt);

		panel11.add(kwotaDoZaplaty);

		panel11.add(Box.createRigidArea(new Dimension(50, 100)));

		JPanel panel12 = new JPanel();
		panel12.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel12.add(Box.createRigidArea(new Dimension(200, 100)));
		panel12.add(fakturaZamknieta);
		panel12.add(Box.createRigidArea(new Dimension(30, 100)));
		panel12.add(zapisz);
		panel12.add(Box.createRigidArea(new Dimension(10, 100)));

		boolean fakturaTemp = fakturaZamknieta.isSelected();
		
		fakturaZamknieta.addItemListener(new ItemListener() {

	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                selected = e.getStateChange() == ItemEvent.SELECTED
	                    ? "TAK" : "NIE";
	        		if (selected.equals("TAK"))
	                NrFaktury.setText(String.valueOf(ileWierszy+1));
	        		else
	        		NrFaktury.setText(" ");
	   	            }
	        });
		
		  
		String temp;
		if (fakturaTemp) {
		temp = new String("TAK");
		}
			
		else
		temp = new String("NIE");
		System.out.println("Faktura otwarta");

		zapisz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// try {

				Faktura faktura = new Faktura(dataFaktury.getText(), NrFaktury.getText(),
						Double.parseDouble(kwotaDoZaplaty.getText()), klientImieText.getText(),
						klientNazwiskoText.getText(), klientNIPText.getText(), temp);

				OknoFaktury.tableModel.addRow(new Object[] { faktura.getData(), faktura.getNumerFaktury(),
						faktura.getImie() + "  " + faktura.getNazwisko(), faktura.getNip(), faktura.getOgolem(), faktura.getZamknieta()});

				
				
				//frame.setVisible(false);

			           frame.dispose();

				
				frame.setVisible(false);
				/*
				 * } catch (NumberFormatException ex) {
				 * JOptionPane.showMessageDialog(panel,
				 * "Warto�ci liczbowe nie mog� by� tekstem lub pola nie mog� by� puste"
				 * , "Z�y format pola", JOptionPane.ERROR_MESSAGE); } catch
				 * (Exception e2) { JOptionPane.showMessageDialog(null,
				 * "Wyst�pi� b��d:  " + e2, "B��d", JOptionPane.ERROR_MESSAGE);
				 * }
				 */

			}
		});

		panel12.add(anuluj);
		panel12.add(Box.createRigidArea(new Dimension(30, 100)));

		anuluj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

			}
		});

		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		panel.add(panel7);
		panel.add(panel8);
		panel.add(panel9);
		panel.add(panel10);
		panel.add(panel11);
		panel.add(panel12);
		frame.add(panel);

		pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
