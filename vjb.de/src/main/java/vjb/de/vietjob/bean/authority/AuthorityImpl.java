package vjb.de.vietjob.bean.authority;

public class AuthorityImpl implements Authority {
       private int id;
       private int rooliId;
       private int kayttajaId;
       
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRooliId() {
		return rooliId;
	}
	public void setRooliId(int rooliId) {
		this.rooliId = rooliId;
	}
	public int getKayttajaId() {
		return kayttajaId;
	}
	public void setKayttajaId(int kayttajaId) {
		this.kayttajaId = kayttajaId;
	}
       
       
}
