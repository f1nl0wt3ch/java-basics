package vjb.de.vietjob.dao.tutkintoDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.tutkinto.Tutkinto;

public class TutkintoRowMapper implements RowMapper<Tutkinto> {

	public Tutkinto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tutkinto tutkinto = new Tutkinto();
		tutkinto.setNimi(rs.getString("tutkinto_nimi"));
		return tutkinto;
	}

}
