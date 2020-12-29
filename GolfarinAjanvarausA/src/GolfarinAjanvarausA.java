import java.util.Scanner;


public class GolfarinAjanvarausA {
	
	
	Scanner input = new Scanner(System.in);

	public int kirjoita(){
		
			int lkm = 0;
			String pisteStr; 
			int yhteensŠ =0;
			do { lkm++;
				System.out.println("Seuraavassa lŠhdšssŠ on tŠllŠ hetkellŠ " + lkm+ " pelaajaa, yhteistasoitus on "+ yhteensŠ+".");
			    System.out.println("Anna tasoituksesi ilmoittautuaksesi lŠhtššn: ");
			    pisteStr = input.next();
			    int piste=Integer.parseInt(pisteStr);
			    if ( 0 <piste && piste < 54) {
				    yhteensŠ = yhteensŠ + piste; }
			    } while (lkm < 4);
			return yhteensŠ ;
	}
	
	public boolean tarkastaTasoitus() {
		String pisteStr = input.next();
		boolean oikein = false;
		int piste = Integer.parseInt(pisteStr);
		
		if ( pisteStr.matches("\\d+") && piste > 0 || piste < 54  ) {}
		else if (pisteStr.matches("\\d+") && piste < 0 || piste > 54 ) {System.out.print("tasoituksen pitŠŠ olla 0-54.");oikein = true;}
		else {System.out.print("tasoituksen pitŠŠ olla numeerinen"); oikein = true;}
		
		return oikein;
	
		
	}
	
    public int kŠytŠ (int yhteensŠ) {
	     int lkm=0;
	     String pisteStr;
    	do { lkm++;
		System.out.println("Seuraavassa lŠhdšssŠ on tŠllŠ hetkellŠ " + lkm+ " pelaajaa, yhteistasoitus on "+ yhteensŠ+".");
	    System.out.println("Anna tasoituksesi ilmoittautuaksesi lŠhtššn: ");
	    pisteStr = input.next();
	    int piste=Integer.parseInt(pisteStr);
	    if ( 0 <piste && piste < 54) {
	    yhteensŠ = yhteensŠ + piste; }
	    } while (lkm < 4);
	if (lkm < 3) {System.out.print("Seuraavassa lŠhdšssŠ on tŠllŠ hetkellŠ "+ lkm+ " pelaaja, yhteistasoitus on "+ yhteensŠ);}
	else if (lkm > 3) {System.out.print("Valitettavasti yhteistasoituksen maksimiraja ylittyy, et enŠŠ mahdu tŠhŠn lŠhtššn.");}
	return yhteensŠ;
    }   
    
	public static void main(String[] args) 
	{
	
	
	int yhteensŠ;
	GolfarinAjanvarausA ohjelma = new GolfarinAjanvarausA();
	
	String pisteStr = ohjelma.kirjoita();
	piste = ohjelma.tarkastaTasoitus();
	yhteensŠ = ohjelma.kŠytŠ(piste);
	
	    
	}
	
}
