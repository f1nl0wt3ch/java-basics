import java.util.Scanner;


public class HenkiloHallinta {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Henkilo henkilo = new Henkilo();
		int syntymavuosi;
		System.out.print("Anna sinun syntymävuosi: ");
		syntymavuosi = input.nextInt();
		henkilo.setSyntymavuosi(syntymavuosi);
		System.out.print("Sinun ikä on: "+ henkilo.getIka()+ " vuotias");
		

	}

}
