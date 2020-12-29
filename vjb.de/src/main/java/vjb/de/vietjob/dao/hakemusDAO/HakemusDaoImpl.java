package vjb.de.vietjob.dao.hakemusDAO;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vjb.de.vietjob.bean.apply.Apply;
import vjb.de.vietjob.bean.hakemus.Hakemus;

@Repository
public class HakemusDaoImpl implements HakemusDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertHakemus(Hakemus hakemus) {
		String sql="insert into hakemus(fk_duuni_id, fk_ehdokas_id) values(?,?)";
		int ehdokas_id= hakemus.getEhdokas_id();
		int duuni_id = hakemus.getDuuni_id();
		Object[] ob = new Object[]{duuni_id,ehdokas_id};
		jdbcTemplate.update(sql, ob);
		
	}

	public void deleteHakemus(int hakemus_id) {
		String sql="delete from hakemus where hakemus_id=?";
		Object[] ob = new Object[]{hakemus_id};
		jdbcTemplate.update(sql, ob);
		
	}

	public void editHakemus(Hakemus h) {
		String sql = "update hakemus set fk_duuni_id=?, fk_ehdokas_id=?, hakemus_pv=? where hakemus_id=?";	
		int hakemus_id = h.getHakemus_id();
		int ehdokas_id = h.getEhdokas_id();
		int duuni_id = h.getDuuni_id();
		Date pv = h.getPaiva();
		
		Object[] ob = new Object[]{duuni_id, ehdokas_id,pv, hakemus_id};
		jdbcTemplate.update(sql, ob);
	}

	public List<Hakemus> showHakemukset() {
		String sql = "select * from hakemus";
		RowMapper<Hakemus> rm = new HakemusRowMapper();
		List<Hakemus> hakemukset = jdbcTemplate.query(sql, rm);
		return hakemukset;
	}

	public List<Apply> showListAppliedDuuni(int ehdokas_id) {
		String sql = "select duuni_nimi, hakemus_pv, duuni_paikka, duuni_erapv from duuni as d, ehdokas as e, hakemus as h where d.duuni_id = h.fk_duuni_id and h.fk_ehdokas_id = e.ehdokas_id and h.fk_ehdokas_id = ?";
		Object[] ob = new Object[]{ehdokas_id};
		RowMapper<Apply> rm = new ApplyRowMapper();
		List<Apply> applied = jdbcTemplate.query(sql, ob, rm);
		return applied;
	}

	public boolean checkAppliedOrNot(Hakemus hakemus) {
		String sql ="select * from hakemus where fk_duuni_id = ? and fk_ehdokas_id = ?;";
		int duuni_id = hakemus.getDuuni_id();
		int ehdokas_id = hakemus.getEhdokas_id();
		Object[] ob = new Object[]{duuni_id, ehdokas_id};
		RowMapper<Hakemus> rm = new HakemusRowMapper();
		try {
			jdbcTemplate.queryForObject(sql,ob,rm);
			return true;
		} catch (DataAccessException e) {
			return false;
		}
		
	}

}
