package luokat;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class YllapitoServlet
 */
@WebServlet("/YllapitoServletti")
public class YllapitoServletti extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	HttpSession istunto;
	private RequestDispatcher disp;

    private ArrayList <Leffa> leffat;
    DBHoitaja kanta;
   
    public YllapitoServletti() {
        
        // TODO Auto-generated constructor stub
    }
    public void init ()
    {
    	leffat = null;
    	kanta = new DBHoitaja();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		istunto  = request.getSession(true);
		System.out.println("Ollaan getissä");
		//naytaLeffatHtml(request, response);
		String action = request.getParameter("action");
		System.out.println("Action: "  + action);
		
		/* k‰ytt‰j‰ aloittaa ohjelman, klikkaa alkuun-painiketta tai palaa muista servleteist‰ */
    	if(action == null || action.equalsIgnoreCase("Leffalistaan"))
    		naytaLeffatSivu(request, response);
    	else
    	{
    		if (action.equalsIgnoreCase("Lisää") )
    		{
    			disp = request.getRequestDispatcher("/LisaaServletti");
    			disp.forward(request, response);
    			naytaLeffatSivu(request, response);
    		}
    		else
    		{
    			if (action.equalsIgnoreCase("Päivitä"))
    			{
    				disp = request.getRequestDispatcher("/PaivitaServletti");
    				disp.forward(request, response);
    			}
    			else
    			{
    				if (action.equalsIgnoreCase("Poista"))
    				{
    					disp = request.getRequestDispatcher("/PoistaServletti");
    					disp.forward(request, response);
    					naytaLeffatSivu(request, response);
    				}
    			}
    		}
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
			
	}

		public void naytaLeffatSivu(HttpServletRequest request, HttpServletResponse response){
			try{
				if (kanta.yhdista())
				{
					//istunto = request.getSession(true);
								
					System.out.println("Sivun luonnissa");
					leffat = new ArrayList<Leffa>();
			
					leffat = kanta.haeLeffat();
					if (kanta.sulje())
						System.out.println("Kanta suljettu");
					else
						System.out.println("Kanta auki");
					System.out.println("leffat haettu");
					istunto.setAttribute("elokuvat", leffat);
					System.out.println("attribuutit asetettu");
					//String action = request.getParameter("action");
					disp = request.getRequestDispatcher("leffalista.jsp");
					System.out.println("Lähdetään sivulle");
					disp.forward(request, response);
				}
				else
					System.out.println("Nyt meni jotain pieleen!!!");
			}

			catch (Exception e){
					
			}
		}// TODO Auto-generated method stub
		
	}

