
public class Pelaaja {

	private int pelinumero;
	private String nimi;
	private String pelipaikka;

	public Pelaaja() {
		pelinumero = 0;
		nimi = "";
		pelipaikka = "";
	}

	public Pelaaja(int pelinumero, String nimi, String pelipaikka) {
		this.pelinumero = pelinumero;
		this.nimi = nimi;
		this.pelipaikka = pelipaikka;
	}

	public int getPelinumero() {
		return pelinumero;
	}

	public void setPelinumero(int pelinumero) {
		this.pelinumero = pelinumero;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getPelipaikka() {
		return pelipaikka;
	}

	public void setPelipaikka(String pelipaikka) {
		this.pelipaikka = pelipaikka;
	}

	public String toString() {
		return "Pelinumero: " + this.pelinumero + "\nNimi: " + this.nimi + "\nPelipaikka: "
				+ this.pelipaikka;
	}

}