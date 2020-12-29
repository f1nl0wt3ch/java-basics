import java.text.DecimalFormat;
import java.util.Scanner;


public class posti 
{
/*Tee ohjelma, joka laskee verkkokaupan tilauksen postituskulut. Ohjelma kysyy jokaisen tuotteen 
 * 
 painon kiloina. Kun painoksi annetaan -1, ohjelma laskee yhteenlaskettujen painojen perusteella 
 postituskulun seuraavalla periaatteella
Esimerkki ohjelmasta (näytä yhteispaino kahdella desimaalilla)
            Anna paino (-1 lopettaa): 1,3
            Anna paino (-1 lopettaa): 2,7
            Anna paino (-1 lopettaa): 0,9
            Anna paino (-1 lopettaa): -1
            Yhteispaino on 4,90 kiloa.
            Postituskulut ovat 8,10 euroa.
*/
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		double summa = 0;
		double paino, postituskulu;
		System.out.print("Anna paino (-1 lopettaa"+"): ");
		paino=input.nextDouble();
		while (paino != -1) { summa = summa + paino;
		System.out.print("Anna paino (-1 lopettaa"+"): ");
		paino=input.nextDouble();
		
		}
		if (summa < 20) { postituskulu = 8.10;
		System.out.print("Yhteispaino on "+ fm.format(summa)+ " kiloa");
		System.out.print("\nPostituskulut ovat "+fm.format(postituskulu) +" euroa");}
	else if ( summa >= 20 && summa <= 100) { postituskulu = 14.00;
	System.out.print("Yhteispaino on "+ fm.format(summa)+ " kiloa");
	System.out.print("\nPostituskulut ovat "+fm.format(postituskulu) +" euroa");}
	else { postituskulu = 19.00;
	System.out.print("Yhteispaino on "+ fm.format(summa)+ " kiloa");
	System.out.print("\nPostituskulut ovat "+fm.format(postituskulu) +" euroa");}
	}

}
