
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutolistaSovellus {
	        List <Auto> autot = new ArrayList<Auto>(); 
	        Lisavaruste lisavaruste;
	        Auto auto;
	        List<Lisavaruste> list;
	        
	        
	private void lisaaAuto(){
		auto = new Auto();
		String merkki, malli, reknumero;
		 int vuosimalli;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Anna merkki: ");
        merkki = input.next();
        auto.setMerkki(merkki);
        System.out.print("Anna malli: ");
        malli = input.next();
        auto.setMalli(malli);
        System.out.print("Anna rekisterinumero: ");
        reknumero = input.next();
        auto.setReknumero(reknumero);
        System.out.print("Anna vuosimalli: ");
        vuosimalli = input.nextInt();
       auto.setVuosimalli(vuosimalli);
        
       autot.add(auto);

        
        }
		
        private void lisaaVaruste(){
		
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		System.out.print("Anna rekisterinumero: ");
		String reknumero = input.next();
		String nimi, kuvaus;
		if (reknumero.equals(auto.getReknumero())){
			
			 do {
		        	System.out.print("Anna lisävarusteen nimi (LOPPU lopettaa): ");
		            nimi = input.next();
		        	if ( !nimi.equals("LOPPU")){
		        	System.out.print("Anna lisävarusteen kuvaus: ");
		        	kuvaus = input1.nextLine();
		         	lisavaruste = new Lisavaruste(nimi, kuvaus);
		         	
		        	auto.addLisavarusteLista(lisavaruste);
		             
		        	list = auto.getLisavarusteLista();
		        	
		        	}
		        	else {};
		        } while (!nimi.equals("LOPPU") );
			
		}
		else {System.out.print("ei löytynyt rekisterin numero");}
	}
	
	private void listaaAutot( ){
		
		for (int i=0; i< autot.size(); i++){
			auto = autot.get(i);
			System.out.print(auto.toString());
			
			if (auto.getLisavarusteLista().size() != 0) {
				for (int j= 0; j < list.size(); j++) {
				        lisavaruste = list.get(j);
					    System.out.print(lisavaruste.toString()+" ");
				}
			}
			else {}
			
			}
		
					
	}	
	public static void main(String[] args) {
		
		AutolistaSovellus sovellus = new AutolistaSovellus();
		
		Scanner input = new Scanner(System.in);
	     int syote;
		do {
			System.out.print("\n1 = Lisää auto");
			System.out.print("\n2 = Listaa autot");
			System.out.print("\n3 = Lisää autolle lisävaruste");
			System.out.print("\n0 = Lopeta\n");
			System.out.print("\nAnna valintasi: ");
			syote = input.nextInt();
		
		switch (syote) {
		                 case 1: sovellus.lisaaAuto();
		                 
		                         break;
		                	 
		                 case 2: sovellus.listaaAutot();
		                         break;
		                	 
		                 case 3: sovellus.lisaaVaruste();
		                         break;
		                	 
		                 case 0: break;
		
		                }
		
		}  while (syote != 0);
		
	}

}
