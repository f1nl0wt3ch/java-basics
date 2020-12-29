import java.util.Scanner;


public class viikontunti5 
{

	public static void main(String[] args) 
	
	{
		Scanner input = new Scanner(System.in);
		String syoteStr;
		int syote;
		int lkm = 0;
		int summa = 0;
		do { 
		System.out.println("Anna arvostelu (0-5"+"), enter lopettaa: ");
		syoteStr = input.nextLine();
		if (syoteStr.matches("\\d+")) { syote = Integer.parseInt(syoteStr);
			if (syote >= 0 && syote <= 5) { lkm++;
			                                summa = summa + syote; }
			else {System.out.println("Arvostelu pitŠŠ olla numero 0-5");}
		}
		else {System.out.println("Antasi ei ole numeroa");}
		} while (syoteStr.length() != 0);
		double keskiarvo;
		keskiarvo = (double) summa / lkm;
		System.out.println("Keskiarvo on "+keskiarvo);

	}

}
