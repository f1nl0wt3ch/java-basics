
public class Sijoitus {
	private String nimi;
	private int arvo;
	
	public Sijoitus(){
		nimi="";
		arvo =0;
	}
	public Sijoitus(String nimi, int arvo){
		this.nimi= nimi;
		this.arvo = arvo;
	}
	public String getNimi(){
		return nimi;
	}
	public void setNimi(String nimi){
		this.nimi = nimi;
	}
    public int getArvo(){
    	return arvo;
    }
    public void setArvo(int arvo){
    	this.arvo = arvo;
    }
    public String toString(){
    	return this.nimi+ " "+ this.arvo+ " euroa";
    }
}
