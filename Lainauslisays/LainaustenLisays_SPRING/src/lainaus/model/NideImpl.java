package lainaus.model;

public class NideImpl implements Nide{
	private Kirja kirja;
	private int nidenro;
	
	public NideImpl()
	{
		super();
	}
	public NideImpl (Kirja kirja, int nidenro)
	{
		this.kirja = kirja;
		this.setNidenro(nidenro);
	}
	public Kirja getKirja() {
		return kirja;
	}
	public void setKirja(Kirja kirja) {
		this.kirja = kirja;
	}
	public int getNidenro() {
		return nidenro;
	}
	public void setNidenro(int nidenro) {
		this.nidenro = 0;
		if (nidenro > 0)
			this.nidenro = nidenro;
	}
	public String toString ()
	{
		String paluu="";
		if (kirja != null)
		{
			paluu = kirja.getIsbn() + " " + nidenro +":" +  kirja.getNimi() + ", " + 
					kirja.getKirjoittaja() + ", " + kirja.getPainos() + ", " + kirja.getKustantaja();
			
		}
		return paluu;
	}
	
}
