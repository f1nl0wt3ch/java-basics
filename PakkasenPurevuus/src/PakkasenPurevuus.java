import java.text.DecimalFormat;
import java.util.Scanner;


public class PakkasenPurevuus 

{

	public static void main(String[] args) 
	{
	Scanner input = new Scanner(System.in);	
	DecimalFormat fm = new DecimalFormat("0.0");
	double l�mp�tila, pakka;
	int voimakkuus;
	System.out.print("Anna l�mp�tila: ");
	l�mp�tila = input.nextDouble();
	System.out.print("Anna tuulen voimakkuus: ");
	voimakkuus = input.nextInt();
	if ( voimakkuus > 10 && l�mp�tila < 0 ){pakka = 2*l�mp�tila;
	System.out.print("L�mp�tila tuntuu samalta kuin "+ fm.format(pakka));}
	if ( 0 <= voimakkuus && voimakkuus <= 10 && l�mp�tila < 0) {pakka = 1.5*l�mp�tila;
	System.out.print("L�mp�tila tuntuu samalta kuin "+ fm.format(pakka));}
	else if ( l�mp�tila > 0 ) {System.out.println("pakkasen purevuutta ei voida laskea");}
	}

}
