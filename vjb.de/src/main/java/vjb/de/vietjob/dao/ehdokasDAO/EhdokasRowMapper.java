package vjb.de.vietjob.dao.ehdokasDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.ehdokas.Ehdokas;
import vjb.de.vietjob.bean.ehdokas.EhdokasImpl;

public class EhdokasRowMapper implements RowMapper<Ehdokas> {

	public Ehdokas mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ehdokas e = new EhdokasImpl();
		
		e.setId(rs.getInt("ehdokas_id"));
		e.setIka(rs.getDate("ehdokas_ika"));
		e.setSukupuoli(rs.getString("ehdokas_sukupuoli"));
		e.setEtu(rs.getString("ehdokas_etu"));
		e.setSuku(rs.getString("ehdokas_suku"));
		e.setOsoite(rs.getString("ehdokas_osoite"));
		e.setKaupunki(rs.getString("ehdokas_kaupunki"));
		e.setKieli(rs.getString("ehdokas_kielitaito"));
		e.setPuh(rs.getString("ehdokas_puh"));
		e.setSposti(rs.getString("ehdokas_sposti"));
		e.setTutkinto(rs.getString("ehdokas_tutkinto"));
		e.setKokemus(rs.getInt("ehdokas_kokemus"));
		e.setAlaId(rs.getInt("fk_ala_id"));
		e.setKayttajaId(rs.getInt("fk_kayttaja_id"));
		e.setItsetieto(rs.getString("ehdokas_itsetieto"));
		e.setKansalaisuus(rs.getString("ehdokas_kansalaisuus"));
		return e;
	}

}
