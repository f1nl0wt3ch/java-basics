package fi.softala.jee.demo.d25.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fi.softala.jee.demo.d25.bean.Kayttaja;
import fi.softala.jee.demo.d25.helper.Salaaja;

public class KayttajaDao {
	private Connection yhteys;

	public void avaaYhteys() {
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			String username = "jusju";
			String password = "zyMUbR82p";
			String url = "jdbc:mysql://localhost:3306/jusju";
			try {
				yhteys = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void suljeYhteys() {
		try {
			yhteys.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void resetoiSalasana(String uusiSalasana, String email) {
		String suola = null;
		String kryptattuSalasana = null;
		try {
			suola = Salaaja.generoiSuola();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			kryptattuSalasana = Salaaja.salaa(uusiSalasana, suola, "SHA-512",
					100);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// avataan yhteys
		avaaYhteys();
		try {
			// alustetaan sql-lause
			String sql = "UPDATE Kayttajat SET salasana=?, suola=? WHERE email=?";
			PreparedStatement lause = yhteys.prepareStatement(sql);

			// täytetään puuttuvat tiedot
			lause.setString(1, kryptattuSalasana);
			lause.setString(2, suola);
			lause.setString(3, email);
			// suoritetaan lause
			lause.executeUpdate();
		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Päivitys ei onnistunut.");
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys();
		}
	}

	public boolean kirjaudu(Kayttaja kayttaja) {
		// avataan yhteys
		avaaYhteys();
		String sql = "SELECT salasana, suola FROM Kayttajat WHERE email=?";
		PreparedStatement lause = null;
		ResultSet resultset = null;
		String salasanaKannasta = null;
		String suolaKannasta = null;
		String formiltaSalasanaKryptattuna = null;
		try {
			lause = yhteys.prepareStatement(sql);
			// täytetään puuttuvat tiedot
			lause.setString(1, kayttaja.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// suoritetaan lause
		try {
			resultset = lause.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (resultset.next()) {
				salasanaKannasta = resultset.getString("salasana");
				suolaKannasta = resultset.getString("suola");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			formiltaSalasanaKryptattuna = Salaaja.salaa(kayttaja.getSalasana(),
					suolaKannasta, "SHA-512", 100);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// LOPULTA AINA SULJETAAN YHTEY
		suljeYhteys();
		boolean onnistunutKirjautuminen = false;
		if (formiltaSalasanaKryptattuna.equals(salasanaKannasta)) {
			onnistunutKirjautuminen = true;
		}
		return onnistunutKirjautuminen;
	}

	public void rekisteroidy(Kayttaja kayttaja, String salasanaformilta) {
		String suola = null;
		String kryptattuSalasana = null;
		try {
			suola = Salaaja.generoiSuola();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			kryptattuSalasana = Salaaja.salaa(salasanaformilta, suola,
					"SHA-512", 100);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// avataan yhteys
		avaaYhteys();

		try {

			// suoritetaan haku

			// alustetaan sql-lause
			String sql = "INSERT INTO Kayttajat(email, salasana, suola) VALUES(?,?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);

			// täytetään puuttuvat tiedot
			lause.setString(1, kayttaja.getEmail());
			lause.setString(2, kryptattuSalasana);
			lause.setString(3, suola);
			// suoritetaan lause
			lause.executeUpdate();
			System.out.println("LISÄTTIIN HENKILÖ TIETOKANTAAN: " + kayttaja);
		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("Henkilön lisäämisyritys aiheutti virheen.");
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys();
		}

	}

	public static void main(String[] args) {
		KayttajaDao dao = new KayttajaDao();
		Kayttaja kayttaja = new Kayttaja();
		kayttaja.setEmail("jukka.juslin@haaga-helia.fi");
		kayttaja.setSalasana("jukkajukka");
		if (dao.kirjaudu(kayttaja)) {
			System.out.println("Kirjautuminen onnistui!");
		}
	}
}
