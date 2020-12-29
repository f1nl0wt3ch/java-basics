
public class Henkilo {
	
	private String nimi;
	private String osoite;
	
	public Henkilo()
	{
		nimi ="";
		osoite ="";
	}
	public Henkilo (String nimi, String osoite)
	
	{
		this.nimi= nimi;
		this.osoite = osoite;
	}
	public void setNimi(String nimi) 
	{
		this.nimi=nimi;
		
	}
	public String getNimi()
	{
		return this.nimi;
	}
	
	public void setOsoite( String osoite)
	{
		this.osoite= osoite;
	}
	
	public String getOsoite()
	{
		return this.osoite;
	}
   public String ToString()
   
   {
	   return "Nimi: "+ this.nimi + " Osoite "+ this.osoite;
   }
}
