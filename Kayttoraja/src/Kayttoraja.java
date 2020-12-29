
public class Kayttoraja {
	private double verkkoraja;
	private double nostoraja;
	private final double arvon = 1000.0;
	
	public Kayttoraja()
	{
		verkkoraja = 0.0;
		nostoraja = 0.0;
	}
	public Kayttoraja(double verkkoraja, double nostoraja)
	{
		this.verkkoraja = verkkoraja;
		this.nostoraja = nostoraja;
	}
	public double getVerkko()
	{
		return this.verkkoraja;
	}
	public double getNosto()
	{
		return this.nostoraja;
		
	}
   public void setVerkko(double verkkoraja)
   {
	   this.verkkoraja = verkkoraja;
	  
   }
   public void setNosto(double nostoraja)
   {
	   this.nostoraja = nostoraja;
   }
   public String toString()
   {
	   return "Verkkoraja on: "+this.verkkoraja + "\nNostoraja on: "+this.nostoraja;
   }
}
