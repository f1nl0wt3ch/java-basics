package vjb.de.vietjob.bean.duuni;


import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

public class DuuniImpl implements Duuni {
	
    private int id;
    @NotEmpty
	private String nimi;
    
	private Date julkaistupv;
	
	private Date erapv;
	@NotEmpty
	private String tiedot;
	@NotEmpty
	private String paikka;
	private String sopimus;
	@NotEmpty
	private String palkka;
	@NotEmpty
	private String vaatimus;
	private int alaId;
	private int tyoantajaId;
	
    public String getSopimus() {
		return sopimus;
	}

	public void setSopimus(String sopimus) {
		this.sopimus = sopimus;
	}

	public String getVaatimus() {
		return vaatimus;
	}

	public void setVaatimus(String vaatimus) {
		this.vaatimus = vaatimus;
	}

	public int getAlaId() {
		return alaId;
	}

	public void setAlaId(int alaId) {
		this.alaId = alaId;
	}

	public int getTyoantajaId() {
		return tyoantajaId;
	}

	public void setTyoantajaId(int tyoantajaId) {
		this.tyoantajaId = tyoantajaId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return this.nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public Date getJulkaistupv() {
			return julkaistupv;
		
	}

	public void setJulkaistupv(Date julkaistupv) {
		this.julkaistupv = julkaistupv;
	}

	public String getTiedot() {
		return this.tiedot;
	}

	public void setTiedot(String tiedot) {
		this.tiedot = tiedot;
	}

	public String getPaikka() {
		return this.paikka;
	}

	public void setPaikka(String paikka) {
		this.paikka = paikka;
	}

	public String getPalkka() {
		return this.palkka;
	}

	public void setPalkka(String palkka) {
		this.palkka = palkka;
	}



	public Date getErapv() {
			return erapv;
	}

	public void setErapv(Date erapv) {
		this.erapv = erapv;
	}
	

}
