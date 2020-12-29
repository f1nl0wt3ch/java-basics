import java.text.DecimalFormat;
import java.util.Scanner;


public class Kotitalousvahennys 
{
/*Tee ohjelma Kotitalousvahennys, joka laskee kŠyttŠjŠn saaman kotitalousvŠhennyksen mŠŠrŠn. 
 * Tyškorvausten euromŠŠriŠ kysytŠŠn niin kauan, kunnes kŠyttŠjŠ antaa korvauksen mŠŠrŠksi nolla. 
 * KotitalousvŠhennyksen mŠŠrŠ on 45 % tyškorvauksesta. KotitalousvŠhennyksen enimmŠismŠŠrŠ 
 * on 2 400 euroa. VŠhennyksen omavastuu on 100 euroa. KotitalousvŠhennys lasketaan tyškorvausten 
 * summa*45/100.0-omavastuu.
Esimerkkitulostus
 
Anna tyškorvauksen mŠŠrŠ (0 lopettaa): 200,0
Anna tyškorvauksen mŠŠrŠ (0 lopettaa): 190,0
Anna tyškorvauksen mŠŠrŠ (0 lopettaa): 110,0
Anna tyškorvauksen mŠŠrŠ (0 lopettaa): 0
KotitalousvŠhennyksen mŠŠrŠ on 125,00 euroa*/
	public static void main(String[] args) 
	{
		// Kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		// Muuttujien esittely
		double summa = 0;
		double tyškorvaus;
		double kotitalousvahennys;
		// pyytaaminen
		System.out.print("Anna tyškorvauksen mŠŠrŠ (0 lopettaa"+"): ");
		tyškorvaus=input.nextDouble();
		// Toistotrakenne
		while (tyškorvaus != 0){ summa = summa + tyškorvaus;
			System.out.print("Anna tyškorvauksen mŠŠrŠ (0 lopettaa"+"): ");
			tyškorvaus=input.nextDouble();
			
		}	
		
			kotitalousvahennys = (summa*45.0 )/100 - 100;
		if ( kotitalousvahennys >= 0 && kotitalousvahennys < 2400 ) { kotitalousvahennys = (summa*45.0 )/100 - 100;;
		System.out.print("KotitalousvŠhennyksen mŠŠrŠ on "+ fm.format(kotitalousvahennys)+" euroa");
		}
		else if ( kotitalousvahennys < 0  ) { kotitalousvahennys = 0;
		System.out.print("KotitalousvŠhennyksen mŠŠrŠ on "+ fm.format(kotitalousvahennys)+" euroa");
		}
		
		else {kotitalousvahennys = 2400;
		System.out.print("KotitalousvŠhennyksen mŠŠrŠ on "+ fm.format(kotitalousvahennys)+" euroa");
		}
	}

}