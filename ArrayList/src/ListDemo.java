import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// ohjelma lukee henkilöiden nimiä ja vie me ArrayListiin


public class ListDemo {
	
	

	public static void main(String[] args) 
	
	{
		List <String> nimet = new ArrayList<String>();
			String nimi = null;
			Scanner input = new Scanner(System.in);
			do {
				System.out.print("Kirjoita nimiä: ");
				nimi = input.nextLine();
				if (nimi.length() !=0)
				        nimet.add(nimi); // ArrayListiin lisääminen
			} while (nimi.length() != 0);
			
			for (int i=0; i < nimet.size(); i++)
			{
				System.out.println(nimet.get(i));
			}
			// arvotaan yksi onnellinen
			int voittaja = (int) ( Math.random()* nimet.size() );// antaa kokonaisluvun
			System.out.println ("Voittaja: " + nimet.get(voittaja));
		    nimet.remove(voittaja); //Poistaa yhden ArrayLististä
	}

}
