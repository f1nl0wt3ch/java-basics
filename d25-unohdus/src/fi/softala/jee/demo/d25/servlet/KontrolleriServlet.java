package fi.softala.jee.demo.d25.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.softala.jee.demo.d25.bean.Kayttaja;
import fi.softala.jee.demo.d25.dao.KayttajaDao;
import fi.softala.jee.demo.d25.helper.Email;

/**
 * Servlet implementation class UnohdusServlet
 */
@WebServlet("/KontrolleriServlet")
public class KontrolleriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KontrolleriServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("Kirjaudu")) {
			String email = request.getParameter("email");
			String salasana = request.getParameter("salasana");
			KayttajaDao dao = new KayttajaDao();
			Kayttaja kayttaja = new Kayttaja();
			kayttaja.setEmail(email);
			kayttaja.setSalasana(salasana);
			boolean onnistuukoKirjautuminen = dao.kirjaudu(kayttaja);
			if (onnistuukoKirjautuminen) {
				RequestDispatcher disp = request
						.getRequestDispatcher("WEB-INF/salainen_sivu.jsp");
				disp.forward(request, response);
			} else {
				RequestDispatcher disp = request
						.getRequestDispatcher("login.jsp");
				disp.forward(request, response);
			}
		} else if (action.equals("Unohditko salasanasi?")) {
			String email = request.getParameter("email");
			Random random = new Random();
			int satunnainen = random.nextInt(2000000000);
			while (satunnainen < 1000000000) {
				satunnainen = random.nextInt(2000000000);
			}
			HttpSession session = request.getSession(false);
			if(session == null) {
				session = request.getSession();
				session.setAttribute("reset", satunnainen);
				session.setAttribute("email", email);
			} else {
				session.setAttribute("reset", satunnainen);
				session.setAttribute("email", email);
			}
			Email muistutusEmail = new Email();
			muistutusEmail.lahetaSahkoposti("88juslin", "88juslin!",
					email, "Salasanan resetointi",
					"Tällä tunnuksella saat resetoitua: " + satunnainen);
			RequestDispatcher disp = request
					.getRequestDispatcher("/WEB-INF/unohdus.jsp");
			disp.forward(request, response);
		} else if (action.equals("Resetoi")) {
			String resetSalasana = request.getParameter("resetsalasana");
			HttpSession session = request.getSession(false);
			if(session == null) {
				session = request.getSession();
			}
			String resetSalasanaSessiosta = session.getAttribute("reset").toString();
			if(resetSalasana.equals(resetSalasanaSessiosta)) {
				RequestDispatcher disp = request
						.getRequestDispatcher("/WEB-INF/uusisalasana.jsp");
				disp.forward(request, response);
			} else {
				RequestDispatcher disp = request
						.getRequestDispatcher("login.jsp");
				disp.forward(request, response);
			}

		} else if(action.equals("Aseta uusi salasana")) {
			String uusiSalasana = request.getParameter("uusisalasana");
			HttpSession session = request.getSession(false);
			if(session == null) {
				session = request.getSession();
			}
			KayttajaDao dao = new KayttajaDao();
			dao.resetoiSalasana(uusiSalasana, session.getAttribute("email").toString());
			
			RequestDispatcher disp = request
					.getRequestDispatcher("login.jsp");
			disp.forward(request, response);
			
		} else if(action.equals("Tallenna")) {
			String salasanaFormilta = request.getParameter("salasana");
			String email = request.getParameter("kayttajatunnus");
			Kayttaja kayttaja = new Kayttaja();
			kayttaja.setEmail(email);
			HttpSession session = request.getSession(false);
			if(session == null) {
				session = request.getSession();
			}
			KayttajaDao dao = new KayttajaDao();
			dao.rekisteroidy(kayttaja, salasanaFormilta);
			
			RequestDispatcher disp = request
					.getRequestDispatcher("login.jsp");
			disp.forward(request, response);
			
		} else {
			RequestDispatcher disp = request
					.getRequestDispatcher("virhe.jsp");
			disp.forward(request, response);	
		}
	}
}
