package asiakas.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import asiakas.model.Asiakas;
import asiakas.model.Posti;
import asiakas.model.dao.AsiakasRowMapper;
import asiakas.model.AsiakasImpl;

public class AsiakasDAOJdbcImpl implements AsiakasDAO {
	

private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see model.dao.OsallistujaDAO#talleta(model.Osallistuja)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.SERIALIZABLE, readOnly=false)
	public void talleta(Asiakas asiakas) {
		/*
		 * etsit‰‰n ensin posti, jos ei lˆydy, lis‰t‰‰n. lopuksi lis‰s‰‰nt asiakas
		 */
		Posti posti = null;
		System.out.println(asiakas);
		Object [] parametrit, parametrit1, parametrit2;
		
		String sql1 = "SELECT postinro, postitmp FROM postinumeroalue WHERE postinro = ?"; 
		String sql2 = "INSERT INTO postinumeroalue (postinro, postitmp) VALUES (?,?)";
		String sql = "INSERT INTO asiakas (etunimi, sukunimi, osoite, postinro_FK) values(?,?,?,?)";
		
		parametrit1 = new Object[] { asiakas.getPosti().getPostinro() };
		RowMapper<Posti> mapper = new PostiRowMapper();
		try
		{
		posti = jdbcTemplate.queryForObject(sql1 , parametrit1, mapper);
		}
		catch (EmptyResultDataAccessException e)
		{
		   	parametrit2 = new Object[] { asiakas.getPosti().getPostinro(), asiakas.getPosti().getPostitmp()};
	    	jdbcTemplate.update(sql2 , parametrit2);
		}
		// lis‰‰ asiakas
		parametrit = new Object[] { asiakas.getEtunimi(), asiakas.getSukunimi(), asiakas.getOsoite(),
						asiakas.getPosti().getPostinro() };
	    jdbcTemplate.update(sql , parametrit);
	 }
	
	/* (non-Javadoc)
	 * @see model.dao.AssaiakaDAO#etsi(int)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)
	public Asiakas etsi(int id) {
		 int numero;
		 String etunimi, sukunimi, lahiosoite;
	     Posti posti;
	     String puhelin;
	     String sahkoposti;
		System.out.println("id = " + id);
		String sql = "SELECT numero, etunimi, sukunimi, osoite, postinro , postitmp" +
		            " FROM asiakas NATURAL JOIN postinumeroalue WHERE numero = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Asiakas> mapper = new AsiakasRowMapper();
		
	    Asiakas asiakas = jdbcTemplate.queryForObject(sql , parametrit, mapper);
	    System.out.println("Etsitty asiakas = " + asiakas);
	    return asiakas;
	                                  

	}
	
	/* (non-Javadoc)
	 * @see model.dao.OsallistujaDAO#haeKaikki()
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)
	public List<Asiakas> haeKaikki() {
		
		String sql = "SELECT numero, etunimi, sukunimi, osoite, postinro , postitmp" +
		            " FROM asiakas NATURAL JOIN postinumeroalue";
		RowMapper<Asiakas> mapper = new AsiakasRowMapper();
		List<Asiakas> osallistujalista = jdbcTemplate.query(sql,mapper);

		return osallistujalista;
	}
}
