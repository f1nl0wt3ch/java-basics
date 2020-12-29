import java.text.DecimalFormat;
import java.util.Scanner;


public class kassakone 
{
/*Tee ohjelma Kassakone, joka laskee ostosten loppusumman. Ostosten hintoja sy�tet��n, 
 * kunnes k�ytt�j� antaa hinnaksi 0. T�m�n j�lkeen ohjelma n�ytt�� ostosten yhteishinnan, 
 * verottoman hinnan ja arvonlis�veron. Arvonlis�vero on tuotteen myyntihinnasta 18.7%.
Esimerkkitulostus
 
Anna ostoksen hinta (0 lopettaa): 20,9
Anna ostoksen hinta (0 lopettaa): 12,3
Anna ostoksen hinta (0 lopettaa): 140,0
Anna ostoksen hinta (0 lopettaa): 0
Ostosten verollinen hinta on 173,20
ALV:n osuus on 32,39
Veroton hinta on 140,81*/
	public static void main(String[] args) 
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		// muuttujien esittely
		double verollinenhinta = 0;
		double hinta;
		
		final double arvonlisavero = (18.7)/100;
		
		// pyyt��minen
		System.out.print("Anna ostoksen hinta (0 lopettaa"+"): ");
		hinta=input.nextDouble();
		// toistarakenne
		while (hinta != 0) { verollinenhinta = verollinenhinta + hinta;
		
		System.out.print("Anna ostoksen hinta (0 lopettaa"+"): ");
		hinta=input.nextDouble();	
		}
		// laskenta
		double verotonhinta, ALV;
		
		ALV = arvonlisavero*verollinenhinta;
		verotonhinta = verollinenhinta - ALV;
		//tulostaminen
		
		System.out.print("Ostosten verollinen hinta on "+ fm.format(verollinenhinta)+"\n");
		System.out.print("ALV:n osuus on "+ fm.format(ALV)+"\n");
		System.out.print("veroton hinta on "+ fm.format(verotonhinta));
		
		
	}

}
