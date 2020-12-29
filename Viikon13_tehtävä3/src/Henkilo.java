import java.text.DecimalFormat;




public class Henkilo {
	
	
	private String nimi;
	private String osoite;
	private double pituus;
	private int paino;
	
	public Henkilo(){
		nimi= null;
		osoite = null;
		pituus = 0.00;
		paino = 0;
	}
	public Henkilo(String nimi, String osoite, double pituus, int paino){
		this.nimi = nimi;
		this.osoite = osoite;
		this.pituus = pituus;
		this.paino = paino;
	}
    
	public String getNimi(){
		return this.nimi;
	}
	public String getOsoite(){
		return this.osoite;
	}
	public double getPituus(){
		return this.pituus;
	}
	public int getPaino(){
		return this.paino;
	}
	
	public double getPainodeksi(){
		double painoindeksi= paino/(pituus*pituus);
		return painoindeksi;
	}
	
	public void setNimi(String nimi){
		this.nimi = nimi;
	}
	public void setOsoite(String osoite){
		this.osoite = osoite;
	}
	public void setPituus(double pituus){
		this.pituus = pituus;
	}
	public void setPaino(int paino){
		this.paino = paino;
	}
	public String toString(){
		DecimalFormat fm = new DecimalFormat("0.00");
        
		return "Nimi: "+this.nimi+"\nOsoite: "+this.osoite+"\nPituus: "+fm.format(this.pituus);
	}
}
