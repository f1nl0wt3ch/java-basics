package vjb.de.vietjob.bean.hakemus;

import java.util.Date;


public class HakemusImpl implements Hakemus {
      private int hakemus_id;
      private int duuni_id;
      private int ehdokas_id;
      private Date paiva;
      
	
	public Date getPaiva() {
		return paiva;
	}
	public void setPaiva(Date paiva) {
		this.paiva = paiva;
	}
	public int getHakemus_id() {
		return hakemus_id;
	}
	public void setHakemus_id(int hakemus_id) {
		this.hakemus_id = hakemus_id;
	}
	public int getDuuni_id() {
		return duuni_id;
	}
	public void setDuuni_id(int duuni_id) {
		this.duuni_id = duuni_id;
	}
	public int getEhdokas_id() {
		return ehdokas_id;
	}
	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	
      
      
}
