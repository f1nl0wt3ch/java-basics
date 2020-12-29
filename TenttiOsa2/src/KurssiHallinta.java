import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class KurssiHallinta {
	List<Kurssi> kurssit = new ArrayList<Kurssi>();
	
	private void kysyKurssi(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Anna kurssin nimi:");
		String nimi = input.nextLine();
		System.out.print("Anna kurssin opintopistemäärä:");
		int opintopiste = input.nextInt();
		
		Kurssi kurssi = new Kurssi(nimi, opintopiste);
		kurssit.add(kurssi);

		}
	private void naytaaKurssi(){
		for (int i =0; i <kurssit.size(); i++)
		{
			Kurssi kurssiLista = kurssit.get(i);
			System.out.println(kurssiLista.toString()+" ");
		}
		
	}
	
	public static void main(String[] args) {
		KurssiHallinta hallinta = new KurssiHallinta();
		Scanner input = new Scanner(System.in);
		 int valinta;
		  do{
		 System.out.print("\n1. Anna uusi kurssi");
		 System.out.print("\n2. Näytä lisätyt kurssit");
		 System.out.print("\n3. Lopeta");
		 valinta = input.nextInt();
		 
		 switch (valinta){
		 
		 case 1: hallinta.kysyKurssi();
		         break;
		 case 2: hallinta.naytaaKurssi();
		         break;
		 case 3: break;
		 }
		 } while (valinta != 3);
		
	}

}
