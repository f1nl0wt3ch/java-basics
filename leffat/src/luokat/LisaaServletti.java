package luokat;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LisaaServletti
 */
@WebServlet("/LisaaServletti")
public class LisaaServletti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
		HttpSession istunto;
	    DBHoitaja kanta;
	    /* kertoo onko tietokantayhteys auki/suljettu */
	    boolean onAuki = false;
	    String ilmoitus="";
	  
	    /* Käyttäjätietojen hallinta */
	    ArrayList <Leffa>leffat;
	    
	    /* Tietokantaluokan ilmentymä */
	    
	    /* käyttäjän pyyntˆjen seuraaja */
	    private RequestDispatcher disp;
	    
	    /* istunto*/
	    HttpSession session;
   
    public LisaaServletti() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init()
    {
 
    	kanta = new DBHoitaja();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		session  = request.getSession(true);
		String action = request.getParameter("action");
		System.out.println("Ollaan lisäyksessä, action = " + action);
    	
        /* käyttäjä aloittaa ohjelman tai klikkaa alkuun-painiketta */
    	if(action == null || action.equalsIgnoreCase("Leffalistaan"))
    	{
    			
    		disp = request.getRequestDispatcher("/YllapitoServletti");
			disp.forward(request, response);		
    	}	
    	else if (action.equalsIgnoreCase("Lisää")){
    		disp = request.getRequestDispatcher("lisaaleffa.jsp");
			disp.forward(request, response);
    	}
    	else if(action.equalsIgnoreCase("Lisää leffa"))
    	{	
    		boolean lisaysOk = false;
    		try {
				onAuki = kanta.yhdista();
				if (onAuki)
				{
					lisaysOk = lisaaLeffaKantaan(request, response);
					if (lisaysOk)
						onAuki = kanta.sulje();

				else{
						ilmoitus = "Elokuvan lisäys epäonnistui!";
				}
				
				disp = request.getRequestDispatcher("lisaaleffa.jsp");
			}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
  
    		session.setAttribute("ilmoitus", ilmoitus);
			disp = request.getRequestDispatcher("lisaysilmoitus.jsp");
			disp.forward(request, response);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	private boolean lisaaLeffaKantaan(HttpServletRequest request, HttpServletResponse response)
	{
		String message="";
		String leffanimi, leffaohjaaja;
		String apuvuosi;
		int vuosi;
		Leffa leffa;
		boolean leffaEi = false;
		
		leffanimi = request.getParameter("nimi");	
    	leffaohjaaja = request.getParameter("ohjaaja");
    	apuvuosi = request.getParameter("valmistumisvuosi");
    	System.out.println("Sivulta tuli: " + leffanimi + " " + leffaohjaaja);
    	try{
			vuosi = Integer.parseInt(apuvuosi);
		}
		catch (NumberFormatException nfe)
		{
			vuosi = 0000;
			ilmoitus = ("Leffan valmistumisvuosi on virheellinen\n");
		}
    	leffa = new Leffa(leffanimi,leffaohjaaja,vuosi);
    	System.out.println("Lisättävän leffan tiedot " + leffa.toString());
    	try{
    		leffaEi = kanta.lisaa(leffa);  	
    		if (leffaEi){
    			ilmoitus = leffanimi + ", leffan tiedot on lisätty";		
    		}
    		else {
    			ilmoitus = leffanimi + ", leffan tietoja ei lisätty, on jo talletettu";	
    		}
    	}
    	catch (Exception e){
    		System.out.println(e.getMessage());
    		ilmoitus = message.toString();
    	}
    	return leffaEi;
	}

}
