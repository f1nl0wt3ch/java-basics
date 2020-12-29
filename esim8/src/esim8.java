import java.text.DecimalFormat;
import java.util.Scanner;


public class esim8 
{
/*Käyttäjän tarkoituksena on maalata huone. Tee ohjelma, joka kertoo, paljonko maalia on ostettava. Ohjelma kysyy huoneen leveyden, 
 * pituuden ja korkeuden sekä paljonko litralla maalia saadaan maalattua. Ohjelma kertoo tämän jälkeen maalin tarpeen litroina.
 *  Muotoile vastaus kahdella desimaalilla.
Esimerkiksi huoneen leveys on 3.2 metriä, pituus on 3.0 metriä ja korkeus 2.5 metriä. Litralla maalia saadaan maalattua 7.0 neliötä.
 Maalia tarvitaan koko huoneen maalaamiseen 4.43 l ((leveys + leveys + pituus + pituus) * korkeus / litralla).*/
	public static void main(String[] args) 
	{
		// kavion esittely
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
		// muuttujien esittely
		double  leveys, tarvimalit, korkeus, pituus, litralla = 7.0;
		// pyytaminen
		System.out.print("Huoneen leveys on ");
		leveys=input.nextDouble();
		System.out.print("Huoneen pituus on ");
		pituus=input.nextDouble();
		System.out.print("Huoneen korkeus on ");
		korkeus=input.nextDouble();
		// laskenta
		tarvimalit = (leveys + leveys + pituus + pituus)*korkeus / litralla;
		// tulostaminen
		System.out.print("Maalia tarvitaan koko huoneen maalaamiseen " + fm.format(tarvimalit));
		

	}

}
