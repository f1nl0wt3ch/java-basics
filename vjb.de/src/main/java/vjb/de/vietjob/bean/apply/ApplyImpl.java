package vjb.de.vietjob.bean.apply;

import java.util.Date;

public class ApplyImpl implements Apply {
      private String nimi;
      private Date hakemuspv;
      private String tyopaikka;
      private Date hakupaattyy;
      
	public String getTyopaikka() {
		return tyopaikka;
	}
	public void setTyopaikka(String tyopaikka) {
		this.tyopaikka = tyopaikka;
	}
	public Date getHakupaattyy() {
		return hakupaattyy;
	}
	public void setHakupaattyy(Date hakupaattyy) {
		this.hakupaattyy = hakupaattyy;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public Date getHakemuspv() {
		return hakemuspv;
	}
	public void setHakemuspv(Date hakemuspv) {
		this.hakemuspv = hakemuspv;
	}
      
}
