package vjb.de.vietjob.bean.ehdokas;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author dinhthinh
 * id
 * sukupuoli
 * ika
 * suku 
 * etu
 * osoite
 * kaupunki
 * puh
 * sposti
 * tutkinto
 * kieli
 * itsetieto
 * kokemus
 * alaId
 * kayttajaId
 */
public class EhdokasImpl implements Ehdokas {

	private int id;
	private int alaId;
	private int kayttajaId;
	private String kansalaisuus;
	
	@NotEmpty
	private String sukupuoli;

	private Date ika;

	@Size(min = 2, max = 30)
	private String suku;

	@Size(min = 2, max = 30)
	private String etu;

	@Size(min = 2, max = 255)
	private String osoite;

	@NotEmpty
	private String kaupunki;

	@NotNull
	private String puh;

	@NotEmpty @Email
	private String sposti;

	@Size(min = 3, max = 255)
	private String tutkinto;
    
	@NotEmpty
	private String kieli;
 
	@NotEmpty
	private String itsetieto;

	@Max(50)
	private int kokemus;



	public int getAlaId() {
		return alaId;
	}

	public void setAlaId(int alaId) {
		this.alaId = alaId;
	}

	public int getKayttajaId() {
		return kayttajaId;
	}

	public void setKayttajaId(int kayttajaId) {
		this.kayttajaId = kayttajaId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSuku() {
		return suku;
	}

	public void setSuku(String suku) {
		this.suku = suku;
	}

	public String getEtu() {
		return etu;
	}

	public void setEtu(String etu) {
		this.etu = etu;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public String getPuh() {
		return puh;
	}

	public void setPuh(String puh) {
		this.puh = puh;
	}

	public String getSposti() {
		return sposti;
	}

	public void setSposti(String sposti) {
		this.sposti = sposti;
	}

	public String getTutkinto() {
		return tutkinto;
	}

	public void setTutkinto(String tutkinto) {
		this.tutkinto = tutkinto;
	}

	public int getKokemus() {
		return kokemus;
	}

	public void setKokemus(int kokemus) {
		this.kokemus = kokemus;
	}

	public void setSukupuoli(String sukupuoli) {
		this.sukupuoli = sukupuoli;

	}

	public String getSukupuoli() {
		return sukupuoli;
	}

	public void setIka(Date ika) {
		this.ika = ika;
	}

	public Date getIka() {
		return ika;
	}

	public void setKaupunki(String kaupunki) {
		this.kaupunki = kaupunki;
	}

	public String getKaupunki() {
		return kaupunki;
	}

	public void setKieli(String kieli) {
		this.kieli = kieli;
	}

	public String getKieli() {
		return this.kieli;
	}

	public void setItsetieto(String itsetieto) {
		this.itsetieto = itsetieto;
	}

	public String getItsetieto() {
		return itsetieto;
	}

	public String getKansalaisuus() {
		return kansalaisuus;
	}

	public void setKansalaisuus(String kansalaisuus) {
		this.kansalaisuus = kansalaisuus;
	}

}
