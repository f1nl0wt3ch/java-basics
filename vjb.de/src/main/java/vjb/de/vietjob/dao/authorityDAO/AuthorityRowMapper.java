package vjb.de.vietjob.dao.authorityDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.authority.Authority;
import vjb.de.vietjob.bean.authority.AuthorityImpl;

public class AuthorityRowMapper implements RowMapper<Authority> {

	public Authority mapRow(ResultSet rs, int rowNum) throws SQLException {
		Authority a = new AuthorityImpl();
		/*a.setId(rs.getInt("id"));*/
/*		a.setKayttajaId(rs.getInt("fk_kayttaja_id"));*/
		a.setRooliId(rs.getInt("fk_rooli_id"));
		return a;
	}

}
