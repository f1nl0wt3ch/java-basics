import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SanalistaSovellus {
	List <String> SanaLista = new ArrayList<String>();
	
	// syötää sana listaan metodi
	private void LisaaSana(){
		Scanner input = new Scanner(System.in);
		System.out.print("Anna sana: ");
		String sana = input.nextLine();
		SanaLista.add(sana);
	}
	
	// näytä sanat metodi
	private void NaytaLista(){
		for (int i = 0; i< SanaLista.size(); i++){
			String sana = SanaLista.get(i);
		     System.out.println(sana);
		}
	}

	// laske sana metodi
	private void LaskeSana(){
		Scanner input = new Scanner(System.in);
		System.out.print("Anna sana, minkä esiintymiskerrat lasketaan: ");
		String sana = input.nextLine();
		int lkm = 0;
		for (int i =0; i< SanaLista.size(); i++) {
			if (sana.equals(SanaLista.get(i))) {
				lkm++;
			}
		}
		System.out.print("Sana keppi esiintyi "+ lkm + " kertaa");
	}
	// poistaa sana listasta metodi
	
	private void PoistaaSana(){
		Scanner input = new Scanner(System.in);
		System.out.print("Anna sana, joka poistetaan: ");
		String sana = input.nextLine();
		boolean vaarin = true;
		for (int i=0 ; i< SanaLista.size() && vaarin == true; i++) {
			if (!sana.equals(SanaLista.get(i))) {
				
				System.out.print("Sanaa "+ sana+ " ei ollut listassa");
				vaarin = false;
			}
			else {
				SanaLista.remove(i);
				System.out.println("Jokainen sana "+ SanaLista.get(i)+ " on poistettu listasta");}
			}
		}

		
	
	
	public static void main(String[] args) 
	{
		SanalistaSovellus sovellus = new SanalistaSovellus();
		Scanner input = new Scanner(System.in);
		int valinta;
		
		 do {
			 System.out.print("\n1 = Lisää sana");
			 System.out.print("\n2 = Listaa sanat");
			 System.out.print("\n3 = Laske sanat");
			 System.out.print("\n4 = Poista sanat");
			 System.out.print("\n0 = Lopeta");
			 System.out.print("\nAnna valintasi:");
			 valinta = input.nextInt();
			 
			 switch (valinta){
			 case 1: sovellus.LisaaSana();
			         break;
				 
			 case 2: sovellus.NaytaLista();
			         break;
				 
			 case 3: sovellus.LaskeSana();
			         break;
				 
			 case 4: sovellus.PoistaaSana();
			         break;
				 
			 case 0: break;
			 
			 }
			 
		 } while (valinta != 0);
		

	}

}
