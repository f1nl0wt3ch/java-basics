import java.text.DecimalFormat;
import java.util.Scanner;

public class Bensa 
{
	/*
	 Tee ohjelma Bensa, joka laskee, paljonko maksaa kilometrin ajaminen. KŠyttŠjŠltŠ pyydetŠŠn tankattu mŠŠrŠ litroina (desimaaliluku), 
	 ajetut kilometrit (kokonaisluku) sekŠ bensan litrahinta (desimaaliluku). Ohjelma laskee ja nŠyttŠŠ kilometrihinnan. 
	 Muotoile vastaus kahdella desimaalilla.

Ajetun kilometrin hinta lasketaan: tankkaus / ajetut * litrahinta
Esimerkkitulostus
 
Anna tankattu mŠŠrŠ: 54,0
Anna ajetut kilometrit: 790
Anna litrahinta: 1,690
Ajo per kilometri maksaa 0,12
*/
	

	public static void main(String[] args) 
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat des = new DecimalFormat("0.00");
		// muuttujien esittely
		double tankkaus, ajetut, litrahinta, ajo;
	    // pyytaminen
		System.out.print("Anna tankattu mŠŠrŠ: ");
		tankkaus=input.nextDouble();
		System.out.print("Anna ajetut kilometrit: ");
		ajetut=input.nextDouble();
		System.out.print("Anna litrahinta: ");
		litrahinta=input.nextDouble();
		// laskenta
		ajo = tankkaus / ajetut*litrahinta;
		// tulostaminen
		System.out.print("Ajo per kilometri maksaa "+des.format(ajo));
		
	
		
		
		
	}

}
