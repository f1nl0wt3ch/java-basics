
public class Lisavaruste {
	private String nimi;
	private String kuvaus;
	
	public Lisavaruste(){
		nimi="";
		kuvaus = "";
	}
	
	public Lisavaruste(String nimi, String kuvaus){
		this.nimi = nimi;
		this.kuvaus = kuvaus;
	}
	
	public String getNimi(){
		return nimi;
	}
    public String getKuvaus(){
    	return kuvaus;
    }
    public void setNimi(String nimi){
    	this.nimi = nimi;
    }
    public void setKuvaus(String kuvaus){
    	this.kuvaus = kuvaus;
    }
    public String toString(){
    	return this.nimi;
    }
}
