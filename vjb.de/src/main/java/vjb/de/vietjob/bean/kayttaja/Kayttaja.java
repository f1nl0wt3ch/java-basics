package vjb.de.vietjob.bean.kayttaja;

public interface Kayttaja {
	public  void setId(int id);

	public  int getId();

	public  void setTunnus(String tunnus);

	public  String getTunnus();

	public  void setSalasana(String salasana);

	public  String getSalasana();

	public  int getRooliId();

	public  void setRooliId(int rooliId);

	public String getSuku();

	public void setSuku(String suku);

	public String getEtu();

	public void setEtu(String etu);

	public String getSposti();

	public void setSposti(String sposti);
	
	public int getEnabled();
	
	public void setEnabled(int enabled);
}
