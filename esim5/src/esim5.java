import java.text.DecimalFormat;
import java.util.Scanner;


public class esim5 
{/*Tee ohjelma, joka laskee tuotteen arvonlisäverollisen hinnan ja alv:n määrän. Ohjelma kysyy tuotteen arvonlisäverottoman hinnan. Voit olettaa että alv on 23%. Muotoile vastaus kahdella desimaalilla.
Esimerkiksi jos tuotteen hinta on 20,00 euroa
Tuotteen alvillinen hinta on 24,60 euroa (alvitonhinta + alvitonhinta * 23/100.0) Alv:n osuus on 4,60 euroa*/

	public static void main(String[] args) 
	{
		//kavion esittely
		Scanner input = new Scanner(System.in);
		//muutujien esittely
		int alvitonhinta;
		double tuotehinta, alvosuus;
		//pyytaminen
		System.out.print("Anna tuotteen hinta: ");
		//input
		alvitonhinta=input.nextInt();
		//laskenta
		alvosuus = alvitonhinta*23/100.00;
		tuotehinta = alvitonhinta + alvosuus ;
		//tulostaaminen
		DecimalFormat fm = new DecimalFormat("0.00");
		System.out.print("Tuotteen alvillinen hinta on "+ fm.format(tuotehinta) +" ja Alv:n osuus on "+ fm.format(alvosuus));
		
		
		
		
		

	}

}
