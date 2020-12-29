import java.util.Scanner;


public class KirjaKustantajaOhjelma {

	public static void main(String[] args) 
	{
		Kirja kirja = new Kirja();
		Scanner input = new Scanner(System.in);
		System.out.print("Kirjan nimi: ");
		String nimi = input.nextLine();
		System.out.print("Kirjan isbn: ");
		String isbn = input.nextLine();
		System.out.print("Kirjan hinta: ");
		double hinta = input.nextDouble();
		Scanner input1 = new Scanner(System.in);
		System.out.print("Kustantajan nimi: ");
		String knimi = input1.nextLine();
		System.out.print("Kustantajan osoite: ");
		String osoite = input1.nextLine();
		System.out.print("Kustantajan puhelin: ");
        String puhelin = input1.nextLine();
	    
        kirja.setNimi(nimi);
        kirja.getNimi();
	    Kustantaja kustantaja = new Kustantaja(knimi, osoite, puhelin);
	    kirja.setKustantiedot(kustantaja);
	    System.out.print(kirja.toString());
	
	}

}
