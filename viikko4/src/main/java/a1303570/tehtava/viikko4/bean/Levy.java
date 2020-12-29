package a1303570.tehtava.viikko4.bean;

public class Levy {
	private int id;
	private String nimi;
	private String artisti;
	/**
	 * 
	 */
	public Levy() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param nimi
	 * @param artisti
	 */
	public Levy(int id, String nimi, String artisti) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.artisti = artisti;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getArtisti() {
		return artisti;
	}
	public void setArtisti(String artisti) {
		this.artisti = artisti;
	}
	@Override
	public String toString() {
		return "Levy [id=" + id + ", nimi=" + nimi + ", artisti=" + artisti
				+ "]";
	}
	
	
      
}
