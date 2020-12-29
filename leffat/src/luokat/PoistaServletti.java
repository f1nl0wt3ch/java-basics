package luokat;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PoistaServletti
 */
@WebServlet("/PoistaServletti")
public class PoistaServletti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp;
	DBHoitaja kanta = new DBHoitaja();
	private String ilmoitus;
    
    /* istunto*/
    HttpSession session;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoistaServletti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String leffanimi = "";
		boolean poistettu;
		session = request.getSession(true);
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("Poista"))
		{
			disp = request.getRequestDispatcher("poistaleffa.jsp");
			disp.forward(request, response);
		}
		else
			if (action.equalsIgnoreCase("Poista leffa"))
			{
				try {
					if(kanta.yhdista())
					{
						leffanimi = request.getParameter("nimi");
						poistettu = kanta.poista(leffanimi);
						if (poistettu)
						{
							ilmoitus = "Leffan " + leffanimi + " tiedot on poistettu";
						}
						else
							ilmoitus = "Leffan " + leffanimi + " tietoja ei poistettu\n"
							+ "Ei ollut kannassa";
					}
				}
				catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("ilmoitus", ilmoitus);
				disp = request.getRequestDispatcher("poistoilmoitus.jsp");
				disp.forward(request, response);
			}
		else
			if(action == null ||action.equalsIgnoreCase("Leffalistaan")) 
			{
				disp = request.getRequestDispatcher("/YllapitoServletti");
				disp.forward(request, response);
			}
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
