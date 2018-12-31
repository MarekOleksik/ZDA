package samplesGUI.gra;

import java.util.Random;

public class Data {

	//pola prywatne
	private int games = 0;
	private int score = 0;
	private int nrCups = 3;
	private Cup [] cups;
	
	//konstruktory
	Data(){
		this(3);
	}
	Data(int nC){
		nrCups = nC;
		cups = new Cup[nrCups];
		for(int i=0;i<nrCups;i++){cups[i] = new Cup();}
		Random generator = new Random();
		cups[generator.nextInt(nrCups)].setCup(State.FILLED);
	}
	
	
	////////// akcesory
	public int getNrCups(){return nrCups;}
	public int getScore() {return score;}
	public int getGames() {return games;}
	
	///////////metody publiczne

	
	// sprawdza czy kubek o danym indeksie jest pełny
	public boolean chceckCup(int n) throws CupNrOutOfRange{
		if (n>=nrCups) throw new CupNrOutOfRange();
		return (cups[n].state == State.FILLED);
	}
	
	// miesza kubki
	public void shuffle(){
		for(Cup c: cups){
			c.setCup(State.EMPTY);
		}
		Random generator = new Random();
		cups[generator.nextInt(nrCups)].setCup(State.FILLED);
	}
	
	// liczy wynik
	public void score(int win){
		games++;
		score += win;
	}
	
	// zwraca aktualny stan kubków
	public boolean[] showResult(){
		boolean[] result = new boolean[nrCups];
		for(int i=0 ; i< nrCups; i++){
			result[i] = (cups[i].state == State.FILLED);
		}
		return result;
	}
	
	//klasy wewnętrzne
	public class Cup{
		private State state = State.EMPTY;
		public void setCup(State s){state = s;}
	}
	public static enum State {EMPTY, FILLED}

}
