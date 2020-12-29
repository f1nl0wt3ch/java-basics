package vjb.de.vietjob.dao.hakemusDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.apply.Apply;
import vjb.de.vietjob.bean.apply.ApplyImpl;

public class ApplyRowMapper implements RowMapper<Apply> {

	public Apply mapRow(ResultSet rs, int rowNum) throws SQLException {
		Apply apply = new ApplyImpl();
		apply.setNimi(rs.getString("duuni_nimi"));
		apply.setHakemuspv(rs.getDate("hakemus_pv"));
		apply.setHakupaattyy(rs.getDate("duuni_erapv"));
		apply.setTyopaikka(rs.getString("duuni_paikka"));
		return apply;
	}

}
