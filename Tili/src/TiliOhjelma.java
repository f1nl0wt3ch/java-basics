

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

		System.out.print("\nPanon m��r�: ");
		double maara = input.nextDouble();

		tili.pano(maara);
		System.out.println("Tilin saldo panon j�lkeen " + tili.getSaldo());

		System.out.print("\nOton m��r�: ");
		maara = input.nextDouble();

		if (tili.otto(maara)) {
			System.out.println("Tilin saldo oton j�lkeen " + tili.getSaldo());
		} else {
			System.out.println("Tilill� ei ole katetta");
		}

		System.out.println("\nTilinumero: " + tili.getNumero());
		System.out.println("Saldo: " + tili.getSaldo());
	}
}