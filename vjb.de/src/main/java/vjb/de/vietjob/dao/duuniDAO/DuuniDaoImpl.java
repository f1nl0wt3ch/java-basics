package vjb.de.vietjob.dao.duuniDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vjb.de.vietjob.bean.duuni.Duuni;
import vjb.de.vietjob.bean.duuni.DuuniImpl;

@Repository
public class DuuniDaoImpl implements DuuniDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Duuni> showDuunit() {
		String sql = "select * from duuni";
		RowMapper<Duuni> duuniRM = new DuuniRowMapper();
		List<Duuni> list = jdbcTemplate.query(sql, duuniRM);
		return list;
	}

	public Duuni showYksiDuuni(int id) {
		if (id != 0) {
			String sql = "select * from duuni where duuni_id=?";
			Object[] parameteri = new Object[] { id };
			RowMapper<Duuni> duuniRM = new DuuniRowMapper();
			Duuni duuni = new DuuniImpl();
			try {
				duuni = jdbcTemplate.queryForObject(sql, parameteri, duuniRM);
			} catch (IncorrectResultSizeDataAccessException e) {
				throw new DuuniEiLoydyPoikkeus(e);
			}
			return duuni;
		} else
			return null;
	}

	public void postDuuni(Duuni duuni, int partnerId, int alaId) {
	     String sql= "insert into duuni(duuni_nimi,duuni_palkka,duuni_paikka,duuni_erapv, duuni_sopimus,duuni_vaatimus, duuni_tiedot, fk_partneri_id, fk_ala_id) values (?,?,?,?,?,?,?,?,?)";
	     String nimi = duuni.getNimi();
	     String paikka = duuni.getPaikka();
	     String palkka = duuni.getPalkka();
	     String sopimus = duuni.getSopimus();
	     String vaatimus = duuni.getVaatimus();
	     String tiedot = duuni.getTiedot();
	     Date erapv = duuni.getErapv();
	     
	     Object[] ob = new Object[]{nimi,palkka,paikka,erapv,sopimus,vaatimus,tiedot,partnerId, alaId};
	     try {
			jdbcTemplate.update(sql,ob);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteDuuni(int id) {
		String sql = "delete from duuni where duuni_id=?";
		Object[] parameteri = new Object[] { id };

		try {
			jdbcTemplate.update(sql, parameteri);
			System.out.println("Duuni numero "
					+ jdbcTemplate.update(sql, parameteri) + " on poistettu");
		} catch (DataAccessException e) {
			System.out.print("Meillä ei ole duuni, jonka id on noin.");
		}
	}

	public List<String> getPaikka() {
		String sql = "select distinct duuni_paikka from duuni";
		List<String> paikat = new ArrayList<String>();
		RowMapper<String> rm = new PaikkaRowMapper();
		paikat = jdbcTemplate.query(sql, rm);
		return paikat;
	}

	public List<Duuni> searchByPaikka(String paikka) throws SQLException {
		List<Duuni> list;
		String sql = "select * from duuni where duuni_paikka =?";
		Object[] ob = new Object[] { paikka };
		RowMapper<Duuni> rm = new DuuniRowMapper();
		list = jdbcTemplate.query(sql, ob, rm);
		return list;
	}

	public List<String> getDuuniNimi() {
		String sql = "select distinct duuni_nimi from duuni";
		List<String> nimet = new ArrayList<String>();
		RowMapper<String> rm = new NimiRowMapper();
		nimet = jdbcTemplate.query(sql, rm);
		return nimet;

	}

	public List<Duuni> searchByNimi(String nimi) {
		String sql = "select * from duuni where duuni_nimi =?";
		Object[] ob = new Object[] { nimi };
		RowMapper<Duuni> rm = new DuuniRowMapper();
		return jdbcTemplate.query(sql, ob, rm);
	}


	public void editDuuni(Duuni duuni) {
		String sql = "update duuni set duuni_nimi=?, duuni_tiedot=?,duuni_paikka=?,duuni_palkka=?,duuni_sopimus=?,duuni_vaatimus=?,duuni_erapv=? where duuni_id=?";
		String nimi = duuni.getNimi();
		String tiedot = duuni.getTiedot();
		String paikka = duuni.getPaikka();
		String palkka = duuni.getPalkka();
		String sopimus = duuni.getSopimus();
		String vaatimus = duuni.getVaatimus();
		Date erapv = duuni.getErapv();
		int id = duuni.getId();
		Object[] ob = new Object[]{nimi, tiedot, paikka, palkka, sopimus, vaatimus, erapv, id};
		try {
			jdbcTemplate.update(sql, ob);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Duuni> searchDuuniByPaikkaAndNimi(String paikka, String nimi) {
		String sql ="select * from duuni where duuni_paikka=? and duuni_nimi=?";
		Object[] ob = new Object[]{paikka, nimi};
		RowMapper<Duuni> rm = new DuuniRowMapper();
		List<Duuni> list;
		list = jdbcTemplate.query(sql, ob, rm);
		return list;
	}

	public List<Duuni> searchDuuniByPartneriId(int id) {
		String sql ="select * from duuni where fk_partneri_id =?";
		Object[] ob = new Object[]{id};
		RowMapper<Duuni> rm = new DuuniRowMapper();
		List<Duuni> list = jdbcTemplate.query(sql, ob, rm);
		return list;
	}

}
