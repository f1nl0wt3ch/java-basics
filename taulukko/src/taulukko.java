import java.util.Scanner;


public class taulukko 
{

	public static void main(String[] args) 
	
	{   Scanner input = new Scanner(System.in);
		int [] luvut; // kokonaislukutaulukko esittely
		// voisi my�s  antaa jo heti arvot:
		int [] uudetluvut = {34,500,2,8};
		// taulukko luonti eli tilanvaraus 10:lle kokonaisluvulle
		luvut = new int[10];
		// automaatinen taulukon t�ytt�minen
		for (int i=0; i< luvut.length; i++)
		{
		    luvut[i]= i+ 5*2;
		    
		}
		
		// taulukko tulostus
		for (int i=0;i< luvut.length; i++)
		{
			System.out.println(luvut[i]);
		}
		
		String [] henkilot = new String[5];
		for (int i=0; i < henkilot.length; i++)
		{
		System.out.println("Anna ty�ntekij�n nimi: ");
		String nimi = input.nextLine();
		   if (nimi.length()>0)
		   {
			 henkilot[i]  =nimi;
		   }
		}
		// etsi henkilot joiden etunimi alkkaa joko isolla tai pikku p:ll� 
		String yksiNimi;
		char ekaMerkki;
		for (int i= 0; i< henkilot.length;i++)
		{
			// katso onko eka kirjain p tai P
			yksiNimi = henkilot[i];
			ekaMerkki=yksiNimi.charAt(0);
			System.out.println("p-kirjaimella alkavat ty�ntekij�t: ");
		
//			if (ekaMerkki == 'p' || ekaMerkki == 'P' )
			{
				System.out.println(henkilot[i]);
			}
		}
	}

}
