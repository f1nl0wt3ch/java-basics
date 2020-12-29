package asiakas.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import asiakas.model.Posti;
import asiakas.model.PostiImpl;

public class PostiRowMapper implements RowMapper<Posti> {

	@Override
	public Posti mapRow(ResultSet rs, int rowNum) throws SQLException {
		Posti posti = new PostiImpl();
		posti.setPostinro (rs.getString("postinro"));
		posti.setPostitmp (rs.getString("postitmp"));
				
		return posti;
	}
	/*
	CREATE TABLE postinumeroalue (
	  postinro CHAR(5) NOT NULL PRIMARY KEY,
	  postitmp VARCHAR(30) NOT NULL
	 )ENGINE=InnoDB;
	 */
}
