package lainaus.model;

import java.util.ArrayList;
import java.util.Date;


public class LainausImpl implements Lainaus {
	private int numero;
	private Date lainausPvm;
	private Asiakas lainaaja;
	private ArrayList<NiteenLainaus> lista;
	
	public LainausImpl()
	{
		super();
		lainausPvm = new Date();
	}
	public LainausImpl(int numero, Date LainausPvm, Asiakas lainaaja)
	{
		this();
		this.setNumero(numero);
		this.setLainaaja(lainaaja);
		this.setLainausPvm(LainausPvm);
	}
	public LainausImpl(int numero, Date LainausPvm)
	{
		this();
		this.setNumero(numero);
		this.setLainausPvm(LainausPvm);
	}
	public LainausImpl(Date LainausPvm, Asiakas lainaaja)
	{
		this();
		this.setLainaaja(lainaaja);
		this.setLainausPvm(LainausPvm);
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = 0;
		if (numero > 0)
			this.numero = numero;
	}
	public Date getLainausPvm() {
		Date apu = (Date)lainausPvm.clone();
		
		return apu;
	}
	public void setLainausPvm(Date lainausPvm) {
		if (lainausPvm != null)
			this.lainausPvm = (Date)lainausPvm.clone();
	}
	public Asiakas getLainaaja() {
		return lainaaja;
	}
	public void setLainaaja(Asiakas lainaaja) {
		this.lainaaja = lainaaja;
	}
	public void addNiteenLainaus(NiteenLainaus nl)
	{
		if (nl != null)
		{
			if (lista == null)
				lista = new ArrayList<NiteenLainaus>();
			
			lista.add(nl);
		}
	}
	public NiteenLainaus getNiteenLainaus(int i)
	{
		NiteenLainaus paluu = null;
		if (lista != null && i <lista.size())
			paluu = lista.get(i);
		
		return paluu;
	}
	public ArrayList<NiteenLainaus> getLista() {
		return lista;
	}
	public String toString()
	{
		String paluu=null;
		paluu = numero + " " + lainausPvm + "\n" + lainaaja ;
		if (lista != null)
		{
			for (int i = 0;i <lista.size();i++)
				paluu = paluu + "\n\t" + lista.get(i);
		}
		return paluu;
	}

	
	
}
