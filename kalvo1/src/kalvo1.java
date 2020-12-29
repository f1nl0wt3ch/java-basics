import java.text.DecimalFormat;
import java.util.Scanner;


public class kalvo1 {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int luku1, luku2, tulo, vastaus;
		// Kertoo, onko käyttäjä antanut oikeaa vastausta
		// Alkuarvona on epätosi (false)
		boolean väärin = true;

		// Arvotaan luvut
		luku1 = (int) (Math.random() * 9) + 1;
		luku2 = (int) (Math.random() * 9) + 1;
		tulo = luku1 * luku2;

		do {
			System.out.print(luku1 + " * " + luku2 + " = ");
			vastaus = input.nextInt();
			if (vastaus == tulo) {
				System.out.println("Oikein");
				// Vastaus oli oikein, joten laitetaan oikein-muuttajaan arvo
				// tosi (true)
				väärin = false;
			} else {
				System.out.println("Väärin");
			}
		} while (väärin == false); // Silmukkaa toistetaan niin kauan kuin
									// oikein on epätosi (false) eli käyttäjä ei
									// ole antanut oikeaa vastausta
		
	}

}
