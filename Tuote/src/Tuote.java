
public class Tuote {
	private int numero;
	private String nimi;
	private double hinta;
	
	public Tuote()
	{
		numero =0;
		nimi ="";
		hinta =0.0;
	}
   public Tuote(int numero, String nimi, double hinta)
   {
	   this.numero = numero;
	   this.nimi = nimi;
	   this.hinta = hinta;
   }
   public int getNumero()
   {
	   return this.numero;
   }
   public String getNimi()
   {
	   return this.nimi;
   }
   public double getHinta()
   {
	   return this.hinta;
   }
   public void setNumero(int numero)
   {
	   this.numero = numero;
   }
   public void setNimi(String nimi)
   {
	   this.nimi = nimi;
   }
   public void setHinta(double hinta)
   {
	   this.hinta = hinta;
   }
   public String toString()
   {
	   return "Numero: "+this.numero+"\nNimi: "+this.nimi+"\nHinta: "+this.hinta;
   }
}
