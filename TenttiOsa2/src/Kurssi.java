
public class Kurssi {
	private String nimi;
	private int opintopiste;
	public Kurssi(){
		nimi = "";
		opintopiste=0;
	}
	public Kurssi(String nimi, int opintopiste){
		this.nimi = nimi;
		this.opintopiste= opintopiste;
	}
	public String getNimi(){
		return nimi;
	}
	public void setNimi(String nimi){
		this.nimi= nimi;
	}
	public int getOpintoPiste(){
		return opintopiste;
	}
	public void setOpintoPiste(int opintopiste){
		this.opintopiste = opintopiste;
	}
	public String toString(){
		return nimi + " ("+opintopiste+"op)";
	}

}
