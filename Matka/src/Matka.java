import java.text.DecimalFormat;
import java.util.Scanner;


public class Matka 
{
/*Tee ohjelma Matka, joka kysyy k�ytt�j�lt� matkan pituuden (kokonaisluku) sek� keskinopeuden (kokonaisluku), jolla matka ajetaan. 
 * T�m�n j�lkeen ohjelma tulostaa matkaan kuluvan ajan tunteina. Muotoile vastaus kahdella desimaalilla
Esimerkkitulostus
 
Anna matka: 700
Anna nopeus: 80
Aikaa menee 8,75 tuntia*/
	public static void main(String[] args) 
	{
		//import
		Scanner input = new Scanner(System.in);
		DecimalFormat des = new DecimalFormat("0.00");
		// muuttujat
		int matka;
		double aika, nopeus;
		//
		System.out.print("Anna matka: ");
		matka=input.nextInt();
	    System.out.print("Anna nopeus: ");
	    nopeus=input.nextDouble();
		//laskenta
	    aika = matka/nopeus;
	    //output
	    System.out.print("Aikaa menee " + des.format(aika)+ " tuntia");
		
		
		

	}

}