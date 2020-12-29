import java.util.Scanner;


public class GolfarinAjanvarausA {
	
	
	Scanner input = new Scanner(System.in);

	public int kirjoita(){
		
			int lkm = 0;
			String pisteStr; 
			int yhteens� =0;
			do { lkm++;
				System.out.println("Seuraavassa l�hd�ss� on t�ll� hetkell� " + lkm+ " pelaajaa, yhteistasoitus on "+ yhteens�+".");
			    System.out.println("Anna tasoituksesi ilmoittautuaksesi l�ht��n: ");
			    pisteStr = input.next();
			    int piste=Integer.parseInt(pisteStr);
			    if ( 0 <piste && piste < 54) {
				    yhteens� = yhteens� + piste; }
			    } while (lkm < 4);
			return yhteens� ;
	}
	
	public boolean tarkastaTasoitus() {
		String pisteStr = input.next();
		boolean oikein = false;
		int piste = Integer.parseInt(pisteStr);
		
		if ( pisteStr.matches("\\d+") && piste > 0 || piste < 54  ) {}
		else if (pisteStr.matches("\\d+") && piste < 0 || piste > 54 ) {System.out.print("tasoituksen pit�� olla 0-54.");oikein = true;}
		else {System.out.print("tasoituksen pit�� olla numeerinen"); oikein = true;}
		
		return oikein;
	
		
	}
	
    public int k�yt� (int yhteens�) {
	     int lkm=0;
	     String pisteStr;
    	do { lkm++;
		System.out.println("Seuraavassa l�hd�ss� on t�ll� hetkell� " + lkm+ " pelaajaa, yhteistasoitus on "+ yhteens�+".");
	    System.out.println("Anna tasoituksesi ilmoittautuaksesi l�ht��n: ");
	    pisteStr = input.next();
	    int piste=Integer.parseInt(pisteStr);
	    if ( 0 <piste && piste < 54) {
	    yhteens� = yhteens� + piste; }
	    } while (lkm < 4);
	if (lkm < 3) {System.out.print("Seuraavassa l�hd�ss� on t�ll� hetkell� "+ lkm+ " pelaaja, yhteistasoitus on "+ yhteens�);}
	else if (lkm > 3) {System.out.print("Valitettavasti yhteistasoituksen maksimiraja ylittyy, et en�� mahdu t�h�n l�ht��n.");}
	return yhteens�;
    }   
    
	public static void main(String[] args) 
	{
	
	
	int yhteens�;
	GolfarinAjanvarausA ohjelma = new GolfarinAjanvarausA();
	
	String pisteStr = ohjelma.kirjoita();
	piste = ohjelma.tarkastaTasoitus();
	yhteens� = ohjelma.k�yt�(piste);
	
	    
	}
	
}
