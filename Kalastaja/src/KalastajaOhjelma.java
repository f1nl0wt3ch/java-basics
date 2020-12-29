import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class KalastajaOhjelma {

	public static void main(String[] args) {
		
		Kalastaja kalastaja = new Kalastaja();
		
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		System.out.print("Anna kalastajan nimi: ");
		String nimi = input.nextLine();
		kalastaja.setNimi(nimi);
		String valinta;
		do {
		System.out.print("Haluatko lisätä kalan tiedot (k/e): ");
	    valinta = input1.next();
		
		if (valinta.equals("k")){
			System.out.print("Anna kalan laji: ");
			String laji = input.next();
			    
			System.out.print("Anna kalan paino (kg): ");
			double paino = input1.nextDouble();
			   
			System.out.print("Anna kalan pituus (cm): ");
			double pituus = input.nextDouble();
			Kala kala = new Kala(laji, paino, pituus);
			
			kalastaja.addKalaLista(kala);
			
		}
		
	} while( valinta.equals("k") && !valinta.equals("e"));
		
		List<Kala> kalaLista = kalastaja.getKalat();
		System.out.print("Kalastajan nimi: "+kalastaja.getNimi());
		System.out.print(" Saalis:");
		for (int i=0; i< kalaLista.size(); i++){
			Kala kalalista = kalaLista.get(i);
			System.out.print(kalalista.toString());}
		
	}

}
