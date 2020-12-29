import java.text.DecimalFormat;
import java.util.Scanner;


public class kalvoesimerkkinä 
{
	/*Tee ohjelma (kalvoesimerkkinä), joka kysyy kokeiden pistemääriä niin kauan kuin annettu 
	 * pistemäärä on >= 0. Lopuksi ohjelma laskee pisteiden keskiarvon. 
	 * Näytä vastaus kahdella desimaalilla.
Esimerkki ohjelmasta
            Anna koepisteet: 30
            Anna koepisteet: 50
            Anna koepisteet: 45
            Anna koepisteet: -1
            Keskiarvo on 41,67*/

	public static void main(String[] args) 
	{
		// Kavion esittely
	 Scanner input = new Scanner(System.in);
	   // muuttujien esittely
	 double summa = 0;
	 double pisteet;
	 double lkm = 0;
	 double keskiarvo;
	 
	 System.out.print("Anna koepisteet: ");
	 pisteet=input.nextDouble();
	 
	while (pisteet >= 0 ) { lkm = lkm + 1;
		summa=summa+pisteet;
	 System.out.print("Anna koepisteet: ");
	 pisteet=input.nextDouble();
	 
	}
	keskiarvo = summa / lkm;
	DecimalFormat fm = new DecimalFormat("0.00");
	System.out.print("Keskiarvo on "+ fm.format(keskiarvo));

	}

}
