import java.util.Scanner;


public class HenkiloHallinta {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Henkilo henkilo = new Henkilo();
		int syntymavuosi;
		System.out.print("Anna sinun syntym�vuosi: ");
		syntymavuosi = input.nextInt();
		henkilo.setSyntymavuosi(syntymavuosi);
		System.out.print("Sinun ik� on: "+ henkilo.getIka()+ " vuotias");
		

	}

}
