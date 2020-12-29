import java.text.DecimalFormat;
import java.util.Scanner;


public class OhjelmaHallinta {
	

	public static void main(String[] args) {
		DecimalFormat fm = new DecimalFormat("0.0");
		Opiskelija ohjelma = new Opiskelija();
		Scanner input = new Scanner(System.in);
		Scanner inputnew = new Scanner(System.in);
		System.out.print("Anna opiskelijan nimi: ");
		String nimi = inputnew.nextLine();
		System.out.print("Annan opiskelijan hetu: ");
		String hetu = input.next();
		System.out.print("Annan opiskelijan aloitusvuosi: ");
		int aloitusvuosi=input.nextInt();
		ohjelma.setAloitusVuosi(aloitusvuosi);
		System.out.print("Annan opiskelijan opintopistemäärä: ");
		double opintopiste = input.nextDouble();
		ohjelma.setOpintoPiste(opintopiste);
		System.out.print("Opiskelijan opintojen keskimääräinen suoritusvauhti on "+ fm.format(ohjelma.getKeskimaarainen()) +" opintopistettä vuodessa");

	}
	

}
