import java.util.Scanner;


public class VarastotietoOhjelma {

	public static void main(String[] args) 
	
	{
		Scanner input = new Scanner(System.in);
		Varastotieto varasto = new Varastotieto();
		System.out.print("Anna hylly: ");
		String hylly = input.nextLine();
		System.out.print("Anna lokerikko: ");
		int lokerikko = input.nextInt();
		varasto.setHylly(hylly);
		varasto.setLokerikko(lokerikko);
		varasto.getHylly();
		varasto.getLokerikko();
		System.out.print("\n"+varasto.toString());
		
	}

}
