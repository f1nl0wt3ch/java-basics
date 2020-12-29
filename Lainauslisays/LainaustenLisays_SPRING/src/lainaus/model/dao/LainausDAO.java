package lainaus.model.dao;

import java.util.List;

import lainaus.model.Lainaus;

public interface LainausDAO {
	
	public abstract List<Lainaus> haeKaikki();
	public abstract  Lainaus etsi(int id) ;
	//public abstract Lainaus puraLista (List<Lainaus> lista);
}
