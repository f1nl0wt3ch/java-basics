package vjb.de.vietjob.dao.uutinenDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.uutinen.Uutinen;

public class UutinenRowMapper implements RowMapper<Uutinen> {

	public Uutinen mapRow(ResultSet rs, int rowNum) throws SQLException {
		Uutinen u = new Uutinen();
		u.setId(rs.getInt("uutinen_id"));
		u.setKuvalink(rs.getString("uutinen_kuva"));
		u.setPaiva(rs.getDate("uutinen_paiva"));
		u.setSisalto(rs.getString("uutinen_sisalto"));
		u.setAihe(rs.getString("uutinen_aihe"));
		return u;
	}

}
