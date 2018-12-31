package cwiczenia;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;


public class Pojazdy {

		private String marka;
		private int spalanie;
		private Date dataProdukcji;
		
		public Pojazdy(String m, int s, int year, int month, int day) {
		
			marka = m;
			spalanie = s;
			GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
			dataProdukcji = calendar.getTime();
						
		}
		  public String getMarka()
		   {
		      return marka;
		   }

		   public int getSpalanie()
		   {
		      return spalanie;
		   }

		   public Date getDataProdukcji()
		   {
		      return dataProdukcji;
		   }
}

class Samochod extends Pojazdy {
	String paliwo;
	private int ileOsob;
	private int maxPredkosc;
	
	public Samochod (String m, int s, String p, int i, int max, int year, int month, int day) {
		super(m, s, year, month, day);
		paliwo = p;
		ileOsob = i;
		maxPredkosc = max;
			
	}
	
	public String getPaliwo()
	{
		return paliwo;
	}
	
	public int getIleOsob()
	{
		return ileOsob;
	}
	
	public int getMaxPredkosc()
	{
		return maxPredkosc;
	}
	
}

class Motocykl extends Pojazdy {
	private int maxPredkosc;
	boolean czyJestKosz;
	
	public Motocykl (String m, int s, int max, boolean kosz, int year, int month, int day) {
		super(m, s, year, month, day);
		maxPredkosc = max;
		czyJestKosz = kosz;
			
	}
	
	public int getMaxPredkosc1()
	{
		return maxPredkosc;
	}
	
	public boolean getKosz()
	{
		return czyJestKosz;
	}
	
	

public static void main(String[] args) {
		
	Pojazdy[] auto = new Pojazdy[3];
	auto[0] = new Samochod ("Volvo", 8, "benzyna", 5, 220, 2016, 10, 1);
	auto[1] = new Samochod ("Renault", 7, "diesel", 7, 180, 2017, 3 ,5);
	auto[2] = new Samochod ("Mazda", 10, "benzyna + gaz", 6, 190, 2018, 5, 17);
	
	for (Pojazdy s : auto) 
	  System.out.println("Marka samochodu: " + s.getMarka() + ", \n Spalanie: " + s.getSpalanie() + "l" + ", \n Data produkcji: " + s.getDataProdukcji() + "\n");
	
	
	Motocykl java = new Motocykl("Java", 5, 220, false, 2018, 7, 12);
	Motocykl kawasaki = new Motocykl("Kawasaki", 7, 250, false, 2018, 9, 13);
	System.out.println("kawasaki.equals(java):" + kawasaki.equals(java));
	System.out.println("kawasaki.hashCode(): " + kawasaki.hashCode());
	System.out.println("java.hashCode(): " + java.hashCode());
	}
}



