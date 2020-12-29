package vjb.de.vietjob.dao.rooliDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.rooli.Rooli;
import vjb.de.vietjob.bean.rooli.RooliImpl;

public class RooliRowMapper implements RowMapper<Rooli>{

	public Rooli mapRow(ResultSet rs, int rowNum) throws SQLException {
		Rooli rooli = new RooliImpl();
		rooli.setId(rs.getInt("rooli_id"));
		rooli.setNimi(rs.getString("rooli_nimi"));
		return rooli;
	}

}
