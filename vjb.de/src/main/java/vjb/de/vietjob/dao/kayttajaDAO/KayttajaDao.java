package vjb.de.vietjob.dao.kayttajaDAO;

import vjb.de.vietjob.bean.kayttaja.Kayttaja;

public interface KayttajaDao {
	public String onkoKayttaja(String tunnus);
	public int getKayttajanRooliId(String tunnus);
	public String getRooli(int id);
	public void insertKayttaja(Kayttaja kayttaja);
	public int getRooliIdByTunnus(String tunnus);
	public Kayttaja getKayttajaByTunnus(String tunnus);
	public void updateTiedot(Kayttaja kayttaja);
	
	
}
