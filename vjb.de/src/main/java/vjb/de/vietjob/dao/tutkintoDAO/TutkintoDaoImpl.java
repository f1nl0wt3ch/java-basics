package vjb.de.vietjob.dao.tutkintoDAO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vjb.de.vietjob.bean.tutkinto.Tutkinto;

@Repository
public class TutkintoDaoImpl implements TutkintoDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<String> showTutkinnot() {
		String sql="select * from tutkinto";
		RowMapper<Tutkinto> rm = new TutkintoRowMapper();
		List<String> listStr = new ArrayList<String>();
		
		try {
			for(Tutkinto tut: jdbcTemplate.query(sql, rm)){
				listStr.add(tut.getNimi());
			}
			return listStr;
		} catch (DataAccessException e) {
			return null;
		}
	}

	public void addTutkinto(Tutkinto tut) {
		String sql="insert into tutkinto(tutkinto_nimi) values (?)";
		String nimi = tut.getNimi();
		Object[] ob = new Object[]{nimi};
		jdbcTemplate.update(sql, ob);
	}

	public void deleteTutkinto(int id) {
		String sql="delete from tutkinto where tutkinto_id=?";
		Object[] ob = new Object[]{id};
		jdbcTemplate.update(sql, ob);
	}

	public void editTutkinto(Tutkinto tut) {
		String sql ="update tutkinto set tutkinto_nimi=? where tutkinto_id=?";
		int id = tut.getId();
		String nimi = tut.getNimi();
		Object[] ob = new Object[]{id,nimi};
		jdbcTemplate.update(sql, ob);
	}

}
