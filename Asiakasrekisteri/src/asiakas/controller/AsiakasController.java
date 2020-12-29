package asiakas.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import asiakas.model.dao.AsiakasDAO;
import asiakas.model.Asiakas;
import asiakas.model.AsiakasImpl;
import asiakas.model.dao.AsiakasDAO;

@Controller
@RequestMapping (value="/asiakkaat")
public class AsiakasController {
		
	@Inject
	private AsiakasDAO dao;
	
	public AsiakasDAO getDao() {
		return dao;
	}

	public void setDao(AsiakasDAO dao) {
		this.dao = dao;
	}
	
	
	//OSALLISTUJALISTAN NÄYTTÄMINEN
	// <a href="asiakkaat/">Näytä lista asiakkaista</a>
	@RequestMapping(method=RequestMethod.GET)
	public String naytaAsiakaslista(Model model)  {
		List<Asiakas> asiakaslista = this.dao.haeKaikki();
		model.addAttribute("asiakaslista", asiakaslista);
	//	System.out.println(asiakaslista);
		return "osa1/list";
	}

	//UUDEN LISÄÄMINEN - FORMIN TEKEMINEN
	// <a href="uusi"> <c:out value="Lisää uusi asiakas" /></a>
	@RequestMapping(value="/uusi", method=RequestMethod.GET)
	public String luoLomake(Model model) {
		Asiakas tyhjaAsiakas = new AsiakasImpl();	
		model.addAttribute("asiakas", tyhjaAsiakas);
		return "osa1/createForm";
	}
	
	//UUDEN LISÄÄMINEN - FORMIN TIETOJEN VASTAANOTTO
	/*
	 * <form:form modelAttribute="asiakas" action="uusi" method="post">
		  ...
					<input type="submit" value="Luo asiakas"/>
	 */
	@RequestMapping(value="/talleta", method=RequestMethod.GET)
	public String lisaaAsiakas(Model model, @ModelAttribute(value="asiakas") AsiakasImpl asiakas) {
	/*public String lisaaOsallistuja(Model model,
			 @RequestParam  (required=true, defaultValue="Sipe") String etunimi,
			 @RequestParam (required=true, defaultValue="Sininen") String sukunimi,
			 @RequestParam  (required=true, defaultValue="0400 111112222") String puhelinnumero) {
		OsallistujaImpl osallistuja = new OsallistujaImpl (etunimi, sukunimi, puhelinnumero);
		*/
		String paluu;
		boolean ok = true;
		if (asiakas.getEtunimi() == null )
		{
			ok = false;
			model.addAttribute("etunimiPuuttuu", true);
		}
		if (asiakas.getSukunimi ()== null)
		{
			ok = false;
			model.addAttribute("sukunimiPuuttuu", true);
		}
		if (asiakas.getOsoite()== null)
		{
			ok = false;
			model.addAttribute("osoitePuuttuu", true);
		}
		if (asiakas.getPosti().getPostinro()== null || asiakas.getPosti().getPostitmp()== null)
		{
			ok = false;
			model.addAttribute("postinroPuuttuu", true);
		}
		if (ok )
		{
			System.out.println(asiakas);
			this.dao.talleta(asiakas);
			paluu =  "redirect:/asiakkaat/";
		}
		else
		{
			model.addAttribute("asiakas", asiakas);
			paluu = "osa1/createForm";
		}
		return paluu;
	}
	
	//YKSITTÄISEN OSALLISTUJAN TIETOJEN NÄYTTÄMINEN
	@RequestMapping(value="{numero}", method=RequestMethod.GET)
	public String naytaAsiakas(@PathVariable Integer numero, Model model) {
		
		Asiakas asiakas = this.dao.etsi(numero);
		
		model.addAttribute("asiakas", asiakas);
		return "osa1/view";
	}

}
