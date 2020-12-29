package vjb.de.vietjob.dao.hakemusDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.hakemus.Hakemus;
import vjb.de.vietjob.bean.hakemus.HakemusImpl;

public class HakemusRowMapper implements RowMapper<Hakemus>{

	public Hakemus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hakemus h = new HakemusImpl();
		h.setHakemus_id(rs.getInt("hakemus_id"));
		h.setDuuni_id(rs.getInt("fk_duuni_id"));
		h.setEhdokas_id(rs.getInt("fk_ehdokas_id"));
		h.setPaiva(rs.getDate("hakemus_pv"));
		return h;
	}

}
