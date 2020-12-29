package vjb.de.vietjob.dao.ehdokasDAO;

import java.util.List;

import vjb.de.vietjob.bean.ehdokas.Ehdokas;

public interface EhdokasDao {
	public void postEhdokas(Ehdokas ehdokas, int alaId);

	public List<Ehdokas> showKaikkiEhdokkaat();

	public List<String> getKotiKaupunki();

	public List<Ehdokas> getEhdokasByKaupunki(String kaupunki);

	public void deleteEhdokasById(int id);

	public Ehdokas getEhdokasByTunnus(String tunnus);

	public Ehdokas searchEhdokasById(int id);

	public void editEhdokas(Ehdokas ehdokas);

}
