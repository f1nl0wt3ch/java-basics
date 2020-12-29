package vjb.de.vietjob.dao.duuniDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PaikkaRowMapper implements RowMapper<String> {

	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getString("duuni_paikka");
		}

	}


