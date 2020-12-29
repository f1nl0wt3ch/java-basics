import java.text.DecimalFormat;
import java.util.Scanner;


public class HenkiloAutoOhjelma {

	public static void main(String[] args) {
		Henkilo henkilo = new Henkilo();
		Auto auto = new Auto();
		Scanner input = new Scanner(System.in);
		DecimalFormat fm = new DecimalFormat("0.00");
        System.out.print("Anna merkki: ");
        String merkki = input.next();
        auto.setMerkki(merkki);
        System.out.print("Anna malli: ");
        String malli = input.next();
        auto.setMalli(malli);
        System.out.print("Anna rekisterinumero: ");
        String reknumero = input.next();
        System.out.print("Anna vuosimalli: ");
        int vuosimalli = input.nextInt();
        
        henkilo.setHenkiloAuto(auto);
        
       Scanner input1 = new Scanner(System.in);
        System.out.print("Anna nimi: ");
        String nimi = input1.nextLine();
        
        System.out.print("Anna osoite: ");
        String osoite = input.next();
        
        
        henkilo.setNimi(nimi);
        henkilo.setOsoite(osoite);
        
	System.out.print("Anna pituus metreinä: ");
	double pituus = input.nextDouble();
	
	System.out.print("Anna paino kiloina: ");
        int paino =input.nextInt();
        
        Koko koko = new Koko(pituus, paino);
        henkilo.setKoko(koko);
		//System.out.println(henkilo.ToString());
        System.out.println("Nimi: "+ henkilo.getNimi());
        System.out.println("Osoite: "+ henkilo.getOsoite());
        System.out.println("Auto: "+ auto.getMerkki() +""+ auto.getMalli());
		System.out.println("Pituus: "+ fm.format(henkilo.getKoko().getPituus()));
		System.out.println("Painoindeksi: "+ henkilo.getKoko().getPainoindeksi());

}
}