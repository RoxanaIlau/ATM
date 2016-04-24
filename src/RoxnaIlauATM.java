import java.util.Scanner;

public class RoxnaIlauATM {
	static Scanner sc = new Scanner(System.in);
	static int optiune;
	static double[] sold = new double[] { 65_000., 123_000., 32. };
	static String[] pins = new String[] { "1234", "4321", "1212" };
	static String[] users = new String[] { "Ilau Ion", "Ilau Maria", "Ilau Roxana" };

	public static int intoarceUser(String user) {
		for (int i = 0; i < users.length; i++) {
			if (users[i].equalsIgnoreCase(user)) {
				return i;
			}
		}
		return -1;
	}

	public static boolean autentificare(int pozitie) {
		// autentificare useru-lui in functie PIN-ul corespunzator
		System.out.println(" Introduceti PIN ");
		for (int i = 3; i > 0; i--) {
			System.out.println(" Mai aveti " + i + " incercari ");
			String pin = sc.nextLine();
			if (pin.equals(pins[pozitie])) {
				System.out.println(" PIN corect ");
				return true;
			} else {
				System.out.println(" PIN incorect ");
			}
		}
		System.out.println(" Card blocat ");
		return false;
	}

	public static void main(String[] args) {
		meniuPrincipal();
	}

	public static void alegeOptiune(int pozitie) {
		do {
			System.out.println(
					" Alegeti optiunea dorita folosind tastele cu numerele \n corespunzatoare fiecarei operatiuni bancare pe care doriti sa o initializati: ");
			System.out.println(
					" 1. Interogare sold \n 2. Depunere numerar \n 3. Extragere numerar \n 4. Schimbare PIN \n 5. Meniu principal \n 6. Exit ");
			optiune = sc.nextInt();
			// crearea meniului in functie de fiecare operatie pe care dorim sa
			// o efectuam
			switch (optiune) {
			case 1:
				System.out.println(" Interogare sold");
				interogareSold(pozitie);
				break;
			case 2:
				System.out.println(" Depunere numerar ");
				depunereNumerar(pozitie);
				break;
			case 3:
				System.out.println(" Extragere numerar ");
				extragereNumerar(pozitie);
				break;
			case 4:
				System.out.println(" Schimbare PIN ");
				schimbaPin(pozitie);
				break;
			case 5:
				System.out.println(" Inapoi la meniul principal ");
				meniuPrincipal();
			case 6:
				System.out.println(" La revedere! \n Va multumim ca ati utilizat serviciile noastre. ");
				return;
			default:
				System.out.println(" Eroare ");
			}
		} while (true);
	}

	private static void meniuPrincipal() {
		int i = 0;
		System.out.println("+------------------------------------+");
		System.out.println("|           Bine ati venit!          |");
		System.out.println("|                :)                  |");
		System.out.println("+------------------------- ----------+");
		String nume;
		int pozitie;
		// afla numele utilizatorului
		do {
			System.out.println(" Autentificare user: ");
			nume = sc.nextLine();
			pozitie = intoarceUser(nume);
			if (pozitie == -1) {
				System.out.println(" Incearca din nou ");
			}
		} while (pozitie == -1);
		if (!autentificare(pozitie))
			return;
		alegeOptiune(pozitie);
	}

	private static boolean schimbaPin(int pozitie) {

		System.out.println(" Introduceti vechiul PIN");
		String pinVechi = sc.nextLine();
		if (pinVechi.equals(pins[pozitie])) {

		}
		sc.nextLine();
		System.out.println(" Introduceti un nou PIN alcatuit din 4 cifre ");
		String pinNou1 = sc.nextLine(); // declaram o variabila pentru noul PIN pe care dorim sa il folosim
		System.out.println(" Repetati PIN-ul ");
		String pinNou2 = sc.nextLine(); // se declara o alta variabila pt a putea compara cele doua PIN-uri
		if (pinNou1.equals(pinNou2)) {
			pins[pozitie] = pinNou1;
			System.out.println(" Pinul a fost schimbat ");
		}
		return true;
	}

	public static void depunereNumerar(int pozitie) { // definirea metodei
		System.out.println("Introduceti suma ");
		double sumaDepusa = sc.nextDouble();
		sold[pozitie] = sold[pozitie] + sumaDepusa;
	}

	public static void extragereNumerar(int pozitie) {
		System.out.println(" Introduceti suma pe care doriti sa o extrageti ");
		double sumaExtrasa = sc.nextDouble();
		if (sold[pozitie] < sumaExtrasa) {
			System.out.println("Fonduri insuficiente");
		} else
			sold[pozitie] = sold[pozitie] - sumaExtrasa;
	}

	public static void interogareSold(int pozitie) {
		System.out.println(sold[pozitie]);
	}
}
