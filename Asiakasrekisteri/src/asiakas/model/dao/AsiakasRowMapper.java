package asiakas.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import asiakas.model.Asiakas;
import asiakas.model.AsiakasImpl;
import asiakas.model.Posti;
import asiakas.model.PostiImpl;

import org.springframework.jdbc.core.RowMapper;


public class AsiakasRowMapper implements RowMapper<Asiakas> {

	@Override
	public Asiakas mapRow(ResultSet rs, int rowNum) throws SQLException {
		Asiakas asiakas = new AsiakasImpl();
		Posti posti = new PostiImpl();
		asiakas.setNumero(rs.getInt("numero"));
		asiakas.setEtunimi(rs.getString("etunimi"));
		asiakas.setSukunimi(rs.getString("sukunimi"));
		asiakas.setOsoite (rs.getString("osoite"));
		//asiakas.setPuhelin(rs.getString("puhelin"));
		//asiakas.setSahkoposti (rs.getString("sahkoposti"));
		posti.setPostinro (rs.getString("postinro"));
		posti.setPostitmp (rs.getString("postitmp"));
		asiakas.setPosti(posti);		
		
		return asiakas;
	}
	/*
	 CREATE TABLE asiakas (
	   numero INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	   etunimi VARCHAR(20) NOT NULL,
	   sukunimi VARCHAR(30) NOT NULL,
	   osoite VARCHAR(30) NOT NULL,
	   postinro CHAR(5) NOT NULL,
	   FOREIGN KEY (postinro) REFERENCES postinumeroalue (postinro)
	 )ENGINE=InnoDB;
	 */

}
