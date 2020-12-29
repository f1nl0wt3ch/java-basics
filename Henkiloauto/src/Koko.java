

public class Koko {
	private double pituus;
	private int paino;
	
	public Koko(){
		pituus = 0.0;
		paino = 0;
	}
	public Koko(double pituus, int paino){
		this.pituus = pituus;
		this.paino = paino;
	}
	public double getPituus(){
		return this.pituus;
	}
	public int getPaino(){
		return this.paino;
	}
	public void setPituus(double pituus){
		this.pituus = pituus;
	}
	public void setPaino(int paino){
		this.paino = paino;
	}
	public double getPainoindeksi(){
		double painoindeksi;
		return painoindeksi=paino/(pituus*pituus) ;
	}
	public String toString(){
		return "Pituus on "+ this.pituus + "Paino on "+ this.paino;
	}

}

