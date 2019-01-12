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
	private JLabel lNrFaktury, nrFaktury, dataFakturyLabel, nazwaKlienta, nazwaSprzedawcy, klientImie, sprzedawcaImie,
			klientNazwisko, sprzedawcaNazwisko, klientNIP, sprzedawcaNIP, pozFakt, kwotaDoZaplaty = new JLabel("____"),
			listaNabywcy;
	private JTextField klientImieText, klientNazwiskoText, klientNIPText;
	private JFormattedTextField dataFaktury;
	private String[] kolumny;
	private Object[][] wiersze;
	private JTable tablePozFakt;
	private JTable tableFakt;
	private JButton wstawPozFakt;
	private JComboBox pozFaktCombo;
	private DefaultTableModel tableModel, tableModel1;;
	private double wartosc, cenaBrutto;
	String selected = ("NIE");

	private static final JLabel kodProduktu = new JLabel("Kod produktu", JLabel.CENTER),
			nazwaProduktu = new JLabel("Nazwa produktu", JLabel.LEFT), ilosc = new JLabel("Iloœæ", JLabel.CENTER),
			cenaNetto = new JLabel("Cena netto", JLabel.CENTER), vat = new JLabel("Vat", JLabel.CENTER),
			kwotaDoZaplatyTxt = new JLabel("Kwota do zap³aty:"), terminPlatnosciText = new JLabel("Termin p³atnoœci: ");

	public static final JTextField txt_kodProduktu = new JTextField("", 5), txt_nazwaProduktu = new JTextField("", 10),
			txt_ilosc = new JTextField("", 5), txt_cenaNetto = new JTextField("", 5),
			terminPlatnosciData = new JTextField("", 10);

	public static JButton wyczysc = new JButton("wyczyœæ"), zapisz = new JButton("zapisz fakturê"),
			wstaw = new JButton("wstaw"), usun = new JButton("usuñ"), anuluj = new JButton("anuluj"),
			usunFakt = new JButton("usuñ fakturê"), zamknij = new JButton("zamknij");

	public static JComboBox cbox = new JComboBox(),
			txt_vat = new JComboBox<String>(new String[] { "0", "3", "5", "7", "8", "22", "23" });
	public static JCheckBox fakturaZamknieta = new JCheckBox("Czy faktura zamkniêta?");
	int ileWierszy = 0;

	public FormularzFaktury() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Program do wystawiania faktur");
		frame.revalidate();
		frame.repaint();
		frame.setSize(1000, 750);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		// ileWierszy = OknoFaktury.tableModel1.getRowCount();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// panel 1
		JPanel panel1 = new JPanel();
		lNrFaktury = new JLabel("Numer Faktury");
		nrFaktury = new JLabel("");

		dataFakturyLabel = new JLabel("Data faktury: ");
		dataFaktury = new JFormattedTextField(currDay + ":" + (currMnth + 1) + ":" + currYear);
		panel1.add(Box.createRigidArea(new Dimension(340, 40)));
		panel1.add(lNrFaktury);
		panel1.add(nrFaktury);
		panel1.add(Box.createRigidArea(new Dimension(200, 40)));
		panel1.add(dataFakturyLabel);
		panel1.add(dataFaktury);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

		// panel 2
		JPanel panel2 = new JPanel();
		nazwaKlienta = new JLabel("Nabywca:");
		nazwaSprzedawcy = new JLabel("Wystawca:");
		panel2.add(Box.createRigidArea(new Dimension(50, 0)));
		panel2.add(nazwaKlienta);
		panel2.add(Box.createRigidArea(new Dimension(420, 0)));
		panel2.add(nazwaSprzedawcy);
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

		// panel 3
		JPanel panel3 = new JPanel();
		klientImie = new JLabel("Imiê: ");
		klientImieText = new JTextField("", 10);
		sprzedawcaImie = new JLabel("Imiê:  Marek");
		klientNazwisko = new JLabel("Nazwisko: ");
		klientNazwiskoText = new JTextField("", 10);
		sprzedawcaNazwisko = new JLabel("Nazwisko:  Oleksik");
		panel3.add(Box.createRigidArea(new Dimension(50, 0)));
		panel3.add(klientImie);
		panel3.add(klientImieText);
		panel3.add(klientNazwisko);
		panel3.add(klientNazwiskoText);
		panel3.add(Box.createRigidArea(new Dimension(150, 0)));
		panel3.add(sprzedawcaImie);
		panel3.add(sprzedawcaNazwisko);
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

		// panel 4
		JPanel panel4 = new JPanel();
		klientNIP = new JLabel("NIP: ");
		klientNIPText = new JTextField("", 10);
		sprzedawcaNIP = new JLabel("NIP: 768-101-00-00");
		panel4.add(Box.createRigidArea(new Dimension(50, 0)));
		panel4.add(klientNIP);
		panel4.add(klientNIPText);
		panel4.add(Box.createRigidArea(new Dimension(340, 0)));
		panel4.add(sprzedawcaNIP);
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

		// panel 5
		JPanel panel5 = new JPanel();
		cbox = new JComboBox();
		listaNabywcy = new JLabel("Wybierz Nabywcê z listy: ");
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

		panel5.add(listaNabywcy);
		panel5.add(cbox);
		panel5.add(Box.createRigidArea(new Dimension(0, 20)));
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

		// panel 6
		JPanel panel6 = new JPanel();
		pozFakt = new JLabel("Pozycje Fakturowe:");
		panel6.add(Box.createRigidArea(new Dimension(50, 0)));
		panel6.add(pozFakt);
		panel6.setLayout(new FlowLayout(FlowLayout.LEFT));

		// panel 7 z tabel¹
		// nag³ówek tabeli
		kolumny = new String[] { "Kod Produktu", "Nazwa Produktu", "Iloœæ", "Cena netto", "Vat", "Wartoœæ brutto" };
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
		JScrollPane panel7 = new JScrollPane(tablePozFakt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// panel8
		JPanel panel8 = new JPanel();
		panel8.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel8.add(kodProduktu);
		panel8.add(txt_kodProduktu);
		panel8.add(nazwaProduktu);
		panel8.add(txt_nazwaProduktu);
		panel8.add(ilosc);
		panel8.add(txt_ilosc);
		panel8.add(cenaNetto);
		panel8.add(txt_cenaNetto);
		panel8.add(vat);
		panel8.add(txt_vat);
		panel8.add(Box.createRigidArea(new Dimension(50, 0)));

		panel8.add(wstaw);

		wstaw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Produkty prod = new Produkty(txt_kodProduktu.getText(), txt_nazwaProduktu.getText(),
							Integer.parseInt(txt_ilosc.getText()), Double.parseDouble(txt_cenaNetto.getText()),
							Integer.parseInt(txt_vat.getSelectedItem().toString()));

					cenaBrutto = prod.getCenaNetto() * prod.getVat() / 100 + prod.getCenaNetto();
					wartosc = prod.getIlosc() * cenaBrutto;

					System.out.println(kwotaDoZaplaty);

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
							"Wartoœci liczbowe nie mog¹ byæ tekstem lub pola nie mog¹ byæ puste", "Z³y format pola",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d:  " + e2, "B³¹d", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel8.add(wyczysc);

		wyczysc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_kodProduktu.setText("");
				txt_nazwaProduktu.setText("");
				txt_ilosc.setText("");
				txt_cenaNetto.setText("");
				txt_vat.setSelectedItem("");
			}
		});

		panel8.add(usun);

		usun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int zaznaczonyWiersz = tablePozFakt.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) tablePozFakt.getModel();
					model.removeRow(tablePozFakt.getSelectedRow());

					double suma = wartosc;
					int ileWierszy = tableModel.getRowCount();
					for (int i = 1; i < ileWierszy; i++) {
						suma += wartosc;
					}
					kwotaDoZaplaty.setText(String.valueOf(suma));
				} catch (java.lang.ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(panel, "Proszê zaznaczyæ wiersz", "Wiersz nie zaznaczony",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		// panel9
		JPanel panel9 = new JPanel();
		panel9.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel9.add(Box.createRigidArea(new Dimension(50, 20)));
		panel9.add(fakturaZamknieta);
		fakturaZamknieta.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				selected = e.getStateChange() == ItemEvent.SELECTED ? "TAK" : "NIE";
				if (selected.equals("TAK")) {
					int ileWierszy1 = tableModel1.getRowCount();
					nrFaktury.setText(String.valueOf(ileWierszy1 + 1));

				}

				else
					nrFaktury.setText("");
			}
		});

		panel9.add(Box.createRigidArea(new Dimension(50, 20)));
		panel9.add(terminPlatnosciText);
		panel9.add(terminPlatnosciData);
		panel9.add(Box.createRigidArea(new Dimension(50, 20)));
		panel9.add(kwotaDoZaplatyTxt);
		panel9.add(kwotaDoZaplaty);
		panel9.add(Box.createRigidArea(new Dimension(50, 20)));

		// panel10
		JPanel panel10 = new JPanel();
		panel10.setLayout(new FlowLayout(FlowLayout.CENTER));

		panel10.add(Box.createRigidArea(new Dimension(30, 20)));
		panel10.add(zapisz);

		zapisz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (selected.equals("TAK")) {
						int ileWierszy1 = tableModel1.getRowCount();
						nrFaktury.setText(String.valueOf(ileWierszy1 + 1));

					}

					else
						nrFaktury.setText("");

					Faktura faktura = new Faktura(dataFaktury.getText(), nrFaktury.getText(),
							Double.parseDouble(kwotaDoZaplaty.getText()), klientImieText.getText(),
							klientNazwiskoText.getText(), klientNIPText.getText(), selected);

					tableModel1.addRow(new Object[] { faktura.getData(), faktura.getNumerFaktury(),
							faktura.getImie() + "  " + faktura.getNazwisko(), faktura.getNip(), faktura.getOgolem(),
							faktura.getZamknieta() });

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panel,
							"Wartoœci liczbowe nie mog¹ byæ tekstem lub pola nie mog¹ byæ puste", "Z³y format pola",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d:  " + e2, "B³¹d", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		panel10.add(Box.createRigidArea(new Dimension(30, 20)));
		panel10.add(usunFakt);

		usunFakt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int zaznaczonyWiersz = tableFakt.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) tableFakt.getModel();
				
					//if ( nrFaktury.getText() == (""))
					model.removeRow(tableFakt.getSelectedRow());
					//else 	JOptionPane.showConfirmDialog(null, "Nie mo¿na usun¹æ zamkniêtej faktury!", "Uwaga",  JOptionPane.OK_OPTION);
				} catch (java.lang.ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(panel, "Proszê zaznaczyæ wiersz", "Wiersz nie zaznaczony",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		panel10.add(Box.createRigidArea(new Dimension(30, 20)));
		panel10.add(zamknij);

		zamknij.addActionListener(new ActionListener() {
			int reply = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz zamkn¹æ?", "Zamknij",
						JOptionPane.YES_NO_OPTION);

				if (reply == JOptionPane.YES_OPTION) {
					frame.setVisible(false);
					System.exit(0);
				}
			}
		});

		// panel 11
		JPanel panel11 = new JPanel();
		panel11.add(Box.createRigidArea(new Dimension(50, 00)));
		JLabel listaFaktur = new JLabel("Lista faktur:");
		panel11.add(listaFaktur);
		panel11.setLayout(new FlowLayout(FlowLayout.LEFT));

		// panel 12

		String[] kolumny1 = new String[] { "Data", "Numer Faktury", "Nabywca", "NIP", "Wartoœæ ogó³em", "Zamkniêta" };
		// wiersze tabeli
		Object[][] wiersze1 = new Object[][] {};
		tableFakt = new JTable(wiersze1, kolumny1);
		tableModel1 = new DefaultTableModel(wiersze1, kolumny1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableFakt.setModel(tableModel1);

		JScrollPane panel12 = new JScrollPane(tableFakt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// dodawanie paneli
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		panel.add(panel7);
		panel.add(panel8);
		panel.add(panel9);

		panel.add(panel11);
		panel.add(panel12);
		panel.add(panel10);
		// panel.add(panel13);
		// panel.add(panel14);
		// panel.add(panel15);
		frame.add(panel);

		pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
