package asiakas.model.dao;

import java.util.List;

import asiakas.model.Asiakas;



public interface AsiakasDAO {
	
	public abstract void talleta(Asiakas aiakas);

	public abstract Asiakas etsi(int numero);

	public abstract List<Asiakas> haeKaikki();

}
