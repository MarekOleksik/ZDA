package samplesGUI.test6;

public class Owca {
	private int waga;
	private String nazwa;
	
	public Owca(String nazwa, int waga){
		this.waga = waga;
		this.nazwa = nazwa;
	}
	
	public int getWaga(){ return waga; }
	public String getNazwa(){ return nazwa; }
	
	@Override
	public String toString(){
		return nazwa;
	}
}
