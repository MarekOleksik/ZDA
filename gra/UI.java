package samplesGUI.gra;

import java.util.Scanner;

// proceduralny interfejs uzytkownika

public class UI {

	private Mechanics m;
	private Data d;
	private boolean [] result;
	
	UI(Mechanics mech){
		m = mech;
		d = mech.getData();
		result = new boolean[m.nrCups];
		start();
	}
	// pętla działania
	private void start(){
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("Runda:"+m.getRound()+" Masz "+m.getScore()+" pkt. Wybierz nr kubka (lub 'n' nowa gra)");
			printCups();
			if(in.hasNextInt()){
				int nr = in.nextInt();
				try {
					result = m.checkCup(nr-1);
					printCupsResult();
				} catch (CupNrOutOfRange e) {
					System.out.println("Zbyt duża liczba: podaj liczbę z zakresu  1:" + (m.nrCups));
				}
			}
			else{
				if (in.next().equals("n")){
					System.out.println("Podaj liczbę kubków");
					int nr = in.nextInt();
					m.newGame(nr);
					System.out.println("NOWA GRA");
				}
				else{ 
					System.out.println("KONIEC");
					break;
				}
			}
		}
	}
	
	// metody pomocnicze
	private void printCups(){
		String c = "";
		for(int i=0;i<m.nrCups;i++){
			c += "/\\";
		}
		System.out.println(c);
	}
	private void printCupsResult(){
		String c = "";
		for(int i=0;i<m.nrCups;i++){
			c += result[i]? "/.\\": "/\\";
		}
		System.out.println(c);
	}	
	
}
