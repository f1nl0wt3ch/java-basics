import java.util.Scanner;


public class OpiskelijaTutkintoOhjelma {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Scanner inputnew = new Scanner(System.in);
		Opiskelija opiskelija = new Opiskelija();
		
	   // yhteyssuhteet
		System.out.print("Anna opiskelijanumero: ");
		String numero = input.next();
		opiskelija.setNumero(numero);
		System.out.print("Anna opiskelijan nimi: ");
		String nimi =inputnew.nextLine();
		opiskelija.setNimi(nimi);
		System.out.print("Annan opiskelijan kotikunta: ");
		String kotikunta = inputnew.nextLine();
		
		
		
		// kompositiot
		System.out.print("Annan tutkinnon nimi: ");
		String tutkintoNimi = inputnew.nextLine();
		System.out.print("Anna tutkinnon suuntaus: ");
		String suuntaus = inputnew.nextLine();
		System.out.print("Anna tutkinnon tavoitteena oleva valmistumisvuosi: ");
		int tavoiteVuosi = inputnew.nextInt();
		Tutkinto tutkinto = new Tutkinto (tutkintoNimi, suuntaus, tavoiteVuosi);
		opiskelija.setTutkinto(tutkinto);
		
		System.out.print("Opiskelija "+ opiskelija.getNimi()+""+ opiskelija.getTutkinto().getTilanne(tavoiteVuosi)+ " tutkintoa "+opiskelija.getTutkinto().getTutkintoNimi());

	}

}
