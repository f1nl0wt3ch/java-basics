
public class Kala {
	private String nimi;
	private double paino;
	private double pituus;
	
	public Kala(){
		nimi ="";
		paino = 0.00;
		pituus = 0.00;
	}
   public Kala(String nimi, double paino, double pituus){
	   this.nimi = nimi;
	   this.paino = paino;
	   this.pituus = pituus;
   }
   public String getNimi(){
	   return this.nimi;
   }
   public double getPaino(){
	   return this.paino;
   }
   public double getPituus(){
	   return this.pituus;
   }
   public void setNimi(String nimi){
	   this.nimi = nimi;
	   
   }
   public void setPaino(double paino){
	   this.paino = paino;
   }
   public void setPituus(double pituus){
	   this.pituus = pituus;
   }
   public String toString(){
	   return "\n"+this.nimi+" "+this.paino+"kg"+" "+this.pituus+"cm";
   }
}
