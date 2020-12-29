

public class Tili {
	/*
	 * Tee Tili-luokka (kalvoesimerkkinä). Tili-luokalla on attribuutit numero
	 * (merkkijono) ja saldo (desimaaliluku) ja staattinen attribuutti
	 * korkoprosentti (desimaaliluku, alkuarvona 0.2). Tee luokkaan a.
	 * parametriton konstruktori ja parametrillinen konstruktori b. set- ja
	 * get-metodit c. toString-metodi d. otto- ja pano-metodit. otto-metodi
	 * palauttaa true, jos otto onnistuu muuten false e. staattiset set- ja
	 * get-metodit korkoprosentille
	 */

	// Staattinen attribuutti eli luokan kaikille olioille yhteinen attribuutti (luokkaattribuutti)
	private static double korkoprosentti = 0.2;

	// Jokaisen olion omat attribuutit
	private String numero;
	private double saldo;

	// Parametriton konstruktori
	// Tili tili1 = new Tili();
	public Tili() {
		numero = "0";
		saldo = 0.0;
	}

	// Parametrillinen konstruktori eli olio luodaan halutuilla tiedoilla
 	// Tili tili2 = new Tili("FI12 1234 5678 90", 200.0);
	public Tili(String numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	// get-metodi palauttaa attribuutin arvon
	// system.out.println("Saldo: " + tili2.getSaldo());
	public double getSaldo() {
		return saldo;
	}

	// Tätä metodia ei olisi järkevää toteuttaa luokkaan!
	// Oikeasti tilin saldoa ei voida muuttaa
	// tili2.setSaldo(1000.0);
	public void setSaldo(double uusiSaldo) {
		saldo = uusiSaldo;
	}

	// Tätä metodia ei olisi järkevää toteuttaa luokkaan!
	// Oikeasti tilin numeroa ei voida muuttaa
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void pano(double maara) {
		saldo = saldo + maara;
	}

	public boolean otto(double maara) {
		if (saldo >= maara) {
			saldo = saldo - maara;
			return true;
		} else {
			return false;
		}
	}

	// Staattisella metodilla käsitellään staattista attribuuttia, metodia kutsutaan luokalla (Tili)
	// system.out.println("Korko: " + Tili.getKorkoprosentti());
	public static double getKorkoprosentti() {
		return korkoprosentti;
	}

	public static void setKorkoprosentti(double korkoprosentti) {
		Tili.korkoprosentti = korkoprosentti;
	}

	// Metodi palauttaa olion tiedot yhtenä merkkijonona
	public String toString() {
		return "numero=" + numero + ", saldo=" + saldo + ", korkoprosentti="
				+ korkoprosentti;
	}
}