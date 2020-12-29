import java.util.Scanner;


public class Arvaus 
{
/*Tee ohjelma Arvaus, joka arpoo luvun (1-100) ja kysyy k�ytt�j�lt� arvottua lukua, kunnes k�ytt�j� arvaa oikein. Jos k�ytt�j� arvaa liian suuren luvun, ohjelma pyyt�� arvaamaan pienemp�� lukua. Jos k�ytt�j� arvaa liian pienen luvun, ohjelma pyyt�� arvaamaan suurempaa lukua. Kun k�ytt�j� arvaa luvun oikein, ohjelma onnittelee ja kertoo arvausten m��r�n. Laita arvattavaksi luvuksi 78, koska Viope tarkastaa teht�v�n kyseisell� arvolla.
Esimerkkitulostus
 
Arvaa lukua v�lilt� 1-100: 90
Arvaa pienemp��: 23
Arvaa suurempaa: 80
Arvaa pienemp��: 78
Arvasit oikein. Arvauksia oli 4*/
	public static void main(String[] args) {
		// Kavion esittely
		Scanner input = new Scanner(System.in);
		// muuttujien esittely
		double luku1 = (Math.random() * 9) + 1;
		double luku2;
		int kerta = 0;
		boolean oikein = false;
		// pyytaaminen
		
		System.out.print("Arvaa lukua v�lilt� 1-100: ");
		luku2=input.nextDouble();
		// toistorakenne
		do { kerta = kerta + 1;
			if (luku2 > luku1){System.out.print("Arvaa pienemp��: ");
			luku2=input.nextInt();}
			else if (luku2 < luku1) {System.out.print("Arvaa suurempaa: ");
			luku2=input.nextInt();}
			else {System.out.println("Arvasit oikein. Arvauksia oli "+ kerta);
			oikein= true;}
		 } while ( oikein == false );
		
		
	}

}
