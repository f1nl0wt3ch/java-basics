package fi.softala.jee.demo.d25.bean;

public class Kayttaja {
	private String email;
	private String salasana;
	private String suola;
	
	public Kayttaja() {
		super();
	}
	
	public Kayttaja(String email, String salasana, String suola) {
		super();
		this.email = email;
		this.salasana = salasana;
		this.suola = suola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	public String getSuola() {
		return suola;
	}

	public void setSuola(String suola) {
		this.suola = suola;
	}

	@Override
	public String toString() {
		return "Kayttaja [email=" + email + ", salasana=" + salasana
				+ ", suola=" + suola + "]";
	}
}
