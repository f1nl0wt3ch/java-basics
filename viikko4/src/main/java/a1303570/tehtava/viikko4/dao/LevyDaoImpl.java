package a1303570.tehtava.viikko4.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import a1303570.tehtava.viikko4.bean.Levy;

public class LevyDaoImpl implements LevyDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Levy> naytaListaLevy() {
		String sql = "SELECT * FROM aanilevy ";
		RowMapper<Levy> mapper = new LevyRowMapper();
		List<Levy> levyt = jdbcTemplate.query(sql, mapper);
		return levyt;
	}
}
