package vjb.de.vietjob.bean.kayttaja;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class KayttajaImpl implements Kayttaja {
	
	private int id;
	
	@NotEmpty
	private String tunnus;
	
	@Pattern(regexp="[A-Za-z€…Šš]{2,30}")
	private String suku;
	
	@Pattern(regexp="[A-Za-z€…Šš]{2,30}")
	private String etu;
	
	@NotEmpty @Email
	private String sposti;
	
	@NotEmpty @Size(min=6)
	private String salasana;
	
	private int rooliId;
	
	private int enabled;
	
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
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
	public String getSposti() {
		return sposti;
	}
	public void setSposti(String sposti) {
		this.sposti = sposti;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTunnus() {
		return tunnus;
	}
	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}
	public String getSalasana() {
		return salasana;
	}
	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}
	public int getRooliId() {
		return rooliId;
	}
	public void setRooliId(int rooliId) {
		this.rooliId = rooliId;		
	}


}
