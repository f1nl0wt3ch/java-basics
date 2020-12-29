package vjb.de.vietjob.dao.uutinenDAO;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vjb.de.vietjob.bean.uutinen.Uutinen;

@Repository
public class UutinenDaoImpl implements UutinenDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void postNew(Uutinen u, String link) {
		String sql = "insert into uutinen(uutinen_paiva, uutinen_kuva, uutinen_aihe, uutinen_sisalto) VALUES (?,?,?,?)";
		Date pv = u.getPaiva();
		String kuva = link;
		String aihe = u.getAihe();
		String sisalto = u.getSisalto();
		Object[] ob = new Object[]{pv, kuva, aihe, sisalto};
		
		jdbcTemplate.update(sql, ob);
	}

	public void deleteNew(int id) {
		String sql = "delete from uutinen where uutinen_id =?";
		Object[] ob = new Object[]{id};
		jdbcTemplate.update(sql, ob);
		
	}

	public List<Uutinen> showUutiset() {
		String sql = "select * from uutinen";
		RowMapper<Uutinen> rm = new UutinenRowMapper();
		List<Uutinen> list = jdbcTemplate.query(sql, rm);
		return list;
	}

	public void editUutinen(Uutinen u) {
		String sql = "update uutinen set uutinen_kuva=?, uutinen_aihe=?, uutinen_sisalto=?, uutinen_paiva=? where uutinen_id=?";
		String kuva = u.getKuvalink();
		String aihe = u.getAihe();
		String sisalto = u.getSisalto();
		Date pv = u.getPaiva();
		int id = u.getId();
		Object[] ob = new Object[]{kuva,aihe,sisalto,pv,id};
		jdbcTemplate.update(sql, ob);
	}

}
