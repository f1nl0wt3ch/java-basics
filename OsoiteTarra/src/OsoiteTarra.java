import java.util.Scanner;


public class OsoiteTarra 
{

	public static void main(String[] args) 
	{
		/*) Tee ohjelma OsoiteTarra,joka kysyy käyttäjältä etu-ja sukunimen, katuosoitteen, 
		 * postinumeron ja postitoimipaikka. Ohjelma näyttää kyseiset tiedot kolmelle riville 
		 * samaan tapaan kuin osoitetarroissa. Näytä käyttäjän antamat tiedot siten, ettei 
		 * tekstien alussa ja lopussa ole turhia välilyöntejä. Etu- ja sukunimi sekä katuosoite 
		 * alkavat suurella kirjaimella, muut merkit ovat pieniä. Postitoimipaikka näytetään
		 *  suurilla kirjaimilla.
Alla on esimerkki, miten etunimi voidaan muuntaa haluttuun muotoon
String etunimi = "hEiKki";
String ekaKirjain = etunimi.substring(0,1).toUpperCase(); 
String loppuNimi = etunimi.substring(1).toLowerCase(); etunimi = ekaKirjain + loppuNimi;
￼Esimerkki ohjelmasta
         Anna etu- ja sukunimi: maTTi          maJAVA
         Anna katuosoite:       kATu 11
         Anna postinumero ja postitoimipaikka: 12345
         Matti Majava
         Katu 11
         12345 MAJAVALA*/
		Scanner input = new Scanner(System.in);
        String etu ,sukunimi,katuosoite, postitoimipaikka;
        String postinumero;
        System.out.print("Anna etu- ja sukunimi: ");
        etu=input.next();
        String etu1=etu.substring(0,1).toUpperCase();
        String etu2=etu.substring(1).toLowerCase();
        etu = etu1+etu2;
        etu = etu.trim();
        sukunimi=input.next();
        String sukunimi1=sukunimi.substring(0,1).toUpperCase();
        String sukunimi2=sukunimi.substring(1).toLowerCase();
        sukunimi=sukunimi1 + sukunimi2;
        sukunimi=sukunimi.trim();
        input.nextLine();
        System.out.print("Anna katuosoite: ");
        katuosoite=input.nextLine();
        String katu1=katuosoite.substring(0,1).toUpperCase();
        String katu2=katuosoite.substring(1).toLowerCase();
        katuosoite=katu1+katu2;
        katuosoite=katuosoite.trim();
        System.out.print("Anna postinumero ja postitoimipaikka: ");
        postinumero=input.next();
        postitoimipaikka=input.next();
        postitoimipaikka=postitoimipaikka.toUpperCase();
        postitoimipaikka=postitoimipaikka.trim();
        System.out.print(etu+"\t"+sukunimi+"\r"+katuosoite+"\r"+postinumero+"\t"+postitoimipaikka);
        
	}

}
