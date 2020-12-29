package vjb.de.vietjob.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vjb.de.vietjob.bean.duuni.Duuni;
import vjb.de.vietjob.bean.duuni.DuuniImpl;
import vjb.de.vietjob.dao.duuniDAO.DuuniDao;
import vjb.de.vietjob.functions.ThreadForLoopNimi;
import vjb.de.vietjob.functions.ThreadForLoopPaikka;
import vjb.de.vietjob.utils.SelectView;

@Controller
@RequestMapping(value = "/")
public class DuuniController {

	@Inject
	private DuuniDao duunidao;

	public DuuniDao getDuuniDao() {
		return this.duunidao;
	}

	public void setDuuniDao(DuuniDao duunidao) {
		this.duunidao = duunidao;
	}
	
	SelectView select = new SelectView();

	// Näyttä kaikki työpaikat, jotka ovat oleva tietokannasta
	@RequestMapping(value = {"/tyopaikat","*/*/tyopaikat","**/tyopaikat"}, method = RequestMethod.GET)
	public String showDuuni(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tunnus = auth.getName();
		List<String> listNimi = duunidao.getDuuniNimi();
		List<String> listPaikka = duunidao.getPaikka();
		List<Duuni> listDuuni = duunidao.showDuunit();
		
		model.addAttribute("listNimi", listNimi);
		model.addAttribute("duuni", new DuuniImpl());
		model.addAttribute("listDuuni", listDuuni);
		model.addAttribute("listPaikka", listPaikka);
		return select.returnViewDuunit(tunnus);
	}
	
	@RequestMapping(value={"/tyopaikat","*/*/tyopaikat","*/tyopaikat"}, method = RequestMethod.POST)
	public String showDuuniByPaikka(@ModelAttribute(value="duuni") DuuniImpl duuni, Model model) throws SQLException{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tunnus = auth.getName();
		String paikka = duuni.getPaikka();
		String nimi = duuni.getNimi();
		List<String> listPaikka = duunidao.getPaikka();
		List<String> listNimi = duunidao.getDuuniNimi();
		
		 ThreadForLoopNimi loopnimi = new ThreadForLoopNimi();
		 ThreadForLoopPaikka looppaikka = new ThreadForLoopPaikka();
			loopnimi.start();
			looppaikka.start();
		if(paikka.equals("Kaikki") || nimi.equals("Kaikki")){
			List<Duuni> listDuuni = duunidao.showDuunit();
			model.addAttribute("listDuuni", listDuuni);
			model.addAttribute("listPaikka", listPaikka);
			model.addAttribute("listNimi", listNimi);
			return select.returnViewDuunit(tunnus);
		} else {
			if(loopnimi.searchNimi(nimi, listNimi) == true && looppaikka.searchPaikka(paikka, listPaikka) == false){
				List<Duuni> listDuuni = duunidao.searchByNimi(nimi);
				model.addAttribute("listDuuni", listDuuni);
				model.addAttribute("listPaikka", listPaikka);
				model.addAttribute("listNimi", listNimi);
				return select.returnViewDuunit(tunnus);
			} else if (loopnimi.searchNimi(nimi, listNimi) == false && looppaikka.searchPaikka(paikka, listPaikka) == true){
				List<Duuni> listDuuni = duunidao.searchByPaikka(paikka);
				model.addAttribute("listDuuni", listDuuni);
				model.addAttribute("listPaikka", listPaikka);
				model.addAttribute("listNimi", listNimi);
				return select.returnViewDuunit(tunnus);
			}
			else if (loopnimi.searchNimi(nimi, listNimi) == true && looppaikka.searchPaikka(paikka, listPaikka) == true){
				List<Duuni> listDuuni = duunidao.searchDuuniByPaikkaAndNimi(paikka, nimi);
				model.addAttribute("listDuuni", listDuuni);
				model.addAttribute("listPaikka", listPaikka);
				model.addAttribute("listNimi", listNimi);
				return select.returnViewDuunit(tunnus);
			} else {
				List<Duuni> listDuuni = null;
				model.addAttribute("listDuuni", listDuuni);
				model.addAttribute("listPaikka", listPaikka);
				model.addAttribute("listNimi", listNimi);
				return select.returnViewDuunit(tunnus);
			}
				
		}
			
	}

	
	// Näyttää lisätietoja työpaikasta perustuu duunin id:lle
	@RequestMapping(value = {"/tyopaikka","*/*/tyopaikka","*/tyopaikka"}, method = RequestMethod.POST)
	public String getDuuniTiedot(
			@RequestParam(value = "id", required = false) Integer id, @RequestParam(value="submit") String submit,
			Model model) {
		if(submit.equals("More") || submit.equals("Lisätieto")){
			return "redirect:tyopaikka/"+id;
		} else if(submit.equals("Apply") || submit.equals("Laita hakemus")){
			model.addAttribute("duuni_id", id);
			return "redirect:hakemus/apply";
		}
		else {
			return "redirect:/tyopaikat";
		}
	}
	
	@RequestMapping(value = {"/tyopaikka/{id}","*/tyopaikka/{id}","*/*/tyopaikka/{id}"}, method = RequestMethod.GET)
	public String showDuuniTiedot(@PathVariable(value="id") Integer id, Model model){
		Duuni duuni = duunidao.showYksiDuuni(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tunnus = auth.getName();
		
		model.addAttribute("duuni", duuni);
		return select.returnViewYksiDuuni(tunnus);
	}
	


}
