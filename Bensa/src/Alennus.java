import java.text.DecimalFormat;
import java.util.Scanner;


public class Alennus 
{
/*Tee ohjelma Alennus, joka laskee tuotteen alennetun hinnan. Ohjelma kysyy käyttäjältä tuotteen alentamattoman hinnan (desimaaliluku) 
 sekä alennusprosentin (kokonaisluku). Tämän jälkeen ohjelma kertoo tuotteen alennetun hinnan. Muotoile vastaus kahdella desimaalilla.

Alennettu hinta lasketaan: hinta * (100 - alennus) / 100.0
Esimerkkitulostus
 
Anna alentamaton hinta: 120,0
Anna alennusprosentti: 40
Alennettu hinta on 72,00*/
	public static void main(String[] args) 
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat des = new DecimalFormat("0.00");
		//muuttujien esittely
		
		double hinta, alennus, alennettuhinta;
		// pyytaminen
		System.out.print("Anna alentamaton hinta:  ");
		hinta=input.nextDouble();
		System.out.print("Anna alennusprosentti: ");
		alennus=input.nextDouble();
		// laskenta
		alennettuhinta = hinta * (100 - alennus) / 100.0;
		// tulostaminen
		System.out.print("Alennettu hinta on " + des.format(alennettuhinta));
		
		
				
		
		
		
		
	}
}