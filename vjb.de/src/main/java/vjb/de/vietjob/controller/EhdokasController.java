package vjb.de.vietjob.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vjb.de.vietjob.bean.apply.Apply;
import vjb.de.vietjob.bean.ehdokas.Ehdokas;
import vjb.de.vietjob.bean.ehdokas.EhdokasImpl;
import vjb.de.vietjob.dao.duuniDAO.DuuniDao;
import vjb.de.vietjob.dao.ehdokasDAO.EhdokasDao;
import vjb.de.vietjob.dao.hakemusDAO.HakemusDao;
import vjb.de.vietjob.dao.kayttajaDAO.KayttajaDao;

@Controller
@RequestMapping(value = "/secure/employee")
public class EhdokasController {

	@Inject
	private EhdokasDao ehdokasdao;
	@Inject
	private HakemusDao hakemusdao;
	@Inject
	private KayttajaDao kayttajadao;
	@Inject
	private DuuniDao duunidao;
	


	public DuuniDao getDuunidao() {
		return duunidao;
	}

	public void setDuunidao(DuuniDao duunidao) {
		this.duunidao = duunidao;
	}

	public KayttajaDao getKayttajadao() {
		return kayttajadao;
	}

	public void setKayttajadao(KayttajaDao kayttajadao) {
		this.kayttajadao = kayttajadao;
	}

	public HakemusDao getHakemusdao() {
		return hakemusdao;
	}

	public void setHakemusdao(HakemusDao hakemusdao) {
		this.hakemusdao = hakemusdao;
	}

	public EhdokasDao getEhdokasDao() {
		return ehdokasdao;
	}

	public void setEhdokasDao(EhdokasDao ehdokasdao) {
		this.ehdokasdao = ehdokasdao;
	}
	
	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String showEmployeePage(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tunnus = auth.getName();
		EhdokasImpl ehdokas = (EhdokasImpl) ehdokasdao.getEhdokasByTunnus(tunnus);
		model.addAttribute("ehdokas", ehdokas);
		return "secure/ehdokas/ehdokas_home";
	}
    
	@RequestMapping(value="/applied", method=RequestMethod.GET)
	public String showAppliedDuunit(Model model){
		List<Apply> applyList = hakemusdao.showListAppliedDuuni(1);
		model.addAttribute("applyList", applyList);
		return "secure/ehdokas/ehdokas_apply";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String receiveTiedot(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tunnus = auth.getName();
		Ehdokas e = ehdokasdao.getEhdokasByTunnus(tunnus);
		model.addAttribute("ehdokas", e);
		return "secure/ehdokas/ehdokas_update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateTiedot(@ModelAttribute(value="ehdokas") EhdokasImpl ehdokas, Model model){
		ehdokasdao.editEhdokas(ehdokas);
		return "redirect:applied";
	}
	

	
	/*@RequestMapping(value = "/tyopaikat.do", method = RequestMethod.GET)
	public String showDuuni(Model model) {
		List<String> listNimi = duunidao.getDuuniNimi();
		List<String> listPaikka = duunidao.getPaikka();
		List<Duuni> listDuuni = duunidao.showDuunit();
		
		model.addAttribute("listNimi", listNimi);
		model.addAttribute("duuni", new DuuniImpl());
		model.addAttribute("listDuuni", listDuuni);
		model.addAttribute("listPaikka", listPaikka);
		return "public/duuni_list";
	}*/

}
