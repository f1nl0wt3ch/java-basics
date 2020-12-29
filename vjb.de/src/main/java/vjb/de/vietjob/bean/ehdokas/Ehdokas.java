package vjb.de.vietjob.bean.ehdokas;

import java.util.Date;

public interface Ehdokas {
	public void setId(int id);

	public int getId();

	public void setSukupuoli(String sukupuoli);

	public String getSukupuoli();

	public void setIka(Date ika);

	public Date getIka();

	public void setSuku(String suku);

	public String getSuku();

	public void setEtu(String etu);

	public String getEtu();

	public void setOsoite(String osoite);

	public String getOsoite();

	public void setKaupunki(String kaupunki);

	public String getKaupunki();

	public void setPuh(String puh);

	public String getPuh();

	public void setSposti(String sposti);

	public String getSposti();

	public void setTutkinto(String tutkinto);

	public String getTutkinto();

	public void setKieli(String kieli);

	public String getKieli();

	public void setItsetieto(String itsetieto);

	public String getItsetieto();

	public void setKokemus(int kokemus);

	public int getKokemus();

	public int getAlaId();

	public void setAlaId(int ala_id);

	public int getKayttajaId();

	public void setKayttajaId(int kayttajaId);
	
	public String getKansalaisuus();

	public void setKansalaisuus(String kansalaisuus);

}
