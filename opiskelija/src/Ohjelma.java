
public class Ohjelma {

	public static void main(String[] args) 
	
	{
		//luodaan olio ja kutsumalla parametritonta luontifunktiota
		opiskelija Opiskelija = new opiskelija();
		
		System.out.println(Opiskelija.toString());

		//opiskelija uusiopiskelija = new opiskelija(100,"Heikki",34);
		
		Opiskelija = new opiskelija(100,"Heikki",34);
		System.out.println(Opiskelija.toString());

		// muuta nimeä
		Opiskelija.setNimi("Heikki H.");
		Opiskelija.opintoJaksonSuoritus(9);
		System.out.println(Opiskelija.toString());
	}

}
