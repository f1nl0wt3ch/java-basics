package vjb.de.vietjob.dao.partneriDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.partneri.Partneri;
import vjb.de.vietjob.bean.partneri.PartneriImpl;

public class PartneriRowMapper implements RowMapper<Partneri> {

	public Partneri mapRow(ResultSet rs, int rowNum) throws SQLException {
		Partneri p = new PartneriImpl();
		p.setId(rs.getInt("partneri_id"));
		p.setNimi(rs.getString("partneri_nimi"));
		p.setOsoite(rs.getString("partneri_osoite"));
		p.setPuh(rs.getString("partneri_puh"));
		p.setWebsivu(rs.getString("partneri_websivu"));
		p.setSposti(rs.getString("partneri_sposti"));
		return p;
	}

}
