import java.sql.*;
import java.util.*;

public class DBHoitaja {

	/*
	 * Tietokantayhteys.
	 */
	private Connection tietokantayhteys;

	/*
	 * Metodi, jolla asetetaan tietokantayhteyttä varten tiedot jaotetaan yhteys
	 * tietokantaan
	 * 
	 * @return onnistuiko tietokantayhteyden avaus vai ei Heittaa
	 * SQLException-poikkeuksen, jos tietokantaan yhteyden tekemisessa on
	 * virheita
	 */
	public boolean yhdista() throws SQLException {

		String JDBCAjuri = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/irene_vilpponen";

		boolean paluu = false;
		try {
			// ladataan tietokanta-ajuri
			Class.forName(JDBCAjuri).newInstance();
		} catch (Exception e) {

			System.err.println("TIETOKANTALIITTYN VIRHETILANNE: "
					+ "JDBC:n omaa tietokanta-ajuria ei loydy.\n\n"
					+ e.getMessage() + " " + e.toString() + "\n");

			for (int i = 1; i <= 80; i++)
				System.out.print("=");

			System.out.print("\nTietokanta-ajuria ei loydy!");
		}
		try {
			// otetaan yhteys tietokantaan
			tietokantayhteys = DriverManager.getConnection(url, "irene.vilpponen",
					"zyJE2898f");

			System.out.println("Yhteyden muodostaminen onnistui");
			paluu = true; // yhteyden otto onnistui
		} catch (SQLException sqlE) {

			System.out.println(sqlE.getMessage() + "\navaa " + url
					+ "\nTietokantayhteyden avaaminen ei onnistunut.");
			paluu = false;
		}
		return paluu;
	}

	public ArrayList haeLeffat() {
		String leffanimi, ohjaaja;
		int leffaid, v_vuosi;
		Leffa leffa;
		List<Leffa> leffat = new ArrayList<Leffa>();
		Statement lause = null; // suoritettava SQL-lause
		ResultSet tulosjoukko = null; // SQL-kyselyn tulokset
		String sqlTeksti = "SELECT * FROM leffat";
		try {
			lause = tietokantayhteys.createStatement();
			tulosjoukko = lause.executeQuery(sqlTeksti);
			while (tulosjoukko.next()) {
				leffaid = tulosjoukko.getInt("id");
				leffanimi = tulosjoukko.getString("nimi");
				ohjaaja = tulosjoukko.getString("ohjaaja");
				v_vuosi = tulosjoukko.getInt("vuosi");
				;
				leffat.add(new Leffa(leffaid, leffanimi, ohjaaja, v_vuosi));
			}
			if (leffat.size() == 0)
				leffat = null;
		} catch (SQLException poikkeus) {
			System.out.println("Tietokanta ilmoitti virhetilanteen \n"
					+ poikkeus.getMessage());
			leffat = null;
		}
		return (ArrayList) leffat;
	}

	public boolean sulje() throws SQLException {
		boolean paluu = false;
		try {
			tietokantayhteys.close();
			System.out.println("Yhteys tietokantaan katkaistu!");
			paluu = true;
		} catch (SQLException sqlE) {
			System.out.println(sqlE.getMessage() + "\nsulje"
					+ "\nTietokantayhteyden sulkeminen ei onnistunut.");
			paluu = false;
		}
		return paluu;
	}

}
