package samplesGUI.test6;

import java.util.ArrayList;

public class Stado {
	private ArrayList<Owca> stado = new ArrayList<>();
	
	public Owca[] getOwce(){
		return stado.toArray(new Owca[stado.size()]);
	}
	
	public void dodajOwce(Owca o){
		stado.add(o);
	}

	public void usun(Owca selected) {
		stado.remove(selected);
	}

}
