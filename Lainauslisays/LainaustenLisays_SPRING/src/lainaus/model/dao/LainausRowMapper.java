package lainaus.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import lainaus.model.Asiakas;
import lainaus.model.AsiakasImpl;
import lainaus.model.Kirja;
import lainaus.model.KirjaImpl;
import lainaus.model.Lainaus;
import lainaus.model.LainausImpl;
import lainaus.model.Nide;
import lainaus.model.NideImpl;
import lainaus.model.NiteenLainaus;
import lainaus.model.NiteenLainausImpl;
import lainaus.model.Posti;
import lainaus.model.PostiImpl;

public class LainausRowMapper implements RowMapper<Lainaus> {
	private Lainaus edelllainaus;
	
	public LainausRowMapper ()
	{
		edelllainaus = null;
	}

	@Override
	public Lainaus mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Lainaus lainaus = new LainausImpl ();
		Asiakas asiakas = new AsiakasImpl();
		Posti posti = new PostiImpl();
		Kirja kirja = new KirjaImpl();
		Nide nide = new NideImpl ();
		NiteenLainaus niteenlainaus = new NiteenLainausImpl();
		
		lainaus.setNumero(rs.getInt("lainausnumero"));
		// jos kyseessä kyselyn ensimmäinen lainaus tai
		// lainausnumero on eri kuin edellisen lainauksen numero
		if (edelllainaus == null || (edelllainaus!= null &&  edelllainaus.getNumero()!= lainaus.getNumero())) {
			
			lainaus.setLainausPvm(rs.getDate("lainauspvm"));
			
			asiakas.setNumero(rs.getInt("asiakasnumero"));
			asiakas.setEtunimi(rs.getString("etunimi"));
			asiakas.setSukunimi(rs.getString("sukunimi"));
			asiakas.setOsoite (rs.getString("osoite"));
			
			posti.setPostinro (rs.getString("postinro"));
			posti.setPostitmp (rs.getString("postitmp"));
			asiakas.setPosti(posti);		
		
			lainaus.setLainaaja(asiakas);
		
			kirja.setIsbn(rs.getString("isbn"));
			kirja.setNimi(rs.getString("nimi"));
			kirja.setKirjoittaja(rs.getString("kirjoittaja"));
			kirja.setKustantaja(rs.getString("kustantaja"));
			kirja.setPainos(rs.getInt("painos"));
		
			nide.setKirja(kirja);
			nide.setNidenro(rs.getInt("nidenro"));
		
			niteenlainaus.setPalautusPvm(rs.getDate("palautuspvm"));
		
			niteenlainaus.setNide(nide);
		
			lainaus.addNiteenLainaus(niteenlainaus);
			edelllainaus = lainaus;  // ota talteenn lainaus
		}
		else  // kyseessä sama lainaus, mutta eri niteenlainaus
		{
			lainaus = null; // metodin palautusarvo on null
			
			kirja.setIsbn(rs.getString("isbn"));
			kirja.setNimi(rs.getString("nimi"));
			kirja.setKirjoittaja(rs.getString("kirjoittaja"));
			kirja.setKustantaja(rs.getString("kustantaja"));
			kirja.setPainos(rs.getInt("painos"));
		
			nide.setKirja(kirja);
			nide.setNidenro(rs.getInt("nidenro"));
		
			niteenlainaus.setPalautusPvm(rs.getDate("palautuspvm"));
		
			niteenlainaus.setNide(nide);
			//vie niteenlainaus edelliselle lainaukselle
			edelllainaus.addNiteenLainaus(niteenlainaus);
		}
		
		
		return lainaus;
	}
	/*
	 * "SELECT l.numero as lainausnumero, lainauspvm, a.numero as asiakasnumero, "+
	 * "etunimi, sukunimi, osoite, p.postinro AS postinro, postitmp,  " +
	 * " k.isbn AS isbn ,nimi, n.nidenro AS nidenro,    " +
	 * " palautuspvm,kirjoittaja, painos, kustantaja " +
	 * "FROM lainaus l JOIN asiakas a ON l.lainaaja = a.numero " +
	 * "JOIN postinumeroalue p ON p.postinro=a.postinro " +
	 * "JOIN niteenlainaus nl ON l.numero = nl.lainausnro  " +
	 * "JOIN nide n ON n.isbn = nl.nideisbn AND n.nidenro = nl.nidenro " +
	 * "JOIN kirja k ON k.isbn = n.isbn   " + "ORDER BY lainausnumero";
	 */
	/*
	 * CREATE TABLE lainaus( numero INT NOT NULL AUTO_INCREMENT, lainauspvm DATE
	 * NOT NULL, lainaaja INT NOT NULL, PRIMARY KEY (numero), FOREIGN KEY
	 * (lainaaja) REFERENCES asiakas (numero) )ENGINE=InnoDB;
	 */
	/*
	 * CREATE TABLE niteenlainaus( lainausnro INT NOT NULL, nideisbn CHAR(13)
	 * NOT NULL, nidenro INT NOT NULL, palautuspvm DATE, PRIMARY KEY(
	 * lainausnro, nideisbn, nidenro), FOREIGN KEY (lainausnro) REFERENCES
	 * lainaus (numero), FOREIGN KEY (nideisbn, nidenro) REFERENCES nide (isbn ,
	 * nidenro) )ENGINE=InnoDB;
	 */
	/*
	 * CREATE TABLE kirja( isbn CHAR(13) NOT NULL, nimi VARCHAR(20) NOT NULL,
	 * painos INT NOT NULL, kirjoittaja VARCHAR(30) NOT NULL, kustantaja
	 * VARCHAR(20) NOT NULL, PRIMARY KEY (isbn) )ENGINE=InnonDB;
	 * 
	 * CREATE TABLE nide ( isbn CHAR(13) NOT NULL, nidenro INT NOT NULL,
	 * lainassa CHAR(1), PRIMARY KEY (isbn, nidenro), FOREIGN KEY (isbn)
	 * REFERENCES kirja(isbn) )ENGINE=InnonDB;
	 */
}
