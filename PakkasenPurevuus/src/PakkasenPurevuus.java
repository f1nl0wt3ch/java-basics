import java.text.DecimalFormat;
import java.util.Scanner;


public class PakkasenPurevuus 

{

	public static void main(String[] args) 
	{
	Scanner input = new Scanner(System.in);	
	DecimalFormat fm = new DecimalFormat("0.0");
	double lŠmpštila, pakka;
	int voimakkuus;
	System.out.print("Anna lŠmpštila: ");
	lŠmpštila = input.nextDouble();
	System.out.print("Anna tuulen voimakkuus: ");
	voimakkuus = input.nextInt();
	if ( voimakkuus > 10 && lŠmpštila < 0 ){pakka = 2*lŠmpštila;
	System.out.print("LŠmpštila tuntuu samalta kuin "+ fm.format(pakka));}
	if ( 0 <= voimakkuus && voimakkuus <= 10 && lŠmpštila < 0) {pakka = 1.5*lŠmpštila;
	System.out.print("LŠmpštila tuntuu samalta kuin "+ fm.format(pakka));}
	else if ( lŠmpštila > 0 ) {System.out.println("pakkasen purevuutta ei voida laskea");}
	}

}
