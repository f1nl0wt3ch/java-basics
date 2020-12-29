

import java.util.Scanner;

public class TiliOhjelma {

	public static void main(String[] args) {
		// Luodaan olio parametrittomalla konstruktorilla
		Tili tili = new Tili();

		Scanner input = new Scanner(System.in);

		System.out.print("Anna tilinnumero: ");
		String numero = input.nextLine();
		System.out.print("Anna alkusaldo: ");
		double saldo = input.nextDouble();

		// Muutetaan tietoja Tili-luokan set-metodeilla
		tili.setNumero(numero);
		tili.setSaldo(saldo);

		System.out.print("\nPanon määrä: ");
		double maara = input.nextDouble();

		tili.pano(maara);
		System.out.println("Tilin saldo panon jälkeen " + tili.getSaldo());

		System.out.print("\nOton määrä: ");
		maara = input.nextDouble();

		if (tili.otto(maara)) {
			System.out.println("Tilin saldo oton jälkeen " + tili.getSaldo());
		} else {
			System.out.println("Tilillä ei ole katetta");
		}

		System.out.println("\nTilinumero: " + tili.getNumero());
		System.out.println("Saldo: " + tili.getSaldo());
	}
}