package luokat;

import java.sql.*;
import java.util.*;


public class DBHoitaja {
	
    /**
     *Tietokantayhteyn hallinta.
     *@author Anne Benson
     *@since 14.5.2014
     *@version 0.9
     */
    private Connection tietokantayhteys;

    /**
     * Metodi, jolla asetetaan tietokantayhteyttä varten tiedot ja
     * otetaan yhteys tietokantaan. <br /> 
     * Heittä SQLException-poikkeuksen, jos tietokantaan
     * yhteyden tekemisessa on virheita
     *@return onnistuiko tietokantayhteyden avaus vai ei
     */
    public boolean yhdista()
    	throws SQLException 
    {
    	
    	String JDBCAjuri = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/leffa";
				
       boolean paluu = false;
       try
        {
			// ladataan tietokanta-ajuri
            Class.forName(JDBCAjuri).newInstance();
            System.out.println("Ajuri rekisteräity\n");
		}
		catch (Exception e)
        {
            
           	System.err.println("TIETOKANTALIITTYN VIRHETILANNE: " +
                "JDBC:n omaa tietokanta-ajuria ei loydy.\n\n" + e.getMessage() +
                " " + e.toString() + "\n");

            for (int i = 1; i <= 80; i++)
                System.out.print("=");

            System.out.print("\nTietokanta-ajuria ei loydy!");
        }
		try
		{
            // otetaan yhteys tietokantaan
			tietokantayhteys  = DriverManager.getConnection
					(url, "root", "vimaru");
			
			//tietokantayhteys = DriverManager.getConnection(
			//url,"a1234567", "omaSalasana");

            System.out.println("Yhteyden muodostaminen onnistui");
            paluu = true;  // yhteyden otto onnistui
        }
        catch (SQLException sqlE)
      	{
        
            System.out.println(sqlE.getMessage() +  "\navaa " +  url +
                "\nTietokantayhteyden avaaminen ei onnistunut.");
            System.out.println("\n" + sqlE.getMessage());
            paluu = false;
        }
        return paluu;
    }
    /** Hakee leffat-taulusta elokuvien tiedot. */
    public ArrayList<Leffa> haeLeffat(){
    	String leffanimi, ohjaaja;
    	int leffaid, v_vuosi;
    	List <Leffa >leffat = new ArrayList <Leffa>();
    	Statement lause=null; // suoritettava SQL-lause
        ResultSet tulosjoukko = null; // SQL-kyselyn tulokset
        //tauluun ja sarakkeisiin oman kannan tiedot
        String sqlTeksti = "SELECT * FROM leffat;";
        try{
        	lause = tietokantayhteys.createStatement();
        	tulosjoukko = lause.executeQuery(sqlTeksti);
        	while(tulosjoukko.next()){
        		leffaid = tulosjoukko.getInt("id");
        		leffanimi = tulosjoukko.getString("nimi");
        		ohjaaja = tulosjoukko.getString("ohjaaja");
        		v_vuosi =tulosjoukko.getInt("vuosi");
        		leffat.add(new Leffa(leffaid, leffanimi, ohjaaja, v_vuosi));
        	}
        	if(leffat.size() == 0)
        		leffat = null;	
        }
        catch (SQLException poikkeus){
        	System.out.println("Tietokanta ilmoitti virhetilanteen \n" +
        			poikkeus.getMessage());
        	leffat = null;
        }
        return (ArrayList<Leffa>) leffat;   
    }
    /** Sulkee tietokantayhteyden. */
    public boolean sulje() throws SQLException {  
            boolean paluu = false;
            try
            {
                tietokantayhteys.close();
                System.out.println("Yhteys tietokantaan katkaistu!");
                paluu = true;
            }
            catch (SQLException sqlE)
            {
                System.out.println(sqlE.getMessage() +  "\nsulje" + 
                    "\nTietokantayhteyden sulkeminen ei onnistunut.");
                paluu = false;
            }
            return paluu;
        }
    /** Lisä elokuvan leffat-tauluun, jos sitä ei vielä ole */
    public boolean lisaa(Leffa leffa){
    	Leffa uusi;
    	String nimi="", ohjaaja="";
    	int vuosi;
    	ResultSet tulosjoukko = null;
    	Statement lause;
    	String hakuarvo;
    	int lkm = 0;
    	hakuarvo = leffa.getElokuvaNimi().toString().trim();
    	System.out.println("DBhoitaja, lisaa: " + leffa.toString());
    	 String sqlTeksti = "SELECT * FROM leffat WHERE nimi='";
    	 	sqlTeksti = sqlTeksti + hakuarvo + "';";
    			 
    	 System.out.println("SQL: " + sqlTeksti);
         try{
         	lause = tietokantayhteys.createStatement();
         	tulosjoukko = lause.executeQuery(sqlTeksti);
         	while (tulosjoukko.next())
         	{
	         	nimi = tulosjoukko.getString("nimi");
	         	ohjaaja= tulosjoukko.getString("ohjaaja");
	         	vuosi = tulosjoukko.getInt("vuosi");
	         	uusi = new Leffa(nimi, ohjaaja, vuosi);
	         	System.out.println(uusi.toString());
         	}
         	
         	if(nimi.equalsIgnoreCase(hakuarvo))
         	{
         		return false;
         	}
         	else{
         		nimi = leffa.getElokuvaNimi();
         		ohjaaja = leffa.getOhjaaja();
         		vuosi = leffa.getValmistumisvuosi();
         		lause = tietokantayhteys.createStatement();
         		sqlTeksti = "INSERT INTO leffat(nimi, ohjaaja, vuosi)" +
         		"VALUES('" + nimi + "', '" + ohjaaja + "',"+ vuosi + ")";
         		lkm = lause.executeUpdate(sqlTeksti);
         		System.out.println("Elokuvia lisätty " + lkm + " kpl");
         		return true;	
         	}
         }
         
         catch (SQLException poikkeus){
         	System.out.println("Tietokanta ilmoitti virhetilanteen \n" +
         			poikkeus.getSQLState() +"\n" + 
         			poikkeus.getStackTrace());
         	return false;
         }	
    }
    /** Päivittä taulussa olevan elokuvan tiedot */
    private boolean paivita(Leffa leffa){
    	return true;
    }
    /** Poistaa leffat-taulusta elokuvan tiedot, jos ne ovat siellä.*/
    public boolean poista(String leffanimi){
    	String nimi="";
    	int leffaid=0;
    	ResultSet tulosjoukko = null;
    	Statement lause;
    	int lkm = 0;
    	String sqlTeksti = "SELECT * FROM leffat WHERE nimi='";
    	 	sqlTeksti = sqlTeksti + leffanimi + "';";
    			 
    	 
         try{
         	lause = tietokantayhteys.createStatement();
         	tulosjoukko = lause.executeQuery(sqlTeksti);
         	while (tulosjoukko.next())
         	{
         		leffaid = tulosjoukko.getInt("id");
	         	nimi = tulosjoukko.getString("nimi");	
         	}
         	tulosjoukko.close();
         	System.out.println("Poistossa,id ja nimi: " + leffaid + ", " + nimi);
         	if(nimi.equalsIgnoreCase(leffanimi))
         	{ 
	         	sqlTeksti = "DELETE FROM leffat WHERE id='" + leffaid + "';";
	         	lkm = lause.executeUpdate(sqlTeksti);
	         	System.out.println("Poistettu: " + lkm);
         		return true;
         	}
         	else{
         		
         		System.out.println("Elokuvia ei poistettu ");
         		return false;	
         	}
         }
         catch (SQLException poikkeus){
         	System.out.println("Tietokanta ilmoitti virhetilanteen \n" +
         			poikkeus.getSQLState() +"\n" + 
         			poikkeus.getStackTrace());
         	return false;
         }	
    }
    
} 
