
public class Klient {

	private static String nazwisko;
	private static String imie;
	private static String nip;

	public Klient() {
	};

	public Klient(String imie, String nazwisko, String nip) {
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.nip = nip;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public String getImie() {
		return imie;
	}
	public String getNip(){
		return nip;
	}
}
