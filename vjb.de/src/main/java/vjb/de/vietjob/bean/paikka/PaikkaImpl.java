package vjb.de.vietjob.bean.paikka;

public class PaikkaImpl implements Paikka {
      private int id;
      private String kaupunki;
      private String maa;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKaupunki() {
		return kaupunki;
	}
	public void setKaupunki(String kaupunki) {
		this.kaupunki = kaupunki;
	}
	public String getMaa() {
		return maa;
	}
	public void setMaa(String maa) {
		this.maa = maa;
	}
      
      
}
