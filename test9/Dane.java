package samplesGUI.test9;

import java.util.ArrayList;
import java.util.Collections;

public class Dane {
	private char[] dane;

	public Dane(String s) {
		dane = s.toCharArray();

		// // lambda wyrazenia
		// dane = s.chars() //pobieramy znaki w postaci kodów
		// .mapToObj(c -> (char)c) // mapujemy int'y na char
		// .toArray(Character[]::new); // tworzymy tablicê Character
		// // na piechotê
		// dane = new Character[s.length()];
		// char[] chars = s.toCharArray();
		// for(int i=0;i<dane.length;i++)
		// dane[i] = new Character(chars[i]);
	}

	public char[] dodaj(char c) {
		char[] daneNowe = new char[dane.length + 1];
		System.arraycopy(dane, 0, daneNowe, 0, dane.length);
		daneNowe[dane.length] = c;
		dane = daneNowe;
		return dane;
	}

	public char[] wymieszaj() {
		ArrayList<Character> lista = new ArrayList<>();

		//tworzymy listê Character z tablicy char[]
		for (int i = 0; i < dane.length; i++)
			lista.add(new Character(dane[i]));

		//mieszanie za pomoc¹ metody z kolekcji
		Collections.shuffle(lista);

		//odtwarzamy tablicê char[] z listy Character 
		for (int i = 0; i < dane.length; i++)
			dane[i] = lista.get(i);
		return dane;
	}

	@Override
	public String toString(){
		String s = "";
		for(int i=0;i<dane.length;i++)
			s+= dane[i];
		return s;
	}

}
