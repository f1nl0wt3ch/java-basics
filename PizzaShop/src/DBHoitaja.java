import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBHoitaja {
	private Connection pizzadb;
	
	public boolean yhdista()
	throws SQLException
	{
		String JDBCDriver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/benan";
		
		boolean paluu = false;
		try{
			Class.forName(JDBCDriver).newInstance();
		}
		catch (Exception e){
			System.err.println("TIETOKANTALIITYN VIRHETILANNE: "+"JDBC:n omaa tietokanta-ajuria ei löydy.\n\n"+ e.getMessage()+ "" + e.toString()+ "\n");
		for (int i = 1; i<= 80; i++)
			System.out.print("=");
		System.out.print("\nTietokanta-ajuri ei löydy!");
		
		}
		try{
			pizzadb = DriverManager.getConnection(url, "benan", "hoTUGH84v");
			   System.out.println("Yhteyden muodostaminen onnistui");
	            paluu = true;  // yhteyden otto onnistui
	        }
	        catch (SQLException sqlE)
	      	{
	        
	            System.out.println(sqlE.getMessage() +  "\navaa " +  url +
	                "\nTietokantayhteyden avaaminen ei onnistunut.");
	            paluu = false;
	        }
	        return paluu;
	    
		}
	
public ArrayList haePizza(){
	String nimi, sisalto;
	int id;
	Date poisto;
	Pizza pizza;
	
	List <Pizza> pizzaLista = new ArrayList<Pizza>();
	Statement lause = null;
	ResultSet tulosjoukko = null;
	String sqlTeksti = "SELECT * FROM pizza";
	try{
		lause = pizzadb.createStatement();
		tulosjoukko = lause.executeQuery(sqlTeksti);
		while(tulosjoukko.next()){
			id = tulosjoukko.getInt("ID");
			nimi = tulosjoukko.getString("Nimi");
			sisalto = tulosjoukko.getString("Sisaltö");
			poisto = tulosjoukko.getDate("Päivä");
			
			pizzaLista.add(new Pizza(id, nimi, sisalto, poisto));
		}
		if(pizzaLista.size() == 0)
			pizzaLista = null;
	}
	catch (SQLException poikkeus){
		System.out.println("Tietokanta ilmoitti virhetilanteen \n" +
    			poikkeus.getMessage());
    	pizzaLista = null;
	}
	return (ArrayList) pizzaLista;
}
	public boolean sulje()
        	throws SQLException
        {  
            boolean paluu = false;
            try
            {
                pizzadb.close();
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
}
