package lainaus.model;


public class KirjaImpl implements Kirja{
	private String isbn;
	private String nimi;
	private String kirjoittaja;
	private int painos;
	private String kustantaja;
	
	public KirjaImpl()
	{
		super();
	}
	public KirjaImpl (String isbn, String nimi, String kirjoittaja, int painos, String kustantaja)
	{
		this.setIsbn(isbn);
		this.setKirjoittaja(kirjoittaja);
		this.setNimi(nimi);
		this.setKustantaja(kustantaja);
		this.setPainos(painos);
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = muokkaaISBN(isbn);
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = muokkaaNimi(nimi);
	}
	public String getKirjoittaja() {
		return kirjoittaja;
	}
	public void setKirjoittaja(String kirjoittaja) {
		this.kirjoittaja = muokkaaHenkiloNimi(kirjoittaja);
	}
	public int getPainos() {
		return painos;
	}
	public void setPainos(int painos) {
		this.painos = 0;
		if (painos > 0)
			this.painos = painos;
	}
	public String getKustantaja() {
		return kustantaja;
	}
	public void setKustantaja(String kustantaja) {
		this.kustantaja = muokkaaNimi(kustantaja);
	}
	private  String muokkaaHenkiloNimi(String nimi)
	{
		String paluu = null, apu;
		int i;
		String sana;
		
		if (nimi != null && nimi.trim().length() > 0)			
		{
			// turhat v�lit pois
			nimi = nimi.trim();
			nimi = nimi.replaceAll("\\s+", " ");
			nimi = nimi.replaceAll(" - ", "-");
			nimi = nimi.replaceAll("- ", "-");
			nimi = nimi.replaceAll(" -", "-");
			
			//System.out.println(nimi);
			if (nimi.matches ("([a-z���A-Z��� ]-?){2,30}"))
			{
				nimi = nimi.toLowerCase();
				apu = "";
				// jokainen sana alkaa isolla
				i = nimi.indexOf(' ');
				while (i != -1)
				{
					sana = nimi.substring(0,i);
					sana = sana.substring(0,1).toUpperCase()+sana.substring(1);
					
					apu = apu + sana + " " ;
					
					nimi = nimi.substring(i+1);
					i = nimi.indexOf(' ');
				}
				nimi = nimi.substring(0,1).toUpperCase()+nimi.substring(1);
				apu = apu + nimi;
				// - j�lkeinen sana isolla alukirjaimella
				nimi = apu;
				apu="";
				i = nimi.indexOf('-');
				while (i != -1)
				{
					apu = apu + nimi.substring(0,i)+"-";
					nimi = nimi.substring(i+1);
					nimi = nimi.substring(0,1).toUpperCase()+nimi.substring(1);
					
					i = nimi.indexOf('-');
				}
				nimi = nimi.substring(0,1).toUpperCase()+nimi.substring(1);
				apu = apu + nimi;
				
				paluu = apu;
			}
		}
		
		return paluu;
	}
	private  String muokkaaNimi(String nimi)
	{
		String paluu = null;
		int i;
		String sana;
		
		if (nimi != null && nimi.trim().length() > 0)
		{
			// turhat v�lit pois
			nimi = nimi.trim();
			nimi = nimi.replaceAll("\\s+", " ");
			nimi = nimi.replaceAll(" - ", "-");
			nimi = nimi.replaceAll("- ", "-");
			nimi = nimi.replaceAll(" -", "-");
			
			if ( nimi.matches ("([a-z���A-Z��� 0-9]-?){2,50}"))
				
				paluu = nimi.substring(0,1).toUpperCase()+nimi.substring(1);
		}
		
		return paluu;
	}
	private  String muokkaaISBN(String isbn)
	{
		String paluu = null;
		
		if (isbn != null && isbn.matches("([0-9]-?){2,13}") && isbn.length() == 13)
			paluu = isbn;
		
		
		return paluu;
	}
	public String toString()
	{
		return isbn + ": " + nimi + ", " + kirjoittaja +", " + painos + ", " + kustantaja;
	}
}
