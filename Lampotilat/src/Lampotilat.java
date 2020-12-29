import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;




public class Lampotilat {

	public static void main(String[] args) 
	{
		/*// bai 1
		Scanner input = new Scanner(System.in);
		int lkm = 0;
		final int MAX = 100;
		int numero;
		int [] lampotilataulukko = new int [MAX];
		System.out.print("Anna lampotilat: ");
    	numero=input.nextInt();
		while ( numero != -999 && lkm < MAX ) { 
        	lampotilataulukko [lkm] = numero;
        	lkm++;
        	System.out.print("Anna lampotilat: ");
        	numero=input.nextInt();
        	
        	}  ;
        	Arrays.sort(lampotilataulukko,0,lkm);
        	System.out.print("Annoit lämpötila on ");
        	for ( int i = 0; i< lkm;
			i++){
        	System.out.print(lampotilataulukko[i] + " ");}
        	*/
		/*// tehtävä 2
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		double tunti, brutto;
		int vastaus, yhteensä = 0;
		// pyytaminen
		System.out.print("Anna tuntipalkkasi: ");
		tunti=input.nextDouble();
		System.out.print("Monenko päivän tuntimäärät annat: ");
		int määrä=input.nextInt();
		double [] päivät = new double [määrä];
		int lkm = 0;
		
		while (lkm < määrä) {
			
			System.out.print("Anna tuntien määrä päivässä: ");
			vastaus=input.nextInt();
			päivät[lkm] = vastaus;
			lkm ++;
			yhteensä = yhteensä + vastaus;
		};
		
		brutto= yhteensä*tunti;
		
		System.out.println("Tunteja yhteensä: "+yhteensä);
		System.out.println("Bruttopalkkasi: "+ fm.format(brutto));
		System.out.print("Annoit tunnit: ");
		for ( int i=0; i< lkm; i++){
		System.out.print(päivät[i]+ "");}
        */
		/*// tehtävä3
		Scanner input = new Scanner(System.in);
		int max = 10;
		String sanaStr;
		String [] sanat = new String [max];
		int lkm = 0, yhteensä =0;
		do {System.out.print("Anna sananlasku:");
		sanaStr=input.nextLine();
		sanaStr=sanaStr.trim();
		sanat [lkm] = sanaStr;
		lkm++;
		yhteensä = yhteensä + sanaStr.length();
		
		}
		while (!sanaStr.equals("LOPPU") && lkm < max);
		
		int lkm1 = lkm-1;
		int yhteensä1= yhteensä -5;
		if (lkm >= 10) {  System.out.println("Enää ei mahdu lisää sananlaskuja" );
		System.out.println("Sananlaskuja oli "+lkm+" kappaletta.");
		System.out.println("Sananlaskuissa oli merkkejä yhteensä "+yhteensä1);
		System.out.println("Annoit sanalaskut");
		for (int i=0; i<lkm; i++){
		System.out.println(sanat[i]);}}
		else {
		System.out.println("Sananlaskuja oli "+lkm1+" kappaletta.");
		System.out.println("Sananlaskuissa oli merkkejä yhteensä "+yhteensä1);
		System.out.println("Annoit sanalaskut");
		for (int i=0; i<lkm-1; i++){
		System.out.println(sanat[i]);}
		
		}*/
		/*
		// tehtävä 4
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		int lkm = 0, määrä, summa = 0;
		int piste;
		System.out.print("Anna pelaajien lukumäärä: ");
		määrä=input.nextInt();
		int [] määrät = new int [määrä];
		for (int i=0; i< määrä; i++) { lkm++;
		System.out.print("Anna pelaajan "+lkm+". tulos: ");
			piste =input.nextInt();
			määrät[i] = piste;
			summa = summa + piste;
			
			};
			double keskiarvo = ((double) summa) / lkm;
			
		    System.out.println("Pelien keskiarvo oli " + fm.format(keskiarvo));
		
			Arrays.sort(määrät, 0, lkm++);// xep theo gia tri
			System.out.println("Pienin peli oli "+ määrät[0]);
			 
				
		    
		    System.out.println("Suurin peli oli "+ määrät[(määrä-1)]) ;
		    
		    int lkm1 =0;
		    for (int j=0; j< määrä; j++) { if ( määrät[j] < keskiarvo) { 
		    	lkm1++;
		    	
		    		}
		   
		    }
		    System.out.println(lkm1 +" pelaajalla oli keskiarvoa pienempi tulos");	
		     
		    */
		    	
		    
		    	
		    
	       
		//tehtävä5
		Scanner input = new Scanner(System.in);
		int [] avainluvut={1234, 4321, 1111, 2222, 3333, 4444, 1122, 1133, 1144, 2211};
		int vastaus, lkm = 0;
		boolean stop = false;
		    do {System.out.print("Anna avainluku: ");
	    	vastaus = input.nextInt();
	    	lkm++;
	     for (int i=0; i< avainluvut.length && stop!= true ; i++) { 
	    	 
	    	 if (lkm < 4 && vastaus == avainluvut [i]  ) {System.out.print("Avainluku on oikean ");stop = true;
		    	} 
	    	 
	    	 
	    	 else if ( lkm >3  && vastaus !=avainluvut [i] ) {System.out.print("Avainlukua ei annettu oikein.");stop = true;} 
	    	 
	    	 
	                                                              }// for toisto
	     
	                                          } while ( lkm < 3 && stop != true );
		    if (stop == false){System.out.print("Avainlukua ei annettu oikein.");}
	     }
	}
	     
		
	    
	


