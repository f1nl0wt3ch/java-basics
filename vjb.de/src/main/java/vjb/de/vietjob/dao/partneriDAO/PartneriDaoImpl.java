package vjb.de.vietjob.dao.partneriDAO;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vjb.de.vietjob.bean.partneri.Partneri;
import vjb.de.vietjob.dao.partneriDAO.PartneriDao;
import vjb.de.vietjob.dao.partneriDAO.PartneriRowMapper;

@Repository

public class PartneriDaoImpl implements PartneriDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public Partneri getPartneriByTunnus(String tunnus) {
		Partneri p;
		String sql = "select * from partneri where fk_kayttaja_id = ( select kayttaja_id from kayttaja where kayttaja_tunnus = ?)";
		Object[] ob = new Object[]{tunnus};
		RowMapper<Partneri> rm = new PartneriRowMapper();
		p= jdbcTemplate.queryForObject(sql, ob, rm);
		return p;
	}

	public void updateTiedot(Partneri partneri) {
		String sql = "update partneri set partneri_nimi =?, partneri_osoite=?, partneri_puh=?,partneri_websivu=? where partneri_id=?";
		String nimi = partneri.getNimi();
		String osoite = partneri.getOsoite();
		String websivu = partneri.getWebsivu();
		String puh = partneri.getPuh();
		int id = partneri.getId();
		Object[] ob = new Object[]{nimi,osoite,puh,websivu,id};
		jdbcTemplate.update(sql,ob);
	}

	
        
}
