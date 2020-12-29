import java.text.DecimalFormat;
import java.util.Scanner;


public class LainaOhjelma {

	public static void main(String[] args) 
	{
 Scanner input = new Scanner(System.in);
 DecimalFormat df = new DecimalFormat("0.00");
 Laina laina = new Laina();
 System.out.print("Anna lainan määrä: ");
 double maara = input.nextDouble();
 System.out.print("Anna korko: ");
 double korko= input.nextDouble();
 System.out.print("Anna lyhennyksen määrä: ");
 double lyhennys = input.nextDouble();
 laina.setMaara(maara);
 laina.setKorko(korko);
 laina.setLyhennys(lyhennys);
 laina.setKulut();
 df.format(laina.getMaara());
 df.format(laina.getKorko());
 df.format(laina.getLyhennys());
 laina.getKulut();
 /*double kuukausiera = laina.getKuukausiEra(maara, korko, lyhennys);
 double kuukausikorko = laina.getKuukausiKorko(maara, korko);*/
 System.out.print(laina.toString());
 //System.out.print("\n"+kuukausiera+ "\n"+kuukausikorko);
 
 

	}

}
