
public class opiskelija 
{
// tieitokuvaus eli attribuutit
	private int opNro;
	private String nimi;
	private double opintopisteet;
	
// luontimethodit eli konstruktorit
// parametrton
	public opiskelija()
	{
		// alustuslauseet
		this.nimi =""; // this tarkoittaa oliota itseŠŠn
		this.opNro =0; // on jo muutenkin oletusarvona
		this.opintopisteet = 0;
	}
	
	// parametrillinen luontimetodi
	
	public opiskelija(int numero, String nimi, double pisteet)
	{
		this.opNro = numero;
		this.nimi = nimi;
		this.opintopisteet = pisteet;
	}
	public String toString()
	{
		return "opiskelijanumero: " + this.opNro +
		       " nimi: " + this.nimi + " pisteet: "+ this.opintopisteet;
	}
	public void setOpNro(int opNro)
	
	{
		// parametrin tarkistus + arvon vienti kohdalleen
		this.opNro = opNro;
		
	}
	public int getOpNro()
	
	{
		return this.opNro;
	}
	
	public void setNimi(String nimi)
	{
		this.nimi = nimi;
	}
	public String getNimi()
	{
		return this.nimi;
	}
	
	public void opintoJaksonSuoritus(int pisteet)
	{
		this.opintopisteet = this.opintopisteet + pisteet;
	}
	public double getOpintoJaksonSuoritus()
	{
		return this.opintopisteet;
	}
}
