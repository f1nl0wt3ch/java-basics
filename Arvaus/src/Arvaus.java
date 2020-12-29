import java.util.Scanner;


public class Arvaus 
{
/*Tee ohjelma Arvaus, joka arpoo luvun (1-100) ja kysyy kŠyttŠjŠltŠ arvottua lukua, kunnes kŠyttŠjŠ arvaa oikein. Jos kŠyttŠjŠ arvaa liian suuren luvun, ohjelma pyytŠŠ arvaamaan pienempŠŠ lukua. Jos kŠyttŠjŠ arvaa liian pienen luvun, ohjelma pyytŠŠ arvaamaan suurempaa lukua. Kun kŠyttŠjŠ arvaa luvun oikein, ohjelma onnittelee ja kertoo arvausten mŠŠrŠn. Laita arvattavaksi luvuksi 78, koska Viope tarkastaa tehtŠvŠn kyseisellŠ arvolla.
Esimerkkitulostus
 
Arvaa lukua vŠliltŠ 1-100: 90
Arvaa pienempŠŠ: 23
Arvaa suurempaa: 80
Arvaa pienempŠŠ: 78
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
		
		System.out.print("Arvaa lukua vŠliltŠ 1-100: ");
		luku2=input.nextDouble();
		// toistorakenne
		do { kerta = kerta + 1;
			if (luku2 > luku1){System.out.print("Arvaa pienempŠŠ: ");
			luku2=input.nextInt();}
			else if (luku2 < luku1) {System.out.print("Arvaa suurempaa: ");
			luku2=input.nextInt();}
			else {System.out.println("Arvasit oikein. Arvauksia oli "+ kerta);
			oikein= true;}
		 } while ( oikein == false );
		
		
	}

}
