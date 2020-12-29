package vjb.de.vietjob.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vjb.de.vietjob.bean.ehdokas.Ehdokas;
import vjb.de.vietjob.bean.ehdokas.EhdokasImpl;
import vjb.de.vietjob.bean.hakemus.Hakemus;
import vjb.de.vietjob.bean.hakemus.HakemusImpl;
import vjb.de.vietjob.dao.duuniDAO.DuuniDao;
import vjb.de.vietjob.dao.ehdokasDAO.EhdokasDao;
import vjb.de.vietjob.dao.hakemusDAO.HakemusDao;
import vjb.de.vietjob.dao.kayttajaDAO.KayttajaDao;

@Controller
@RequestMapping(value="/")
public class HakemusController {
      @Inject
      private HakemusDao hakemusdao;
      @Inject
      private KayttajaDao kayttajadao;
      @Inject
      private EhdokasDao ehdokasdao;
      @Inject
      private DuuniDao duunidao;
      

	public DuuniDao getDuunidao() {
		return duunidao;
	}

	public void setDuunidao(DuuniDao duunidao) {
		this.duunidao = duunidao;
	}

	public EhdokasDao getEhdokasdao() {
		return ehdokasdao;
	}

	public void setEhdokasdao(EhdokasDao ehdokasdao) {
		this.ehdokasdao = ehdokasdao;
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
	
	/*siirrä apply sivulle*/
	@RequestMapping(value={"hakemus/apply","*/*/hakemus/apply","*/hakemus/apply"}, method= RequestMethod.GET)
	public String forwardToApply(@RequestParam(value="duuni_id") Integer duuni_id, Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tunnus = auth.getName();
		Ehdokas ehdokas = ehdokasdao.getEhdokasByTunnus(tunnus);
		
		model.addAttribute("duuni_id", duuni_id);
		model.addAttribute("ehdokas_id", ehdokas.getId());
		model.addAttribute("ehdokas", ehdokas);
		return "applyForm";
	}
	
	@RequestMapping(value={"hakemus/apply","*/hakemus/apply","*/*/hakemus/apply"}, method= RequestMethod.POST)
	public String getInfoEmployee(@ModelAttribute(value="ehdokas") EhdokasImpl ehdokas,@RequestParam(value="ehdokas_id") Integer ehdokas_id, @RequestParam(value="duuni_id")Integer duuni_id, Model model){
		Hakemus hakemus = new HakemusImpl();
		hakemus.setDuuni_id(duuni_id);
		hakemus.setEhdokas_id(ehdokas_id);
		hakemusdao.insertHakemus(hakemus);
	return "redirect:/";
	}
	
}

