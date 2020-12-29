package vjb.de.vietjob.bean.uutinen;

import java.util.Date;

public class Uutinen {
    private int id;
    private String kuvalink;
    private Date paiva;
    private String aihe;
    private String sisalto;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKuvalink() {
		return kuvalink;
	}
	public void setKuvalink(String kuvalink) {
		this.kuvalink = kuvalink;
	}
	public Date getPaiva() {
		return paiva;
	}
	public void setPaiva(Date paiva) {
		this.paiva = paiva;
	}
	public String getAihe() {
		return aihe;
	}
	public void setAihe(String aihe) {
		this.aihe = aihe;
	}
	public String getSisalto() {
		return sisalto;
	}
	public void setSisalto(String sisalto) {
		this.sisalto = sisalto;
	}
    
    
}
