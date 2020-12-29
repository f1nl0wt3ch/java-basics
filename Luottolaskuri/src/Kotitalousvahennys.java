import java.text.DecimalFormat;
import java.util.Scanner;


public class Kotitalousvahennys 
{
/*Tee ohjelma Kotitalousvahennys, joka laskee k�ytt�j�n saaman kotitalousv�hennyksen m��r�n. 
 * Ty�korvausten eurom��ri� kysyt��n niin kauan, kunnes k�ytt�j� antaa korvauksen m��r�ksi nolla. 
 * Kotitalousv�hennyksen m��r� on 45 % ty�korvauksesta. Kotitalousv�hennyksen enimm�ism��r� 
 * on 2 400 euroa. V�hennyksen omavastuu on 100 euroa. Kotitalousv�hennys lasketaan ty�korvausten 
 * summa*45/100.0-omavastuu.
Esimerkkitulostus
 
Anna ty�korvauksen m��r� (0 lopettaa): 200,0
Anna ty�korvauksen m��r� (0 lopettaa): 190,0
Anna ty�korvauksen m��r� (0 lopettaa): 110,0
Anna ty�korvauksen m��r� (0 lopettaa): 0
Kotitalousv�hennyksen m��r� on 125,00 euroa*/
	public static void main(String[] args) 
	{
		// Kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		// Muuttujien esittely
		double summa = 0;
		double ty�korvaus;
		double kotitalousvahennys;
		// pyytaaminen
		System.out.print("Anna ty�korvauksen m��r� (0 lopettaa"+"): ");
		ty�korvaus=input.nextDouble();
		// Toistotrakenne
		while (ty�korvaus != 0){ summa = summa + ty�korvaus;
			System.out.print("Anna ty�korvauksen m��r� (0 lopettaa"+"): ");
			ty�korvaus=input.nextDouble();
			
		}	
		
			kotitalousvahennys = (summa*45.0 )/100 - 100;
		if ( kotitalousvahennys >= 0 && kotitalousvahennys < 2400 ) { kotitalousvahennys = (summa*45.0 )/100 - 100;;
		System.out.print("Kotitalousv�hennyksen m��r� on "+ fm.format(kotitalousvahennys)+" euroa");
		}
		else if ( kotitalousvahennys < 0  ) { kotitalousvahennys = 0;
		System.out.print("Kotitalousv�hennyksen m��r� on "+ fm.format(kotitalousvahennys)+" euroa");
		}
		
		else {kotitalousvahennys = 2400;
		System.out.print("Kotitalousv�hennyksen m��r� on "+ fm.format(kotitalousvahennys)+" euroa");
		}
	}

}