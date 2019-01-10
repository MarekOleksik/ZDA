import java.util.Scanner;

public class Suma {

	public static void main(String[] args) {
		long millisActualTime = System.currentTimeMillis(); // pocz¹tkowy czas w milisekundach.
		// wykonanie programu

		long suma = 0l;
		System.out.println("Podaj liczbê n: ");
		Scanner odczyt = new Scanner(System.in);
		long n = odczyt.nextInt();
		for (long i = 0; i <= n; i++) {
			suma += i;
		}
		System.out.println("Suma liczb od 1 do " + n + " wynosi: " + suma);
		
		long executionTime = System.currentTimeMillis() - millisActualTime; // czas wykonania programu w milisekundach.
		System.out.println("Czas wykonania: " + executionTime );

	}

}
