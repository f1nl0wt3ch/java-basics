import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class PelaajalistaSovellus {
	List <Pelaaja> PelaajaLista = new ArrayList<Pelaaja>();
	
	// Lisää pelaaja metodi
	
	private void LisaaPelaaja(){
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		System.out.print("Anna pelinumero: ");
		int pelinumero = input.nextInt();
		
		System.out.print("Anna nimi: ");
		String nimi = input1.nextLine();
		
		System.out.print("Anna pelipaikka: ");
		String pelipaikka = input1.nextLine();
		
		
		Pelaaja pelaaja = new Pelaaja(pelinumero, nimi, pelipaikka);
		PelaajaLista.add(pelaaja);
		
		
	}
	
	// hakee pelaaja metodi
	private void HakePelaaja(){ 
		Scanner input = new Scanner(System.in);
		System.out.println("Anna pelinumero: ");
		int pelinumero = input.nextInt();
		boolean vaarin = false;
		
		for (int i= 0; i< PelaajaLista.size() && vaarin == false ; i++){
			if ( pelinumero == PelaajaLista.get(i).getPelinumero()) {
				System.out.println(PelaajaLista.get(i).toString());
				//System.out.print("Pelaaja ei ole pelinumerolla "+ pelinumero );
				vaarin = true;
			}
			// else {System.out.println(PelaajaLista.get(i).toString());}
			else {System.out.print("Pelaaja ei ole pelinumerolla "+ pelinumero );
			vaarin = true;}
			 
		    
		}
	}
	
	// näyttä pelaaja metodi
	
	private void NaytaPelaaja(){
		for (int i=0; i< PelaajaLista.size(); i++) {
		System.out.println(PelaajaLista.get(i).toString());
		}
	}

	public static void main(String[] args) {
		PelaajalistaSovellus sovellus = new PelaajalistaSovellus();
		Scanner input = new Scanner(System.in);
		int valinta;
		
		do{
		System.out.print("\n1. Lisää pelaaja");
		System.out.print("\n2. Hae pelaaja");
		System.out.print("\n3. Näytä pelaajat");
		System.out.print("\n0. Lopetus");
		System.out.print("\nAnna valintasi (0-3): ");
		valinta = input.nextInt();
		
		switch (valinta) {
		
		     case 1: sovellus.LisaaPelaaja();
		    	      break;
		     case 2: sovellus.HakePelaaja();
		    	      break;
		     case 3: sovellus.NaytaPelaaja();
		    	      break;
		     case 4:
		    	      break;
		}
		
		} while(valinta != 0);
		

	}

}