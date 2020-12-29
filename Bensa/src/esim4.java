import java.text.DecimalFormat;
import java.util.Scanner;


public class esim4 

{  /*Tee ohjelma, joka kysyy ajetut kilometrit, laskee ja näyttää korvauksen määrän. Kilometrikorvaus on 0.45 euroa/kilometri. 
Muotoile vastaus kahdella desimaalilla. Esimerkiksi jos ajetut kilometrit on 270, korvauksen määrä on 121,50 euroa (270*0.45).*/

	public static void main(String[] args) 
	
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		// muuttujien esittely
		final double hinta = 0.45;
		double ajettumatkat, määrä;
		// pyytaminen 
		System.out.print("Anna ajetut kilometrit on: ");
		ajettumatkat=input.nextDouble();
		//laskenta
		määrä = hinta*ajettumatkat;
		//tulostaaminen
	    System.out.print("korvauksen määrä on: " + fm.format(määrä));
		
		

	}

}
