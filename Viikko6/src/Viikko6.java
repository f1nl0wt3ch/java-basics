import java.util.Scanner;


public class Viikko6 
{

	public static void main(String[] args) 
	{
		// esittely taulukko
		final int MAX = 20;
		String [] nimet = new String[MAX];
		String nimiStr;
		int lkm = 0;
		Scanner input = new Scanner(System.in);
		// pyyttaminen
		while (lkm <= 20 && nimiStr.length() != 0 ) { 
			nimet[lkm] = nimiStr;
			lkm = lkm + 1;
			System.out.print("Anna nimi: ");
			 nimiStr=input.next();
		                                            };
		    System.out.print("Nimet ovat aakkosjŠrjestyksessŠ"+ nimet[lkm]);
	}

}
