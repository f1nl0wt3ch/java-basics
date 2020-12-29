import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
      

public class KomenttiOhjelma {
	
	List<String> KomLista = new ArrayList<String>();
	public void LisaKom(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Anna kommentti: ");
		String kom = input.nextLine();
		
		KomLista.add(kom);
	}
	
	
	public void NaytaKomLista(){
		
		for (int i=0; i<KomLista.size(); i++ ) {
			System.out.println(KomLista.get(i));
		}
		
	}
	
	public void PoistaKomLista(){
		Scanner input = new Scanner(System.in);
		System.out.print("Monesko kommentti poistetaan: ");
		int i = input.nextInt();
		
		KomLista.remove(i-1);
		
		System.out.print("Kommentti paikalla "+(i-1)+" on poistettu listasta");
	}

	public static void main(String[] args) 
	{
		KomenttiOhjelma ohjelma = new KomenttiOhjelma();
		Scanner input = new Scanner(System.in);
		int syote;
		
		do {
		System.out.println("1 = Lisää kommentti");
		System.out.println("2 = Listaa kommentit");
		System.out.println("3 = Poista kommentti");
		System.out.println("0 = Lopeta");
		System.out.print("Anna valintasi: ");
		syote = input.nextInt();
		
switch (syote) {
		
		case 1: ohjelma.LisaKom();
				break;
			
		case 2: ohjelma.NaytaKomLista();
		        break;
			
		case 3: ohjelma.PoistaKomLista();
				break;
			
		case 0: break;
		}

	} while (syote != 0);

		
}
	
}
