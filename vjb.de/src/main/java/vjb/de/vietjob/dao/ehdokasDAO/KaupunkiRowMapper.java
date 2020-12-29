package vjb.de.vietjob.dao.ehdokasDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class KaupunkiRowMapper implements RowMapper<String> {

	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getString("ehdokas_kaupunki");
	}

}
