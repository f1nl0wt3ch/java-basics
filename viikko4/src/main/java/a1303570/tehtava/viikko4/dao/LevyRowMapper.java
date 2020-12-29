package a1303570.tehtava.viikko4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import a1303570.tehtava.viikko4.bean.Levy;

public class LevyRowMapper implements RowMapper<Levy> {
	public Levy mapRow(ResultSet rs, int rowNum) throws SQLException{
		Levy l = new Levy();
		l.setId(rs.getInt("id"));
		l.setArtisti(rs.getString("artisti"));
		l.setNimi(rs.getString("nimi"));
		return l;
	}

}
