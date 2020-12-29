package vjb.de.vietjob.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vjb.de.vietjob.bean.duuni.Duuni;
import vjb.de.vietjob.bean.duuni.DuuniImpl;
import vjb.de.vietjob.bean.kayttaja.Kayttaja;
import vjb.de.vietjob.bean.kayttaja.KayttajaImpl;
import vjb.de.vietjob.bean.partneri.Partneri;
import vjb.de.vietjob.bean.partneri.PartneriImpl;
import vjb.de.vietjob.dao.alaDAO.AlaDao;
import vjb.de.vietjob.dao.duuniDAO.DuuniDao;
import vjb.de.vietjob.dao.kayttajaDAO.KayttajaDao;
import vjb.de.vietjob.dao.partneriDAO.PartneriDao;

@Controller
@RequestMapping(value="/")
public class PartneriController {
	@Inject
	private PartneriDao partneridao;
	@Inject
	private DuuniDao duunidao;
	@Inject
	private KayttajaDao kayttajadao;
	@Inject
	private AlaDao aladao;

	public AlaDao getAladao() {
		return aladao;
	}

	public void setAladao(AlaDao aladao) {
		this.aladao = aladao;
	}

	public KayttajaDao getKayttajadao() {
		return kayttajadao;
	}

	public void setKayttajadao(KayttajaDao kayttajadao) {
		this.kayttajadao = kayttajadao;
	}

	public DuuniDao getDuunidao() {
		return duunidao;
	}

	public void setDuunidao(DuuniDao duunidao) {
		this.duunidao = duunidao;
	}

	public PartneriDao getPartneridao() {
		return partneridao;
	}

	public void setPartneridao(PartneriDao partneridao) {
		this.partneridao = partneridao;
	}
	
	@RequestMapping(value="/secure/partner", method=RequestMethod.GET)
	public String getPartneriTiedot(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tunnus = auth.getName();
		Partneri partneri = partneridao.getPartneriByTunnus(tunnus);
		model.addAttribute("partneri", partneri);
		return "secure/partneri/partneri_home";
	}
	
	@RequestMapping(value={"/uusiduuni","secure/partner/uusiduuni"}, method=RequestMethod.GET)
	public String getUusiDuuni(Model model){
		Duuni duuni = new DuuniImpl();
		List<String> alaList = aladao.getListAlaNimi();
		model.addAttribute("alaList", alaList);
        model.addAttribute("duuni", duuni);
		return "secure/partneri/partneri_newjob";
	}
	
	@RequestMapping(value={"/uusiduuni","secure/partner/uusiduuni"}, method=RequestMethod.POST)
	public String postUusiDuuni(@ModelAttribute(value="duuni") @Valid DuuniImpl duuni, BindingResult result, @RequestParam(value="ala") String ala){
		if(result.hasErrors()){
			return "secure/partneri/partneri_newjob";
		} else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String tunnus = auth.getName();
			int partnerId = partneridao.getPartneriByTunnus(tunnus).getId();
			int alaId = aladao.getAlaId(ala);
            duunidao.postDuuni(duuni, partnerId, alaId);
		    return "redirect:/tyopaikat";
		}
	}
	
	@RequestMapping(value={"/postedjobs","secure/partner/postedjobs"}, method=RequestMethod.GET)
	public String showPostedDuunit(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tunnus = auth.getName();
		int id = partneridao.getPartneriByTunnus(tunnus).getId();
		List<Duuni> duuniList = duunidao.searchDuuniByPartneriId(id);
		model.addAttribute("duuniList", duuniList);
		return "secure/partneri/partneri_julkaistuduunit";
	}
	
	@RequestMapping(value={"/postedjobs","secure/partner/postedjobs"}, method=RequestMethod.POST)
	public String moveEditDuuni(@RequestParam(value="duuni_id")Integer duuni_id, Model model){
		model.addAttribute("duuni_id", duuni_id);
		return "redirect:jobedit";
	}
	
	@RequestMapping(value={"/jobedit","secure/partner/jobedit"}, method=RequestMethod.GET)
	public String receiveDuuniToEdit(@RequestParam(value="duuni_id")Integer duuni_id, Model model){
		Duuni duuni = duunidao.showYksiDuuni(duuni_id);
		model.addAttribute("duuni", duuni);
		return "secure/partneri/partneri_jobedit";
	}
	
	@RequestMapping(value={"/jobedit","secure/partner/jobedit"}, method=RequestMethod.POST)
	public String editDuuni(@ModelAttribute(value="duuni")@Valid DuuniImpl duuni, BindingResult result, Model model){
		if (result.hasErrors()){
			return "secure/partneri/partneri_jobedit";
		}else {
			duunidao.editDuuni(duuni);
			return "redirect:postedjobs";
		}
		
	}
	
	@RequestMapping(value={"tiedot","secure/partner/tiedot"}, method=RequestMethod.GET)
	public String showPartnerinTiedot(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tunnus = auth.getName();
		Partneri partneri = partneridao.getPartneriByTunnus(tunnus);
		Kayttaja kayttaja = kayttajadao.getKayttajaByTunnus(tunnus);
		
		model.addAttribute("kayttaja", kayttaja);
		model.addAttribute("partneri", partneri);
		return "secure/partneri/partneri_tieto";
	}
	
	@RequestMapping(value={"tiedot","secure/partner/tiedot"}, method=RequestMethod.POST)
	public String savePartnerinTiedot(@ModelAttribute(value="partneri") PartneriImpl partneri,@ModelAttribute(value="kayttaja") KayttajaImpl kayttaja, Model model){
		partneridao.updateTiedot(partneri);
		kayttajadao.updateTiedot(kayttaja);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String tunnus = auth.getName();
		Partneri uusipartneri = partneridao.getPartneriByTunnus(tunnus);
		Kayttaja uusikayttaja = kayttajadao.getKayttajaByTunnus(tunnus);
		model.addAttribute("kayttaja", uusikayttaja);
		model.addAttribute("partneri", uusipartneri);
		return "secure/partneri/partneri_tieto";
	}
	
	@ModelAttribute("sopimukset")
	public List<String> getSopimukset(){
		List<String> listSopimus = new ArrayList<String>();
		listSopimus.add("Osaaikainen");
		listSopimus.add("MŠŠrŠaikainen");
		listSopimus.add("Toistaiseksi");
		listSopimus.add("Vaakituinen");
		return listSopimus;
	}
	
	

}
