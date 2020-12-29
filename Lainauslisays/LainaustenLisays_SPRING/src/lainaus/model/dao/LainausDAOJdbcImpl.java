package lainaus.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lainaus.model.Asiakas;
import lainaus.model.NiteenLainaus;
import lainaus.model.Posti;
import lainaus.model.dao.LainausRowMapper;
import lainaus.model.Lainaus;
import lainaus.model.dao.LainausDAO;

public class LainausDAOJdbcImpl implements LainausDAO {
	

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)
	public List<Lainaus> haeKaikki() {
		String sql = "SELECT l.numero as lainausnumero, lainauspvm, a.numero as asiakasnumero, "+
				"etunimi, sukunimi, osoite, p.postinro AS postinro, postitmp,  " +
				" k.isbn AS isbn ,nimi, n.nidenro AS nidenro,    " +
				" palautuspvm,kirjoittaja, painos, kustantaja " +
				"FROM lainaus l JOIN asiakas a ON l.lainaaja = a.numero " +
				"JOIN postinumeroalue p ON p.postinro=a.postinro " +
				"JOIN niteenlainaus nl ON l.numero = nl.lainausnro  " +
				"JOIN nide n ON n.isbn = nl.nideisbn AND n.nidenro = nl.nidenro " +
				"JOIN kirja k ON k.isbn = n.isbn   " +
				"ORDER BY lainausnumero";
		RowMapper<Lainaus> mapper = new LainausRowMapper();
		List<Lainaus> lainauslista = jdbcTemplate.query(sql,mapper);
		// lista voi sis‰lt‰‰ alkioita, jotka viittavat nulliin
		// poista ne alkiot
		poistaTyhjat(lainauslista);
	
		return lainauslista;
				
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, readOnly=true)
	public Lainaus etsi(int id) {
		Lainaus lainaus = null;
		String sql = "SELECT l.numero as lainausnumero, lainauspvm, a.numero as asiakasnumero, "+
				"etunimi, sukunimi, osoite, p.postinro AS postinro, postitmp,  " +
				" k.isbn AS isbn ,nimi, n.nidenro AS nidenro,    " +
				" palautuspvm,kirjoittaja, painos, kustantaja " +
				"FROM lainaus l JOIN asiakas a ON l.lainaaja = a.numero " +
				"JOIN postinumeroalue p ON p.postinro=a.postinro " +
				"JOIN niteenlainaus nl ON l.numero = nl.lainausnro  " +
				"JOIN nide n ON n.isbn = nl.nideisbn AND n.nidenro = nl.nidenro " +
				"JOIN kirja k ON k.isbn = n.isbn   " +
				"WHERE l.numero =?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Lainaus> mapper = new LainausRowMapper();
		
	    List<Lainaus> lista = jdbcTemplate.query(sql , parametrit, mapper);
	    // listan ensimm‰isess‰ alkiossa on lainaus
	    lainaus = lista.get(0);
	    return lainaus;
	}
	// poistaa listan alkiot, jotka viittaavat nulliin
	private void poistaTyhjat(List<Lainaus> lista)
	{
		int i = 0;
		while ( i<lista.size())
		{
			if (lista.get(i) == null)
				lista.remove(i);
			else
				i++;
		}
	}
}
