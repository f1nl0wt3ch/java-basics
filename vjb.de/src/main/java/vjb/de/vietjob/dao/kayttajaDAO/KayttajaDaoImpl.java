package vjb.de.vietjob.dao.kayttajaDAO;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vjb.de.vietjob.bean.authority.Authority;
import vjb.de.vietjob.bean.kayttaja.Kayttaja;
import vjb.de.vietjob.bean.rooli.Rooli;
import vjb.de.vietjob.dao.authorityDAO.AuthorityRowMapper;
import vjb.de.vietjob.dao.rooliDAO.RooliRowMapper;
import vjb.de.vietjob.utils.PasswordEncrypted;

@Repository
public class KayttajaDaoImpl implements KayttajaDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	// Talenttaa uusi kayttaja
	
	public void insertKayttaja(Kayttaja kayttaja) {
		PasswordEncrypted pe = new PasswordEncrypted();
		String tunnus = kayttaja.getTunnus();
		String sala = pe.encryptPassword(kayttaja.getSalasana());
		String etu = kayttaja.getEtu();
		String suku = kayttaja.getSuku();
		String sposti = kayttaja.getSposti();
		int enabled = kayttaja.getEnabled();
		Object[] parameterit= new Object[]{tunnus,sala,etu,suku,sposti,enabled};
		String sql = "insert into kayttaja (kayttaja_tunnus, kayttaja_salasana_encrypted,fk_rooli_id,kayttaja_etu, kayttaja_suku, kayttaja_sposti, kayttaja_enabled) values (?,?,3,?,?,?,?) ";
		
		try {
			jdbcTemplate.update(sql, parameterit);
		} catch (DataAccessException e) {
			
			e.printStackTrace();
		}
	}

	public String onkoKayttaja(String tunnus) {

		String sql = "select * from kayttaja where kayttaja_tunnus=?";
		Object[] parameteri = new Object[] { tunnus };
		RowMapper<Kayttaja> rm = new KayttajaRowMapper();

		try {
			return jdbcTemplate.queryForObject(sql, rm, parameteri)
					.getSalasana();
		} catch (DataAccessException e) {
			return null;
		}

	}

	// ota rooli id perustuu tunnukseen
	public int getKayttajanRooliId(String tunnus) {
		String sql = "select * from kayttaja where kayttaja_tunnus=?";
		Object[] parameteri = new Object[] { tunnus };
		RowMapper<Kayttaja> rm = new KayttajaRowMapper();

		try {
			return jdbcTemplate.queryForObject(sql, rm, parameteri)
					.getRooliId();
		} catch (DataAccessException e) {
			return 0;
		}
	}

	//ota rooli tyyppi perustuu id:lle
	public String getRooli(int id) {
		String sql = "select rooli_nimi from rooli where rooli_id =?";
		Object[] parameteri = new Object[] { id };
		RowMapper<Rooli> rm = new RooliRowMapper();

		try {
			return jdbcTemplate.queryForObject(sql, parameteri, rm).getNimi();
		} catch (DataAccessException e) {
			return null;
		}
	}

	public int getRooliIdByTunnus(String tunnus) {
		String sql="select kr.fk_rooli_id from kayttaja_rooli as kr, kayttaja as k where kr.fk_kayttaja_id = k.kayttaja_id and k.kayttaja_tunnus =?";
		Object[] ob = new Object[]{tunnus};
		RowMapper<Authority> rm = new AuthorityRowMapper();
		return jdbcTemplate.queryForObject(sql, ob, rm).getRooliId();
	}

	public Kayttaja getKayttajaByTunnus(String tunnus) {
		String sql = "select * from kayttaja where kayttaja_tunnus=?";
		Object[] ob = new Object[]{tunnus};
		RowMapper<Kayttaja> rm = new KayttajaRowMapper();
		return jdbcTemplate.queryForObject(sql,ob, rm);
	}

	public void updateTiedot(Kayttaja kayttaja) {
		PasswordEncrypted pe = new PasswordEncrypted();
		String sql ="update kayttaja set kayttaja_tunnus=?, kayttaja_salasana_encrypted=?,kayttaja_sposti=? where kayttaja_id=?";
	    String tunnus = kayttaja.getTunnus();
	    String salasana = pe.encryptPassword(kayttaja.getSalasana());
	    String sposti = kayttaja.getSposti();
	    int id = kayttaja.getId();
	    Object[] ob = new Object[]{tunnus,salasana,sposti,id};
	    jdbcTemplate.update(sql, ob);
	}

	

}
