
public class Produkty {
	private static String kodProduktu;
	private static String nazwaProduktu;
	private static int ilosc;
	private static Double cenaNetto;
	private static int vat;

	public Produkty() {
	};

	public Produkty(String kodProduktu, String nazwaProduktu, int ilosc, Double cenaNetto, int vat) {
		this.kodProduktu = kodProduktu;
		this.nazwaProduktu = nazwaProduktu;
		this.ilosc = ilosc;
		this.cenaNetto = cenaNetto;
		this.vat = vat;
	}

	public String getNazwaProduktu() {
		return nazwaProduktu;
	}

	public String getKodProduktu() {
		return kodProduktu;
	}
	
	public int getIlosc() {
		return ilosc;
	}
	
	public Double getCenaNetto() {
		return cenaNetto;
	}
	
	public int getVat() {
		return vat;
	}
}
