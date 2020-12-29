package vjb.de.vietjob.dao.paikkaDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.paikka.Paikka;
import vjb.de.vietjob.bean.paikka.PaikkaImpl;

public class PaikkaRowMapper implements RowMapper<Paikka> {

	public Paikka mapRow(ResultSet rs, int rowNum) throws SQLException {
		Paikka pk = new PaikkaImpl();
		pk.setId(rs.getInt("paikka_id"));
		pk.setKaupunki(rs.getString("paikka_kaupunki"));
		pk.setMaa(rs.getString("paikka_maa"));
		return pk;
	}

}
