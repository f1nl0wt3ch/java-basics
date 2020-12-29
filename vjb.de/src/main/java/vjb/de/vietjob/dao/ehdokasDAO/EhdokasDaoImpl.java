package vjb.de.vietjob.dao.ehdokasDAO;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vjb.de.vietjob.bean.ehdokas.Ehdokas;
@Repository
public class EhdokasDaoImpl implements EhdokasDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void postEhdokas(Ehdokas ehdokas, int alaId) {
		String sql = "insert into ehdokas(ehdokas_sukupuoli,ehdokas_ika,ehdokas_suku,ehdokas_etu,ehdokas_osoite,ehdokas_kaupunki,ehdokas_puh,ehdokas_sposti,ehdokas_tutkinto,ehdokas_kielitaito,ehdokas_itsetieto,ehdokas_kokemus, ehdokas_kansalaisuus,fk_ala_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sukupuoli = ehdokas.getSukupuoli();
		Date ika = ehdokas.getIka();
		String suku = ehdokas.getSuku();
		String etu = ehdokas.getEtu();
		String osoite = ehdokas.getOsoite();
		String kaupunki = ehdokas.getKaupunki();
		String puh = ehdokas.getPuh();
		String sposti = ehdokas.getSposti();
		String tutkinto = ehdokas.getTutkinto();
		String kieli = ehdokas.getKieli();
		String itsetieto = ehdokas.getItsetieto();
		int kokemus = ehdokas.getKokemus();
		String kansalaisuus = ehdokas.getKansalaisuus();
		
        Object[] parameterit = new Object[]{sukupuoli,ika,suku,etu,osoite,kaupunki,puh,sposti,tutkinto,kieli,itsetieto,kokemus,kansalaisuus,alaId};
        
        try {
			jdbcTemplate.update(sql, parameterit);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public List<Ehdokas> showKaikkiEhdokkaat() {
		String sql = "select * from ehdokas";
		List<Ehdokas> list = new ArrayList<Ehdokas>();
		RowMapper<Ehdokas> rm = new EhdokasRowMapper();
		try {
			list = jdbcTemplate.query(sql,rm);
		} catch (DataAccessException e) {
			System.out.println("can't display list employee");
		}
		return list;
	}

	public List<String> getKotiKaupunki() {
		String sql = "select distinct ehdokas_kaupunki from ehdokas";
	    RowMapper<String> rm = new KaupunkiRowMapper();
		return jdbcTemplate.query(sql,rm);
	}

	public List<Ehdokas> getEhdokasByKaupunki(String kaupunki) {
		String sql ="select * from ehdokas where ehdokas_kaupunki=?";
		List<Ehdokas> list = new ArrayList<Ehdokas>();
		Object[] ob = new Object[]{kaupunki};
		RowMapper<Ehdokas> rm = new EhdokasRowMapper();
		list = jdbcTemplate.query(sql, ob, rm);
		return list;
	}

	public void deleteEhdokasById(int id) {
		String sql="delete from ehdokas where ehdokas_id=?";
		Object[] ob = new Object[]{id};
		try {
			jdbcTemplate.update(sql, ob);
		} catch (DataAccessException e) {
			System.out.println("ei pysty poistaa");
		}
		
		
	}

	public Ehdokas getEhdokasByTunnus(String tunnus) {
		Ehdokas e;
		String sql = "select * from ehdokas where fk_kayttaja_id = (select kayttaja_id from kayttaja where kayttaja_tunnus =?)";
		Object[] ob = new Object[]{tunnus};
		RowMapper<Ehdokas> rm = new EhdokasRowMapper();
		
		try {
			e= jdbcTemplate.queryForObject(sql, ob, rm);
			
		} catch (IncorrectResultSizeDataAccessException h) {
			throw new EhdokasEiLoydyPoikkeus(h);
		}
		return e;
		
	}

	public Ehdokas searchEhdokasById(int id) {
		String sql = "select * from ehdokas where ehdokas_id =?";
		Object[] ob = new Object[]{id};
		RowMapper<Ehdokas> rm = new EhdokasRowMapper();
		
		try {
			return jdbcTemplate.queryForObject(sql, ob, rm);
		} catch (Exception e) {
			return null;
		}
	}

	public void editEhdokas(Ehdokas e) {
		String sql= "update ehdokas set ehdokas_suku=?,ehdokas_etu=?,ehdokas_ika=?,ehdokas_osoite=?,ehdokas_kaupunki=?,ehdokas_puh=?,ehdokas_sposti=?,ehdokas_tutkinto=?, ehdokas_itsetieto=?,ehdokas_kielitaito=?,ehdokas_kokemus=?,ehdokas_kansalaisuus=? where ehdokas_id=?";
		String suku = e.getSuku();
		String etu = e.getEtu();
		Date ika = e.getIka();
		String osoite = e.getOsoite();
		String kaupunki = e.getKaupunki();
		String puh = e.getPuh();
		String sposti = e.getSposti();
		String tutkinto = e.getTutkinto();
		String itsetieto = e.getItsetieto();
		String kielitaito = e.getKieli();
		int kokemus = e.getKokemus();
		int id = e.getId();
		String kansalaisuus = e.getKansalaisuus();
		
		Object[] ob = new Object[]{suku,etu,ika,osoite,kaupunki,puh,sposti,tutkinto,itsetieto,kielitaito,kokemus,kansalaisuus, id};
		jdbcTemplate.update(sql, ob);
	}

}
