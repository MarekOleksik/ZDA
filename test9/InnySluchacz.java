package samplesGUI.test9;


public class InnySluchacz implements GameListener {
	private Dane dane;
	
	public static char[] DANE = "abcdef".toCharArray();
	//public static final char[] DANE = new char[]{'a','b','c','d','e','f'};
	private static int next = 0;

	public InnySluchacz(Dane d) {
		dane = d;
	}

	public void pick(GameEvent e) {
		dane.dodaj(DANE[next++]);
		System.out.println("dodano :"+dane);
		if(next == DANE.length) next = 0;
	};

	public void shuffle(GameEvent e) {
		dane.wymieszaj();
		System.out.println("wymieszano :"+dane);
	};

	public Dane getDane() {
		return dane;
	}
}
