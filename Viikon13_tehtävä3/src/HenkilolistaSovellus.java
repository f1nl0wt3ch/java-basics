import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class HenkilolistaSovellus {
	
	List<Henkilo> henkiloLista = new ArrayList<Henkilo>();
	

	// lisää henkilö metodi
	private void LisaaHenkilo(){
		Scanner input = new Scanner(System.in);
		System.out.print("Anna nimi: ");
		String nimi = input.nextLine();
		System.out.print("Anna osoite: ");
		String osoite = input.next();
		System.out.print("Anna pituus: ");
		double pituus = input.nextDouble();
		System.out.print("Anna paino: ");
		int paino = input.nextInt();
		
		Henkilo henkilo = new Henkilo(nimi, osoite, pituus, paino);
		henkiloLista.add(henkilo);
	}
	// näyttä henkilön tiedot
	private void NaytaaHenkilo(){
		DecimalFormat fm = new DecimalFormat("0.00");
		Scanner input = new Scanner(System.in);
		System.out.print("Anna näytettävän henkilön nimi: ");
		String nimi = input.nextLine();
		
		for (int i=0; i< henkiloLista.size(); i++){
			if (nimi.equals(henkiloLista.get(i).getNimi())){
				System.out.print(henkiloLista.get(i).toString());
				System.out.print("\nPainoindeksi: "+fm.format(henkiloLista.get(i).getPainodeksi()));
			}
			else {System.out.print("Henkilöä ei ole");}
		}
	}
	// muuta nimi ja osoite metodi
	public void muutaNimiOsoite(){
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		System.out.print("Anna perustietoja muutettavan henkilön nimi: ");
		String nimi = input.nextLine();
		for (int i=0; i< henkiloLista.size(); i++){
			if (nimi.equals(henkiloLista.get(i).getNimi())){
			   double pituus = henkiloLista.get(i).getPituus();
			   int paino = henkiloLista.get(i).getPaino();
			   henkiloLista.remove(i);
			    System.out.print("Anna nimi: ");
				String newnimi = input.nextLine();
				System.out.print("Anna osoite: ");
				String newosoite = input1.nextLine();
				Henkilo henkilo = new Henkilo(newnimi, newosoite, pituus, paino );
				
				henkiloLista.add(henkilo);
			
			    
			}
			else {System.out.print("Henkilöä ei ole");}
		}
	}
	
	private void muutaaKoko(){
		Scanner input = new Scanner(System.in);
		System.out.print("Anna perustietoja muutettavan henkilön nimi: ");
		String syote = input.nextLine();
		for (int i=0; i< henkiloLista.size(); i++){
			if (syote.equals(henkiloLista.get(i).getNimi())){
				String nimi = henkiloLista.get(i).getNimi();
				String osoite = henkiloLista.get(i).getOsoite();
				henkiloLista.remove(i);
				System.out.print("Anna pituus: ");
				double newpituus = input.nextDouble();
				
				System.out.print("Anna paino: ");
				int newpaino = input.nextInt();
				
				
			Henkilo	henkilo = new Henkilo(nimi, osoite, newpituus, newpaino);
			    henkiloLista.add(henkilo);}
			else {System.out.print("Henkilöä ei ole");}
			}
	}
	
	private void naytaaKaikki(){
		DecimalFormat fm = new DecimalFormat("0.00");
		for (int i=0; i< henkiloLista.size(); i++){
			System.out.print(henkiloLista.get(i).toString());
			System.out.print("\nPainoindeksi: "+fm.format(henkiloLista.get(i).getPainodeksi()));
		}
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		HenkilolistaSovellus sovellus = new HenkilolistaSovellus();
		int valinta;
		do {
			System.out.print("\n1. Lisää henkilö");
			System.out.print("\n2. Näytä henkilön tiedot");
			System.out.print("\n3. Muuta henkilön nimi ja osoite");
			System.out.print("\n4. Muuta henkilön koko");
			System.out.print("\n5. Näytä kaikki henkilöt");
			System.out.print("\n0. Lopetus");
			System.out.print("\nAnna valintasi (0-5): ");
			valinta = input.nextInt();
			
			switch (valinta){
			case 1: sovellus.LisaaHenkilo();
			        break;
			case 2: sovellus.NaytaaHenkilo();
			        break;
				
			case 3: 
				    sovellus.muutaNimiOsoite();
			        break;
				
			case 4: sovellus.muutaaKoko();
			        break;
			
			case 5: sovellus.naytaaKaikki();
			        break;
				
			case 6: break;
			
			              }
		                       } while (valinta != 0);
		
		} 
	
	} 




