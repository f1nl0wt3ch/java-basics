import java.text.DecimalFormat;
import java.util.Scanner;


public class AlvHuojennus 
{
/*
 Tee ohjelma AlvHuojennus, joka kysyy yrityksen tilikauden liikevaihdon (desimaaliluku) sekä maksetun arvonlisäveron määrän (desimaaliluku). 
 Ohjelma laskee yritykselle huojennettavan arvonlisäveron. Jos liikevaihto on enintään 8 500 euroa, verovelvollinen saa huojennuksena koko tilikauden
  arvonlisäveron.
  Jos liikevaihto on vähintään 8 500 euroa mutta alle 22 500 euroa, maksettavaa arvonlisäveroa huojennetaan osittain.
   Huojennuksen määrä lasketaan kaavalla: 

huojennus = maksettu alvvero - (liikevaihto – 8 500) * maksettu alvvero / 14000.0

Esimerkiksi jos yrityksen liikevaihto oli 10 000 ja yritys maksoi alvveroa 1200, yrityksen huojennus on 1071.4285714285713 (1200-(10 000-8500)*1200/14000.0)
Esimerkkitulostus
 
Tulot ja maksettu alv: 10000,0 1200,0
Huojennus on: 1071,43
 */
	public static void main(String[] args) 
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		// muuttujien esittely
		double huojennus, maksettu, liikevaihto;
		// pyytaminen
		System.out.print("Tulot ja maksettu alv: ");
		liikevaihto=input.nextDouble();
		maksettu=input.nextDouble();
		// laskenta ja kommandi
		if (liikevaihto <= 8500){
			huojennus = maksettu;
			System.out.print("Huojennus on: "+ fm.format(huojennus));
			
		}
		else if (liikevaihto > 8500 && liikevaihto <= 22500){
		    huojennus = maksettu - (liikevaihto - 8500)*maksettu / 14000.0;
		    System.out.print("Huojennus on: "+ fm.format(huojennus)); }
				
		
	
	}

}
