
public class Faktura extends Klient {
	private static String numerFaktury;
	private static String data;
	private static Double ogolem;
	private static String zamknieta;

	public Faktura(String data, String numerFaktury, Double ogolem, String imie, String nazwisko, String nip,
			String zamknieta) {
		super(imie, nazwisko, nip);
		this.numerFaktury = numerFaktury;
		this.data = data;
		this.ogolem = ogolem;
		this.zamknieta = zamknieta;

	}

	public Faktura() {
	}

	public String getNumerFaktury() {
		return numerFaktury;
	}

	public void setNumerFaktury() {
		this.numerFaktury = ("");
	}

	public String getData() {
		return data;
	}

	public void setData() {
		this.data = ("");
	}

	public Double getOgolem() {
		return ogolem;
	}

	public void setOgolem() {
		this.ogolem = (double) 0;
	}

	public String getZamknieta() {
		return zamknieta;
	}

}
