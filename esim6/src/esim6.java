import java.text.DecimalFormat;
import java.util.Scanner;


public class esim6 
{/*Tee ohjelma, joka kysyy käyttäjän painon kiloina sekä pituuden metreinä, laskee ja näyttää painoindeksin. Painoindeksi lasketaan
painoindeksi = paino / (pituus * pituus)
Esimerkiksi jos paino on 80 ja pituus on 1,80, painoindeksi on 24.691358024691358.*/

	public static void main(String[] args) 
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.000000000000000");
		// muuttujien esittely
		int paino;
		double painodeksi, pituus;
		// pyytaaminen
		System.out.print("Anna paino: ");
		paino=input.nextInt();
		System.out.print("Anna pituus: ");
		pituus=input.nextDouble();
		// laskenta
		painodeksi = paino / (pituus*pituus);
		// tulostaaminen
		System.out.print("Painoindeksi on " + fm.format(painodeksi));

	}

}
