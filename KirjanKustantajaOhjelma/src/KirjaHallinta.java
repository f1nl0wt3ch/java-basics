import java.util.Scanner;
public class KirjaHallinta {
// case 1
private Kustantaja kustantaja = null;
private Kirja kirja = null;


private void lisaKustantaja() {
	
	if (kirja != null) { 
	         kustantaja.getKnimi();
	         kustantaja.getOsoite();
	         kustantaja.getPuhelin();
	                kirja.setKustantiedot(kustantaja);}
	
	else {System.out.print("Kirjaa ei ole");}
	
	
}
private void muutaKirja() {
	Scanner input = new Scanner(System.in);

	// Jos kirja on luotu
	if (kirja != null) { kirja = new Kirja();
		System.out.print("Anna kirjan nimi: ");
	    String nimi = input.next();
		kirja.setNimi(nimi);
		System.out.print("Anna kirjan isbn: ");
		String isbn = input.nextLine();
		kirja.setIsbn(isbn);
		System.out.print("Anna kirjan hinta: ");
		double hinta = input.nextDouble();
		kirja.setHinta(hinta);
	} else {
		{ kirja = new Kirja();
			System.out.print("Anna kirjan nimi: ");
			String nimi = input.nextLine();
			kirja.setNimi(nimi);
			System.out.print("Anna kirjan isbn: ");
			String isbn = input.nextLine();
			kirja.setIsbn(isbn);
			System.out.print("Anna kirjan hinta: ");
			double hinta = input.nextDouble();
			kirja.setHinta(hinta);
			
			}
	}

}

public void naytaKirja()
{
	// Jos tuote on luotu
			if (kirja != null) {
				System.out.println("Nimi: " + kirja.getNimi());
				System.out.println("Isbn: " + kirja.getIsbn());
				System.out.println("Hinta: " + kirja.getHinta());
				         if( kustantaja == null) {	
				                                  System.out.println("Kustantaja: ");}
				         else {System.out.println("Kustantaja: "+ kirja.getKustantiedot().getKnimi() );}
					       
			}
			else {System.out.print("Kirjaa ei ole");}
			
}
public void muutaKustantaja () {
	
	Scanner input = new Scanner(System.in);
if( kirja != null) { kustantaja = new Kustantaja (); 
System.out.print("Anna kustantajan nimi: ");
String knimi = input.nextLine();
kustantaja.setKnimi(knimi);
System.out.print("Anna kustantajan osoite: ");
String osoite = input.nextLine();
kustantaja.setOsoite(osoite);
System.out.print("Anna kustantajan puhelin: ");
String puhelin = input.nextLine();
kustantaja.setPuhelin(puhelin); }
    
else { System.out.println("Kirjaa ei ole");

}
}


	



public static void main(String[] args)
{
KirjaHallinta hallinta = new KirjaHallinta();



Scanner input = new Scanner(System.in);
int syote;
do {
System.out.println("\n1 = Luo/muuta kustantaja");
System.out.println("2 = Luo/muuta kirja");
System.out.println("3 = Lisää kirjalle kustantaja");
System.out.println("4 = Näytä kirjan tiedot");
System.out.println("0 = lopetus");
System.out.print("Anna valintasi: ");
syote = input.nextInt();
switch (syote)
{
case 1: hallinta.muutaKustantaja();
        break;
case 2: hallinta.muutaKirja();
        break;
case 3: hallinta.lisaKustantaja();
        break;
case 4: hallinta.naytaKirja();
        break;
case 0: break;
}
} while (syote != 0);
}
}