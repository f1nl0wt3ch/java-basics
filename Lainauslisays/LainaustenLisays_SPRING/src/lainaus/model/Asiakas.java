package lainaus.model;

import lainaus.model.Posti;

public interface Asiakas {
	public abstract int getNumero();

	public abstract void setNumero(int id);

	public abstract String getEtunimi();

	public abstract void setEtunimi(String etunimi);

	public abstract String getSukunimi();

	public abstract void setSukunimi(String sukunimi);

	public abstract String getOsoite();

	public abstract void setOsoite(String osoite);
	
	public abstract Posti getPosti();

	public abstract void setPosti(Posti posti);
	
	
	
	public abstract String toString();
	
}
