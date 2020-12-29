import java.util.Scanner;


public class KayttorajaOhjelma {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
       System.out.print("Anna verkkoraja: ");
       double verkkoraja = input.nextDouble();
       System.out.print("Anna nostoraja: ");
       double nostoraja = input.nextDouble();
       Kayttoraja kaytto = new Kayttoraja();
       kaytto.setVerkko(verkkoraja);
       kaytto.setNosto(nostoraja);
       kaytto.getVerkko();
       kaytto.getNosto();
       System.out.print(kaytto.toString());
       
	}

}
