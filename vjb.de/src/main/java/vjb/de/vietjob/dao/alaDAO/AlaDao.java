package vjb.de.vietjob.dao.alaDAO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vjb.de.vietjob.bean.ala.Ala;

@Repository
public class AlaDao {
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<String> getListAlaNimi() {
		String sql = "select * from ala";
		List<String> listStr = new ArrayList<String>();
		RowMapper<Ala> rm = new AlaRowMapper();
		try {
			for (Ala ala : jdbcTemplate.query(sql, rm)) {
				listStr.add(ala.getNimi());
			}
			return listStr;

		} catch (DataAccessException e) {
			System.out.print("can't get ala");
			return null;
		}
	}

	public List<Integer> getListAlaId() {
		String sql = "select ala_id from ala";
		RowMapper<Integer> rm = new AlaIdRowMapper();
		return jdbcTemplate.query(sql, rm);
	}

	public int getAlaId(String nimi) {
		String sql = "select * from ala where ala_nimi=?";
		Object[] ob = new Object[] { nimi };
		RowMapper<Ala> rm = new AlaRowMapper();
		try {
			return jdbcTemplate.queryForObject(sql, ob, rm).getId();
		} catch (DataAccessException e) {
            return 0;
		}
	}

}
