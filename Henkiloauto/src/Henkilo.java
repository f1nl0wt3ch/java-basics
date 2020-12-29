
public class Henkilo {
	
	private String nimi;
	private String osoite;
	// yhteyssuhde
	private Auto henkiloauto;
	// kompositio
	private Koko koko;
	
	public Henkilo()
	{
		nimi ="";
		osoite ="";
		henkiloauto = null;
		koko = new Koko();
		
	}
	public Henkilo(String nimi, String osoite, Auto henkiloauto){
		this.nimi = nimi;
		this.osoite = osoite;
		this.henkiloauto = henkiloauto;
		this.koko = new Koko();
	}
	public Henkilo(String nimi, String osoite, Auto henkiloauto, Koko koko)
	{
		this.nimi = nimi;
		this.osoite = osoite;
		this.henkiloauto = henkiloauto;
		if (koko != null){
			this.koko = new Koko (koko.getPituus(), koko.getPaino());
		}
		else {
			this.koko = new Koko();
		}
	}
	// komposition get metodi
	public Koko getKoko(){
		Koko kokoKopio = new Koko(koko.getPituus(), koko.getPaino());
		return kokoKopio;
	}
	// kompositio set metodi
	public void setKoko(Koko koko){
		if (koko != null) {
			this.koko.setPituus(koko.getPituus());
			this.koko.setPaino(koko.getPaino());
		}
	}
	
	public Henkilo (String nimi, String osoite)
	
	{
		
		henkiloauto = null;
		
	}
	
	public void setNimi(String nimi)
	{this.nimi = nimi;}
	public void setOsoite(String osoite)
	{this.osoite = osoite;}
	public String getNimi()
	{return this.nimi;}
	public String getOsoite()
	{return this.osoite;}
	
    public void setHenkiloAuto(Auto henkiloauto)
    {
    	this.henkiloauto = henkiloauto;
    }
   public Auto getHenkiloAuto()
   {
	   return henkiloauto;
   }
	
public String ToString()
   
   {
	   String palautus="";
	   
	   if (henkiloauto != null)
	   { palautus = "Nimi: "+ this.nimi +"\nOsoite: "+ this.osoite+"\nAuto: "+ henkiloauto.toString();}
	   else {palautus = "Nimi: "+ this.nimi +"\nOsoite: "+ this.osoite; }
	 
   return palautus;
}
}