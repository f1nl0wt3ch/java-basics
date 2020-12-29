package vjb.de.vietjob.dao.duuniDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.duuni.Duuni;
import vjb.de.vietjob.bean.duuni.DuuniImpl;
public class DuuniRowMapper implements RowMapper<Duuni> {

	public Duuni mapRow(ResultSet rs, int row) throws SQLException {
			Duuni duuni = new DuuniImpl();
			duuni.setId(rs.getInt("duuni_id"));
			duuni.setNimi(rs.getString("duuni_nimi"));
			duuni.setJulkaistupv(rs.getDate("duuni_julkaistupv"));
			duuni.setErapv(rs.getDate("duuni_erapv"));
			duuni.setPaikka(rs.getString("duuni_paikka"));
			duuni.setPalkka(rs.getString("duuni_palkka"));
			duuni.setTiedot(rs.getString("duuni_tiedot"));
			duuni.setSopimus(rs.getString("duuni_sopimus"));
			duuni.setVaatimus(rs.getString("duuni_vaatimus"));
			duuni.setTyoantajaId(rs.getInt("fk_partneri_id"));
			duuni.setAlaId(rs.getInt("fk_ala_id"));
			return duuni;
		
	}

}
