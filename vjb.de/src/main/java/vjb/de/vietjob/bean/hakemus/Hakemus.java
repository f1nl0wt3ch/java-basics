package vjb.de.vietjob.bean.hakemus;

import java.util.Date;


public interface Hakemus {
	public int getHakemus_id();
	public void setHakemus_id(int hakemus_id);
	public int getDuuni_id();
	public void setDuuni_id(int duuni_id);
	public int getEhdokas_id();
	public void setEhdokas_id(int ehdokas_id);
	public Date getPaiva();
	public void setPaiva(Date paiva);
	
}
