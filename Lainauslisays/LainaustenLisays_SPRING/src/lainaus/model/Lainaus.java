package lainaus.model;

import java.util.ArrayList;
import java.util.Date;

public interface Lainaus {
	
	public abstract  int getNumero() ;
	public abstract void setNumero(int numero) ;
	public abstract  Date getLainausPvm() ;
	public abstract void setLainausPvm(Date lainausPvm) ;
	public abstract Asiakas getLainaaja() ;
	public abstract void setLainaaja(Asiakas lainaaja) ;
	public abstract void addNiteenLainaus(NiteenLainaus nl);
	public abstract NiteenLainaus getNiteenLainaus(int i);
	public abstract ArrayList<NiteenLainaus> getLista() ;
	public abstract String toString();
}
