
public class TuoteOhjelma {

	public static void main(String[] args) 
	{
		Tuote tuote = new Tuote();
		tuote.setHinta(23.56);
		tuote.setNimi("Saha");
		tuote.setNumero(200);
		
		tuote.getNumero();
		tuote.getNimi();
		tuote.getHinta();
		
		Tuote tuote2 = new Tuote(300,"Vasara", 13.50);
		
		System.out.print(tuote.toString());
		System.out.print("\n\n"+tuote2.toString());

	}

}
