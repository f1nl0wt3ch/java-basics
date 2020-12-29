import java.text.DecimalFormat;
import java.util.Scanner;


public class viikko3_1 
{

	public static void main(String[] args) 
	{
		/* Harjoitus 1
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		// muuttujien esittely
		final double välitys = 3.44/100;
		double myyntihinta, välityspalkkio;
		// pyytaminen
		System.out.print("Anna asunnon myyntihinta: ");
		myyntihinta=input.nextDouble();
		// laskenta
		välityspalkkio = myyntihinta*välitys;
		// vertailu
		if (välityspalkkio < 2214) { välityspalkkio = 2214; }
		// tulostaaminen
		System.out.print("Myyntipalkkio on "+ fm.format(välityspalkkio));
	  */
		/*Harjoitus 2
		// kavion esittely
		Scanner input = new Scanner(System.in);
		// muuttujien esittely
		double ikä;
		// pyytaminen
		System.out.print("Anna ikä: " );
		ikä=input.nextDouble();
		// vertailu
		if ( ikä <= 0 || ikä >= 120) {System.out.println("Virhellinen ikä");
			}
		else if (ikä < 18 )  {System.out.println("Älaikainen ikä");
		}
		else { System.out.print("Täysi-ikä");}*/
		/* Harjoutus 3
		Scanner input = new Scanner(System.in);
		System.out.print("Anna arvosana (" +"0- 5 ): " );
		int arvosana;
		arvosana=input.nextInt();
		switch (arvosana) {
		case 5 : System.out.print("Kiitetävä"); 
		break;
		case 4: System.out.print("Hyvä"); 
		break;
		case 3: System.out.print("Hyvä"); 
		case 2: System.out.print("Tyydyttävä"); 
		break;
		case 1: System.out.print("Välttävä"); 
		break;
		case 0: System.out.print("Hylätty"); 
		break;
		}
		*/
		
		/*
		Scanner input = new Scanner(System.in);
		final double TORKEA = 1.2;
		final double JUOPUMUS = 0.5;
		double lukema;
		
		System.out.print("Alkometrin lukema: ");
		lukema = input.nextDouble();
		if (lukema >= TORKEA ) {System.out.println("Lukema "+ lukema + " vastaa törkeä rattijuopumusta.");
		}
		else if (lukema >= JUOPUMUS ) {System.out.println("Lukema "+ lukema + " vastaa rattijuopumusta.");
		}
		else {System.out.println("Lukema "+ lukema + " ei aiheuta toimenpiteitä.");
		}*/
		/*
		Scanner input = new Scanner(System.in);
		double piste;
		
		System.out.print("Anna piste: ");
		piste=input.nextDouble();
		if (piste >= 56 && piste <= 60 ){
				System.out.print("Kiittetävä");}
		else if (piste >= 44 && piste <= 55 ) {
			System.out.print("Hyvä");}
		else if (piste >= 30 && piste <= 43 ) {
			System.out.print("Tyydyttävä");}
		else if (piste < 30 ){
			System.out.print("Hylläty");}
		     */  
		/*
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		double hinta, luokka, ALV, alvhinta;

		System.out.print("Anna hinta: ");
		hinta =input.nextDouble();
		System.out.print("Anna alv luokka ("+"1-3) ");
		luokka=input.nextDouble();
		final double alv1 = 23.0/100;
		final double alv2 = 13.0/100;
		final double alv3 = 9.0/100;
				
				
		
		if ( luokka == 1) {
			ALV = alv1; alvhinta = (hinta + ALV*hinta); System.out.print("ALVhinta on " + fm.format(alvhinta) +"\nAlv on "+fm.format(ALV*100) + "%");}
		else if (luokka == 2) {
			ALV = alv2; alvhinta = (hinta + ALV*hinta); System.out.print("ALVhinta on " + fm.format(alvhinta) +"\nAlv on "+fm.format(ALV*100) + "%");}
		else if (luokka == 3) {
			ALV = alv3; alvhinta = (hinta + ALV*hinta);System.out.print("ALVhinta on " + fm.format(alvhinta) +"\nAlv on "+ fm.format(ALV*100) + "%");}
		*/
		/*
		Scanner input = new Scanner(System.in);
		double rajoitusnopeus, nopeus, sakko;
		System.out.print("Anna rajoitusnopeus: ");
		rajoitusnopeus=input.nextDouble();
		System.out.print("Anna nopeustesi: ");
		nopeus=input.nextDouble();
		if (rajoitusnopeus ==60 && nopeus <= 75 && nopeus > 60) {
			sakko = 85;
			System.out.print("Rikesakko on "+ sakko);
		}
		else if (rajoitusnopeus ==60 && nopeus > 75 && nopeus <= 80) {
			sakko = 115;
			System.out.print("Rikesakko on "+ sakko);
		}
		else if (rajoitusnopeus ==120 && nopeus > 120 && nopeus <= 135) {
			sakko = 70;
			System.out.print("Rikesakko on "+ sakko);
		}
		else if (rajoitusnopeus ==120 && nopeus > 135 && nopeus <= 140) {
			sakko = 100;
			System.out.print("Rikesakko on "+ sakko);
		}
		else if (rajoitusnopeus ==120 && nopeus > 140) {
			System.out.print("Kuljettajaa rangaistaan päiväsakoilla ");
		}
		else if (rajoitusnopeus ==60 && nopeus > 80) {
			System.out.print("Kuljettajaa rangaistaan päiväsakoilla ");
		} */
	    int summa = 0;
	    int pisteet;
	    int lkm = 0;
	    Scanner input = new Scanner(System.in);
	    System.out.print("Anna koepisteet:");
	    pisteet = input.nextInt();
	    while (pisteet <= 7) {
	       summa = summa + pisteet;
	       lkm = lkm + 1; // tai lkm++;
	       System.out.print("Anna koepisteet: ");
	       pisteet = input.nextInt();
	}
	    double keskiarvo = (double) summa / lkm;
	    DecimalFormat desi = new DecimalFormat("0.00");
	    System.out.println("Keskiarvo on " + desi.format(keskiarvo));
	    
	    
	}
}
