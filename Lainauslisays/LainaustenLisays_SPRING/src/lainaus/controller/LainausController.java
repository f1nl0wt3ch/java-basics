package lainaus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lainaus.model.Lainaus;
import lainaus.model.NiteenLainaus;
import lainaus.model.dao.LainausDAO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lainaus.model.Asiakas;



/**
 * Servlet implementation class LainausController
 */
@Controller
@RequestMapping (value="/lainaukset")
public class LainausController extends HttpServlet {
	
	@Inject
	private LainausDAO dao;
	
	public LainausDAO getDao() {
		return dao;
	}

	public void setDao(LainausDAO dao) {
		this.dao = dao;
	}
	
	//kaikkien lainausten  NÄYTTÄMINEN
	// <a href="lainaukset/">Näytä lista asiakkaista</a>
	@RequestMapping(method=RequestMethod.GET)
	public String naytaLainauslista(Model model)  {
		List<Lainaus> lainauslista = this.dao.haeKaikki();
		
		model.addAttribute("lainauslista", lainauslista);
			System.out.println(lainauslista);
		return "kaikkiLainaukset";
	}
	//YKSITTÄISEN lainauksen TIETOJEN NÄYTTÄMINEN
	@RequestMapping(value="{numero}", method=RequestMethod.GET)
	public String naytaLainaus(@PathVariable Integer numero, Model model) {
			
			Lainaus lainaus = this.dao.etsi(numero);
			
			model.addAttribute("lainaus", lainaus);
			return "YksiLainaus";
		}
}
