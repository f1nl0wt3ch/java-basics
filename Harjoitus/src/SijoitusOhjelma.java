import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SijoitusOhjelma {
	
	List<Sijoitus> sijoitusLista = new ArrayList<Sijoitus>();;
	Sijoitus sijoitus;
	
	// metodi valinta 1:lle
	private void kysySijoitus(){
		
		
		
		
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		System.out.print("Anna sijoituksen nimi: ");
		String nimi = input.nextLine();
		
		System.out.print("Anna sijoituksen tämän hetkeinen arvo euroissa: ");
		int arvo = input1.nextInt();
		
		sijoitus = new Sijoitus(nimi, arvo);
		sijoitusLista.add(sijoitus);
	}
	// metodi valinta 2:lle
	 private void nayttaaLisatytKurssi(){
		 
		 System.out.println("Sijoitukset: ");
		 for(int i=0; i< sijoitusLista.size(); i++){
			 Sijoitus list = sijoitusLista.get(i);
			 
			 System.out.println(list.toString());
		 }
	  
	 }

	public static void main(String[] args) {
		SijoitusOhjelma ohjelma = new SijoitusOhjelma();
		Scanner input = new Scanner(System.in);
		int valinta;
		
		do{
		System.out.print("\n1. Anna uusi sijoitus");
		System.out.print("\n2. Näytä lisätyt sijoitukset");
		System.out.println("\n3. Lopeta");
		valinta = input.nextInt();
		switch (valinta){
		case 1: ohjelma.kysySijoitus();
			  break;
		case 2 : ohjelma.nayttaaLisatytKurssi();
			break;
		case 3:
			break;
		}
		
		} while (valinta != 3);
	}

}
