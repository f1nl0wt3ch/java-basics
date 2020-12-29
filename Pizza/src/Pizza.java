import java.text.DecimalFormat;
import java.util.Scanner;


public class Pizza 
{/*
Pizzeria tarjoaa kolme pizzaa kahden hinnalla, halvimman pizzan saa siis kaupan p��lle. Tee ohjelma Pizza, joka kysyy kolmen pizzan hinnan 
(desimaalilukuja) ja kertoo t�m�n j�lkeen ostettujen pizzojen yhteishinnan sek� yksitt�iselle pizzalle tulevan hinnan.

Ratkaise ongelma siten, ett� selvit�t ensin halvimman pizzan hinnan ja v�henn�t sen kaikkien kolmen pizzan hinnasta

summa = pizza1 + pizza2 + pizza3 - halvin;

keskihinta = summa / 3;
Esimerkkitulostus
 
Anna pizzojen hinnat (3): 10,7 8,6 9,3
Maksettavaa: 20,00
Yksitt�isen hinta: 6,67
*/

	public static void main(String[] args) 
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		// muuttujien esittely
	
		double pizza1, pizza2, pizza3,summa,halvin, keskihinta;
		// pyytaminen
		
		System.out.print("Anna pizzojen hinnat ("+"3): ");
		pizza1=input.nextDouble(); pizza2=input.nextDouble(); pizza3=input.nextDouble();
		
		/* toinen tapa
		if (pizza1 <= pizza2 && pizza1 <= pizza3)
		   { summa = pizza2 + pizza3; keskihinta = summa / 3;System.out.print("Maksettavaa: "+ fm.format(summa)+" \nYksitt�isen hinta: "+ fm.format(keskihinta));
			}
		else if (pizza2 <= pizza1 && pizza2 <= pizza3)
		   { summa = pizza1 + pizza3; keskihinta = summa / 3; System.out.print("Maksettavaa: "+ fm.format(summa)+" \nYksitt�isen hinta: "+ fm.format(keskihinta));
			}
		else if (pizza3 <= pizza1 && pizza3 <= pizza2)
		   { summa = pizza1 + pizza2; keskihinta = summa / 3;System.out.print("Maksettavaa: "+ fm.format(summa)+" \nYksitt�isen hinta: "+ fm.format(keskihinta));
			}*/
		// kommandi
		
		 if (pizza1 <= pizza2 && pizza1 <= pizza3) { 
		    	halvin = pizza1;
		    	summa = pizza1 + pizza2 + pizza3 - halvin;
		    	keskihinta = summa / 3;
		    	System.out.print("Maksettavaa: "+ fm.format(summa)+"\nYksitt�isen hinta: "+ fm.format(keskihinta));}
		 else if (pizza2 <= pizza1 && pizza2 <= pizza3) {  
			    halvin = pizza2;
		    	summa = pizza1 + pizza2 + pizza3 - halvin;
		    	keskihinta = summa / 3;
		    	System.out.print("Maksettavaa: "+ fm.format(summa)+"\nYksitt�isen hinta: "+ fm.format(keskihinta));}
		 else if (pizza3 <= pizza1 && pizza3 <= pizza2) {  
			    halvin = pizza3;
		    	summa = pizza1 + pizza2 + pizza3 - halvin;
		    	keskihinta = summa / 3;
		    	System.out.print("Maksettavaa: "+ fm.format(summa)+"\nYksitt�isen hinta: "+ fm.format(keskihinta));}
		 
		 
		 
	     
	     
		       
		       
		   
			
		      
		
		
		
    
		
		

	}

}
