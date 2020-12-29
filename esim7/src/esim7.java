import java.text.DecimalFormat;
import java.util.Scanner;


public class esim7 
{
/*Tee ohjelma, jolla kimppakyytiläiset voivat laskea bensakustannukset. Ohjelma kysyy ajetut kilometrit, auton kulutuksen per 100 km, 
 * bensan litrahinnan sekä kimppakyytiläisten lukumäärän. Ohjelma laskee edellä kerrotuista tiedoista, kuinka paljon jokainen maksaa bensoista.
 *  Muotoile vastaus kahdella desimaalilla.
Esimerkiksi ajetut kilometri on 500.0, bensan kulutus on 7.0 litraa/100km, bensa maksaa 1.690 euroa/litra ja kimppakyytiläisiä on kolme,
 jokainen maksaa 19.72 (7.0/100.0 * 1.690 * 500.0/3).*/
	public static void main(String[] args) 
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		// muuttujien esittely
		int ajetut;
		double bensahinta = 1.690, kimppakyyti = 3, kulutus, bensakustannus;
		// syötääminen
		System.out.print("Ajetut kilometri on ");
		ajetut=input.nextInt();
		System.out.print("bensan kulutus on " );
		kulutus=input.nextDouble();
	
		// laskenta
		bensakustannus = (kulutus/100*ajetut*bensahinta) / kimppakyyti;
		// tulostaaminen
		System.out.print("jokainen maksaa " + fm.format(bensakustannus));
				
		
		
		

	}

}
