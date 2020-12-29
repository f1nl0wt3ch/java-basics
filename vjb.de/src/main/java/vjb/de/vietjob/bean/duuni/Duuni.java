package vjb.de.vietjob.bean.duuni;

import java.util.Date;

/**
 * @author dinhthinh Id nimi paiva tiedot paikka palkka
 * 
 */
public interface Duuni {

	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getNimi();

	public abstract void setNimi(String nimi);

	public abstract Date getJulkaistupv();

	public abstract void setJulkaistupv(Date julkaistupv);

	public abstract String getTiedot();

	public abstract void setTiedot(String tiedot);

	public abstract String getPaikka();

	public abstract void setPaikka(String paikka);

	public abstract String getPalkka();

	public abstract void setPalkka(String palkka);


	public abstract Date getErapv();

	public abstract void setErapv(Date erapv);

	public abstract String getSopimus();

	public abstract void setSopimus(String sopimus);

	public abstract String getVaatimus();

	public abstract void setVaatimus(String vaatimus);

	public  abstract int getAlaId();

	public abstract void setAlaId(int alaId);

	public abstract int getTyoantajaId();

	public abstract void setTyoantajaId(int tyoantajaId);

}
