import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class AutoOhjelma {

	public static void main(String[] args) 
	
	{
		Scanner input = new Scanner(System.in);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		int nykyvuosi = Integer.parseInt(dateFormat.format(date));
		
		System.out.print("Anna merkki: ");
		String merkki = input.next();
		System.out.print("Anna malli: ");
		String malli = input.next();
		System.out.print("Anna rekisterinumero: ");
		String reknumero = input.next();
		System.out.print("Anna vuosimalli: ");
		int vuosimalli = input.nextInt();
		
		Auto auto = new Auto();
		auto.setMerkki(merkki);
		auto.setMalli(malli);
		auto.setReknumero(reknumero);
		auto.setVuosimalli(vuosimalli);
		
		auto.getMerkki();
		auto.getMalli();
		auto.getReknumero();
		auto.getVuosimalli();
		
		System.out.print(auto.toString());
		System.out.print("\nAuton ikä on: "+ auto.getIka(nykyvuosi));

	}

}
