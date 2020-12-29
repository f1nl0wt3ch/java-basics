package lainaus.model;

public interface Kirja {
	
	public abstract void setIsbn(String isbn);
	public abstract void setNimi(String nimi);
	public abstract void setKirjoittaja(String kirjoittaja);
	public abstract void setPainos(int painos);
	public abstract void setKustantaja(String kustantaja);

	public abstract String toString();
	
	public abstract  String getIsbn() ;
	public abstract String getNimi() ;
	public abstract String getKirjoittaja() ;
	public abstract int getPainos();
	public abstract String getKustantaja();
}
