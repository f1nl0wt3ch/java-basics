package vjb.de.vietjob.dao.kayttajaDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.kayttaja.Kayttaja;
import vjb.de.vietjob.bean.kayttaja.KayttajaImpl;

public class KayttajaRowMapper implements RowMapper<Kayttaja> {

	public Kayttaja mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kayttaja kayttaja = new KayttajaImpl();
		kayttaja.setId(rs.getInt("kayttaja_id"));
        kayttaja.setTunnus(rs.getString("kayttaja_tunnus"));
        kayttaja.setSalasana(rs.getString("kayttaja_salasana_encrypted"));
        kayttaja.setRooliId(rs.getInt("fk_rooli_id"));
        kayttaja.setEtu(rs.getString("kayttaja_etu"));
        kayttaja.setSuku(rs.getString("kayttaja_suku"));
        kayttaja.setSposti(rs.getString("kayttaja_sposti"));
        kayttaja.setEnabled(rs.getInt("kayttaja_enabled"));
		return kayttaja;
	}

}
