package vjb.de.vietjob.dao.alaDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.ala.Ala;

public class AlaRowMapper implements RowMapper<Ala> {

	public Ala mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ala ala = new Ala();
		ala.setId(rs.getInt("ala_id"));
		ala.setNimi(rs.getString("ala_nimi"));
		return ala;
	}

}
