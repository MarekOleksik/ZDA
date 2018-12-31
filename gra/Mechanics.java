package samplesGUI.gra;

public class Mechanics {
	
	private Data data;
	private int games = 0;
	public static int nrCups;

	Mechanics(Data d){
		data = d;
		nrCups = data.getNrCups();
	}
	
	public Data getData(){return data;}
	public int getGames(){return games;}
	public int getScore(){return data.getScore();}
	public int getRound(){return data.getGames();}
	
	public boolean[] checkCup(int n) throws CupNrOutOfRange{
		boolean win = data.chceckCup(n);
		data.score(win? 1:0);
		boolean [] result =  data.showResult();
		data.shuffle();
		return result;
	}

	public void newGame(int n){
		data = new Data(n);
		nrCups = n;
		games ++;
	}
	
}
