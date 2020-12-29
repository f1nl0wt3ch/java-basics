import java.text.DecimalFormat;
import java.util.Scanner;


public class Palkka1 
{/*Tee ohjelma Palkka, joka kysy k�ytt�j�lt� bruttopalkan, veroprosentin ja i�n. Ohjelma laskee k�teen j��v�n osuuden palkasta sek� verojen, 
ty�tt�myysvakuutuksen (0.50%) ja ty�el�ke-vakuutusmaksun siten, ett� se on alle 53-vuotiaalla 5.55 % ja 53 vuotta t�ytt�neell� 7.05%.
Esimerkkitulostus
 
Anna palkka: 2000
Anna veroprosentti: 20,0
Anna ik�: 53
Bruttopalkka 2000
Veron osuus (20,00%) 400,00
Ty�el�kevakuutusmaksun osuus (7,05%) 141,00
Ty�tt�myysvakuutuksen osuus (0,50%) 10,00
K�teen siis j�� 1449,00*/

	public static void main(String[] args) 
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		DecimalFormat fm1 = new DecimalFormat("0");
		// muuttujien esittely
		
		final double elake1 = 5.55/100.00;
		final double elake2 = 7.05/100.00;
		double palkka, bruttopalkan, veroprosentti, ika, kateen, veroosuus, tyoton,elakeprosentti, elake;
		// pyytaminen
		System.out.print("Anna palkka: ");
		palkka=input.nextDouble();
		System.out.print("Anna veroprosentti: ");
		veroprosentti=input.nextDouble();
		System.out.print("Anna ik�: ");
		ika=input.nextDouble();
		// laskenta
		bruttopalkan = palkka;
		tyoton = bruttopalkan*0.50/100.00;
		if (ika < 53) { 
			elakeprosentti = elake1; 
        }
		else { elakeprosentti = elake2; }
		elake = bruttopalkan*elakeprosentti;
		veroosuus = bruttopalkan*veroprosentti/100.00;
		kateen = bruttopalkan - veroosuus - tyoton - elake;
		// tulostaminen
		System.out.print("Bruttopalkka " + fm1.format(bruttopalkan)+ "\nVeron osuus "+"("+ fm.format(veroprosentti)+"%) "+ fm.format(veroosuus)
		+ "\nTy�el�kevakuutusmaksun osuus "+"("+ fm.format(elakeprosentti*100)+"%) "+
		fm.format(elake) + "\nTy�tt�myysvakuutuksen osuus "+"("+"0,50%) "+ fm.format(tyoton)+ "\nK�teen siis j�� "+ fm.format(kateen));
		
		
	}

}
