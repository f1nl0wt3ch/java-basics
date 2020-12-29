package vjb.de.vietjob.dao.duuniDAO;

import java.sql.SQLException;
//import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;


import vjb.de.vietjob.bean.duuni.Duuni;

public interface DuuniDao {
	
	//@PreAuthorize("permitAll")
    public List<Duuni> showDuunit();
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void postDuuni(Duuni duuni, int partnerId, int alaId );
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteDuuni(int id);
	
	//@PreAuthorize("permitAll")
    public List<String> getPaikka();
	
	//@PreAuthorize("permitAll")
    public List<Duuni> searchByPaikka(String paikka) throws SQLException;
	
	//@PreAuthorize("permitAll")
    public List<String> getDuuniNimi();
	
	//@PreAuthorize("permitAll")
    public List<Duuni> searchByNimi(String nimi);
	
	//@PreAuthorize("permitAll")
	public Duuni showYksiDuuni(int id);
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void editDuuni(Duuni duuni);
	
	//@PreAuthorize("permitAll")
	public List<Duuni> searchDuuniByPaikkaAndNimi(String paikka, String nimi);
	
	public List<Duuni> searchDuuniByPartneriId(int id);
	

}
