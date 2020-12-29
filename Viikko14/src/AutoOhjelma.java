
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AutoOhjelma {

	public static void main(String[] args) {
		Auto auto = new Auto();
		
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		
		System.out.print("Anna merkki: ");
        String merkki = input.next();
        auto.setMerkki(merkki);
        System.out.print("Anna malli: ");
        String malli = input.next();
        auto.setMalli(malli);
        System.out.print("Anna rekisterinumero: ");
        String reknumero = input.next();
        auto.setReknumero(reknumero);
        System.out.print("Anna vuosimalli: ");
        int vuosimalli = input.nextInt();
        auto.setVuosimalli(vuosimalli);
        String nimi, kuvaus;
        
        do {
        	System.out.print("Anna lisävarusteen nimi (LOPPU lopettaa): ");
        	nimi = input.next();
        	if ( !nimi.equals("LOPPU")){
        	System.out.print("Anna lisävarusteen kuvaus: ");
        	kuvaus = input1.nextLine();
        	Lisavaruste lisavaruste = new Lisavaruste(nimi, kuvaus);
        	auto.addLisavarusteLista(lisavaruste);}
        	else {};
        } while (!nimi.equals("LOPPU") );
        List<Lisavaruste> varusteLista = auto.getLisavarusteLista();
        System.out.print(auto.toString());
        System.out.print("\nLisävarusteet: ");
        for (int i=0; i<varusteLista.size(); i++){
        	Lisavaruste varustelista = varusteLista.get(i);
        	System.out.print(varustelista.toString());
        }
	}

}
