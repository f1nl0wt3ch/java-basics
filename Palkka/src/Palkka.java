import java.text.DecimalFormat;
import java.util.Scanner;


public class Palkka 
{
/*
Tee ohjelma Palkka, joka kysy k�ytt�j�lt� bruttopalkan (kokonaisluku) ja veroprosentin (desimaaliluku). 
Ohjelma laskee k�teen j��v�n osuuden palkasta ja verojen, ty�tt�myysvakuutuksen (0,50%) sek� ty�el�kevakuutusmaksun (5,55%) m��r�n. 
Muotoile vastaus kahdella desimaalilla.

Laskukaavat:

vero = bruttopalkka - bruttopalkka * (100-veroprosentti) / 100.0;

elakemaksu = bruttopalkka * 5.55/100.0;

tyotmaksu = bruttopalkka * 0.50/100.0;

kateen = bruttopalkka - vero - elakemaksu - tyotmaksu;
Esimerkkitulostus
 
Anna palkka: 2000
Anna veroprosentti: 20,0
Bruttopalkka 2000
Veron osuus (20,00%) 400,00
Ty�el�kevakuutusmaksun osuus (5,55%) 111,00
Ty�tt�myysvakuutuksen osuus (0,50%) 10,00
K�teen siis j�� 1479,00*/
	public static void main(String[] args) 
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		DecimalFormat fm1 = new DecimalFormat("0");
		// muuttujien esittely
		
		double palkka, bruttopalkka, veroprosentti, vero, tyomaksu, kateen, elakemaksu;
		// pyytaminen
		System.out.print("Anna palkka: ");
		palkka=input.nextDouble();
		System.out.print("Anna veroprosentti: ");
		veroprosentti=input.nextDouble();
		//laskenta
		bruttopalkka = palkka;
		vero = bruttopalkka - bruttopalkka * (100-veroprosentti) / 100.0;
		elakemaksu = bruttopalkka*5.55/100.0;
		tyomaksu = bruttopalkka*0.50/100.0;
		kateen = bruttopalkka - vero - elakemaksu - tyomaksu;
		// tulostaminen
		System.out.print("Bruttopalkka " +fm1.format(palkka) +"\nVeron osuus "+"("+fm.format(veroprosentti)+"%) "+ fm.format(vero)+ "\nTy�el�kevakuutusmaksun osuus (5,55%) "+fm.format(elakemaksu)+"\nTy�tt�myysvakuutuksen osuus (0,50%) "+fm.format(tyomaksu)+" \nK�teen siis j�� "+fm.format(kateen));
		
		
		
	}

}
