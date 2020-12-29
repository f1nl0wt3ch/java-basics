package asiakas.model;

public class AsiakasImpl implements Asiakas{
	
	private int numero;
	private String etunimi;
	private String sukunimi;
	private String osoite;
	private Posti posti;
	
	
	public AsiakasImpl()
	{
		posti = new PostiImpl();
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = null;
		if (etunimi != null && etunimi.trim().length() > 0)
			this.etunimi = etunimi.trim();
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = null;
		if (sukunimi != null && sukunimi.trim().length() > 0)
			this.sukunimi = sukunimi.trim();
	}
	public String getOsoite() {
		return osoite;
	}
	public void setOsoite(String lahiosoite) {
		this.osoite = null;
		if (lahiosoite != null && lahiosoite.trim().length() > 0)
			this.osoite = lahiosoite.trim();
	}
	public Posti getPosti() {
		return posti;
	}
	public void setPosti(Posti posti) {
		this.posti = posti;
	}
	
	@Override
	public String toString() {
		String paluu =
				"AsiakasImpl [numero=" + numero + ", etunimi=" + etunimi
				+ ", sukunimi=" + sukunimi + ", lahiosoite=" + osoite;
		if (posti != null)
			paluu = paluu +  ", posti=" + posti + ", puhelin=";
		
		return paluu;
	}
	
	
	

}
