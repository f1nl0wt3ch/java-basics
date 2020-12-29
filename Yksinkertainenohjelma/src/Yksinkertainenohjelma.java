import java.text.DecimalFormat;
import java.util.Scanner;


public class Yksinkertainenohjelma 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
  /*int ikä;
  String nimi;
  
  Scanner input = new Scanner(System.in);
  System.out.println("Kirjoita ikäsi: ");
  ikä=input.nextInt();
  input.nextLine();
  System.out.println("Kirjoita nimesi: ");
  nimi=input.nextLine();
  System.out.println("Ikä: "+ikä+" ja nimesi on "+nimi);
  */
		/*String teksti, nayttaminen;
		   Scanner input = new Scanner(System.in);
		   System.out.print("Kirjoita teksti: ");
		   teksti = input.nextLine();
		   System.out.print("Näytetäänkä suurella vai pienellä: ");
		   nayttaminen = input.nextLine();
		   if (nayttaminen.equals("pienellä")) { teksti = teksti.toLowerCase();
		   } else if (nayttaminen.equals("suurella")) { teksti = teksti.toUpperCase();
		   }
		      System.out.println("Teksti on " + teksti);
		     ee ohjelma, joka kysyy käyttäjältä palautteen. Tämän jälkeen ohjelma kertoo palautteen pituuden. Jos palautteessa on ?-merkki, ohjelma kertoo, että kysymykseen vastataan mahdollisimman pian. Muuten ohjelma kertoo, että palaute on otettu vastaan.
Esimerkki ohjelmasta
Kirjoita palautteesi: Täytyykö ottaa sateenvarjo mukaan? Palautteesi pituus oli 34 merkkiä.
Kysymykseesi vastataan mahdollisimman pian.
Toinen esimerkki ohjelmasta
Kirjoita palautteesi: Ulkona näyttäisi satavan ... Palautteesi pituus oli 28 merkkiä.
Palautteesi on otettu vastaan. 
		      */
		
		/*Scanner input = new Scanner(System.in);
		String teksti;
		System.out.println("Kirjoita palautteesi: ");
		teksti = input.nextLine();
		 int numero = teksti.length();
		 if (teksti.(?) ){
		 System.out.println("Palutteesi pituus oli "+numero+" merkkiä");
		 System.out.println("Kysymykseesi vastataan mahdollisiman pian");
		 }
		
		 else {System.out.println("Palutteesi pituus oli "+numero+" merkkiä");
		 System.out.println("Palautteesi on otettu vastaan");}*/
		
		
		
		/*
		double yhteensä, loppusumma;
		String vastaus ;
		System.out.println("Anna ostosten summa: ");
		yhteensä=input.nextDouble();
		input.nextLine();
		System.out.println("Oletko kanta-asiakas (kyllä,ei"+") ");
		vastaus=input.nextLine();
		if (vastaus.equals("kyllä") && yhteensä > 1000) { loppusumma = (99*yhteensä) /100;
		System.out.println("Ostosten loppusumma on "+ fm.format(loppusumma));}
		else if(vastaus.equals("kyllä")) {loppusumma = (99.5*yhteensä)/ 100;
		System.out.println("Ostosten loppusumma on "+ fm.format(loppusumma));}
		else if(vastaus.equals("ei") && yhteensä > 1000) { loppusumma = (99*yhteensä) /100;
		System.out.println("Ostosten loppusumma on "+ fm.format(loppusumma));}
		else { loppusumma = yhteensä ;
		System.out.println("Ostosten loppusumma on "+ fm.format(loppusumma));}
		*/
		Scanner input= new Scanner(System.in);
		String sananlasku;
		final String stop= "LOPPU";
		int summa = 0, lkm = -1;
		do { 
			lkm =lkm + 1;
		    System.out.print("Anna sananlasku: ");
		    sananlasku=input.nextLine();
		    summa= summa + sananlasku.length();
		   } while (!sananlasku.equals(stop));
		
		System.out.println("Sananlaskuja oli "+lkm+" kappaletta.");
		System.out.println("Sananlaskuissa oli merkkejä yhteensä "+ summa );
		
		/*
		String tunnussana = "ruska";
		String vastaus;
		int lkm = 0;
		
		do { lkm=lkm+1;
	    System.out.print("Ovivahti kysy "+lkm+". kertaa, tunnussana ");
	    vastaus=input.next();
	    if (lkm >= 3) { System.out.print("Ovi on lukittu");}
	    } while (lkm < 3 && !vastaus.equals(tunnussana));
		if (vastaus.equals(tunnussana)) {  System.out.print("Sisään");}
	    
*//*
		package kalvoesim;

		import java.util.Scanner;

		public class OpiskelijaTarkastus 
		{

			public static void main(String[] args) 
			{
				
		/*
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Anna opiskelijatunnus: ");
		String tunnus =input.nextLine();
		if (tunnus.matches("[a]\\d{7}")){System.out.println("Opiskelijatunnus on kelvollinen");}
		else {System.out.println("Opiskelijatunnus on kevoton");};
		
		System.out.println("Anna opiskelijan nimi: ");
		String nimiStr=input.nextLine();
		if (nimiStr.matches("[A-ZÅÄÖa-z̈åäö-]+\\s+[A-ZÅÄÖa-z̈åäö-]{2,30}")){ System.out.println("Opiskelijan nimi on kelvollinen");}
		else {System.out.println("Opiskelijan nimi on kelvoton");};
		
		System.out.println("Anna opiskelijan ryhmä: ");
		String ryhmä=input.nextLine();
		if (ryhmä.matches("[A-Z]{2}\\d{1}[A-Z]{2}"))
		{System.out.println("Opiskelijan ryhmä on kelvollinen");}
		else {System.out.println("Opiskelijan ryhmä on kelvoton");};
		
		
		System.out.println("Anna opiskelijan ikä: ");
		String ikäStr = input.nextLine();
		if (ikäStr.matches("\\d+")) { 
		                 int ikä = Integer.parseInt(ikäStr);	
		                 if (ikä >= 18 && ikä <= 65 ) {System.out.print("Opiskelijan ikä on kelvollinen");}
		                 else {System.out.print("Ikä pitää olla 18-65");}
		                            }	
		else {System.out.print("Ikä pitää olla numeerinen");}*/
	}



	
	
}

