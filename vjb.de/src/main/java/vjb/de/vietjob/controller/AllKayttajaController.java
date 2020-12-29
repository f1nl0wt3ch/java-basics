package vjb.de.vietjob.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vjb.de.vietjob.bean.duuni.Duuni;
import vjb.de.vietjob.bean.duuni.DuuniImpl;
import vjb.de.vietjob.bean.ehdokas.Ehdokas;
import vjb.de.vietjob.bean.ehdokas.EhdokasImpl;
import vjb.de.vietjob.bean.hakemus.HakemusImpl;
import vjb.de.vietjob.bean.kayttaja.Kayttaja;
import vjb.de.vietjob.bean.kayttaja.KayttajaImpl;
import vjb.de.vietjob.bean.mail.Mail;
import vjb.de.vietjob.bean.mail.MailImpl;
import vjb.de.vietjob.bean.uutinen.Uutinen;
import vjb.de.vietjob.dao.alaDAO.AlaDao;
import vjb.de.vietjob.dao.duuniDAO.DuuniDao;
import vjb.de.vietjob.dao.ehdokasDAO.EhdokasDao;
import vjb.de.vietjob.dao.hakemusDAO.HakemusDao;
import vjb.de.vietjob.dao.kayttajaDAO.KayttajaDao;
import vjb.de.vietjob.dao.tutkintoDAO.TutkintoDao;
import vjb.de.vietjob.dao.uutinenDAO.UutinenDao;
import vjb.de.vietjob.functions.ThreadForLoopKaupunki;
import vjb.de.vietjob.utils.ApplicationMailer;
import vjb.de.vietjob.utils.SelectView;

@Controller
@RequestMapping(value = "/")
public class AllKayttajaController {

	@Inject
	private KayttajaDao kayttajadao;
	@Inject
	private DuuniDao duunidao;
	@Inject
	private EhdokasDao ehdokasdao;
	@Inject
	private AlaDao aladao;
	@Inject
	private HakemusDao hakemusdao;
	@Inject
	private ApplicationMailer applicationmailer;
	@Inject
	private UutinenDao uutinendao;
	@Inject
	private TutkintoDao tutkintodao;
	
	
	

	public TutkintoDao getTutkintodao() {
		return tutkintodao;
	}

	public void setTutkintodao(TutkintoDao tutkintodao) {
		this.tutkintodao = tutkintodao;
	}

	public UutinenDao getUutinendao() {
		return uutinendao;
	}

	public void setUutinendao(UutinenDao uutinendao) {
		this.uutinendao = uutinendao;
	}

	public ApplicationMailer getApplicationmailer() {
		return applicationmailer;
	}

	public void setApplicationmailer(ApplicationMailer applicationmailer) {
		this.applicationmailer = applicationmailer;
	}

	public HakemusDao getHakemusdao() {
		return hakemusdao;
	}

	public void setHakemusdao(HakemusDao hakemusdao) {
		this.hakemusdao = hakemusdao;
	}

	public AlaDao getAlaDao() {
		return aladao;
	}

	public void setAlaDao(AlaDao aladao) {
		this.aladao = aladao;
	}

	public EhdokasDao getEhdokasdao() {
		return ehdokasdao;
	}

	public void setEhdokasdao(EhdokasDao ehdokasdao) {
		this.ehdokasdao = ehdokasdao;
	}

	public KayttajaDao getKayttajaDao() {
		return this.kayttajadao;
	}

	public void setKayttajaDao(KayttajaDao kayttajadao) {
		this.kayttajadao = kayttajadao;
	}

	public DuuniDao getDuuniDao() {
		return this.duunidao;
	}

	public void setDuuniDao(DuuniDao duunidao) {
		this.duunidao = duunidao;
	}

	SelectView select = new SelectView();

	// Siirtä login sivulle
	@RequestMapping(value = { "/login.do","/*/login.do","/*/*/login.do" }, method = RequestMethod.GET)
	public String moveLogin(Model model) {
		return "login";
	}
    
	@RequestMapping(value = { "/tarkastus","*/tarkastus","*/*/tarkastus" }, method = RequestMethod.POST)
	public String forwardLogin(Model model) {
		return "redirect:login.do";
	}
	
	@RequestMapping(value = "/loginfail", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("loginerror","true");
		return "login";

	}

	@RequestMapping(value = { "/logout", "*/logout", "*/*/logout" }, method = RequestMethod.GET)
	public String returnHomePage() {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage(Model model) {
		return "index";
	}

	@RequestMapping(value = "/public", method = RequestMethod.GET)
	public String paasivu(
			Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		int rooli = kayttajadao.getRooliIdByTunnus(auth.getName());
		/*
		 * User user = (User)
		 * SecurityContextHolder.getContext().getAuthentication
		 * ().getPrincipal(); String tunnus = user.getUsername();
		 */
		switch (rooli) {
		case 1:
			return "redirect:secure/admin";
		case 2:
			return "redirect:secure/partner";
		case 3:
			return "redirect:secure/employee";
		default:
			return "secure/main";
		}

	}
	
	@RequestMapping(value="reset", method= RequestMethod.GET)
	public String showResetPassword(Model model){
		Kayttaja kayttaja = new KayttajaImpl();
		model.addAttribute("kayttaja", kayttaja);
		return "pass";
	}
	
	@RequestMapping(value="", method= RequestMethod.POST)
	public String resetPassword(Model model){
		return null;
	}

	// Näytä kaikki ehdokkaat tietokannasta
	@RequestMapping(value = {"/ehdokas", "*/ehdokas", "*/*/ehdokas" }, method = RequestMethod.GET)
	public String showEhdokkaat(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String tunnus = auth.getName();
		List<String> kaupunkiList = ehdokasdao.getKotiKaupunki();
		List<Ehdokas> ehdokkaat = ehdokasdao.showKaikkiEhdokkaat();
		model.addAttribute("ehdokkaat", ehdokkaat);
		model.addAttribute("kaupunkiList", kaupunkiList);
		model.addAttribute("ehdokas", new EhdokasImpl());
		return select.returnViewEhdokkaat(tunnus);
	}


	@RequestMapping(value = { "/ehdokas","*/ehdokas", "*/*/ehdokas" }, method = RequestMethod.POST)
	public String showEhdokkaat(
			@ModelAttribute(value = "ehdokas") EhdokasImpl ehdokas,
			@RequestParam(value = "kaupunki") String kaupunki, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String tunnus = auth.getName();
		List<String> kaupunkiList = ehdokasdao.getKotiKaupunki();
		ThreadForLoopKaupunki loopkaupunki = new ThreadForLoopKaupunki();
		if (kaupunki.equals("Kaikki")) {
			List<Ehdokas> ehdokkaat = ehdokasdao.showKaikkiEhdokkaat();
			model.addAttribute("ehdokkaat", ehdokkaat);
			model.addAttribute("kaupunkiList", kaupunkiList);
			return select.returnViewEhdokkaat(tunnus);
		} else {
			if (loopkaupunki.searchKaupunki(kaupunki, kaupunkiList) == true) {
				List<Ehdokas> ehdokkaat = ehdokasdao
						.getEhdokasByKaupunki(kaupunki);
				model.addAttribute("ehdokkaat", ehdokkaat);
				model.addAttribute("kaupunkiList", kaupunkiList);
				return select.returnViewEhdokkaat(tunnus);
			} else {
				List<Ehdokas> ehdokkaat = null;
				model.addAttribute("ehdokkaat", ehdokkaat);
				model.addAttribute("kaupunkiList", kaupunkiList);
				return select.returnViewEhdokkaat(tunnus);
			}
		}
	}

	@RequestMapping(value = { "/yksiehdokas", "*/*/yksiehdokas",
			"*/yksiehdokas" }, method = RequestMethod.POST)
	public String showYksiEhdokas(@RequestParam(value = "id") Integer id) {
		return "redirect:yksiehdokas/" + id;
	}

	@RequestMapping(value = { "/yksiehdokas/{id}", "*/yksiehdokas/{id}","*/*/yksiehdokas/{id}" }, method = RequestMethod.GET)
	public String showEhdokasById(Model model,
			@PathVariable(value = "id") Integer id) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String tunnus = auth.getName();
		Ehdokas ehdokas = ehdokasdao.searchEhdokasById(id);
		model.addAttribute("ehdokas", ehdokas);
		return select.returnViewYksiEhdokas(tunnus);
	}

	// Siirtää ehdokas lomake sivulle
	@RequestMapping(value = { "/lomake","*/*/lomake","*/lomake" }, method = RequestMethod.GET)
	public String showLomake(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String tunnus = auth.getName();
		Ehdokas ehdokas = ehdokasdao.getEhdokasByTunnus(tunnus);
		List<String> alaList = aladao.getListAlaNimi();
		List<String> tutkintoList = tutkintodao.showTutkinnot();
		
		model.addAttribute("tutkintoList", tutkintoList);
		model.addAttribute("alaList", alaList);
		model.addAttribute("ehdokas", ehdokas);
		return "secure/ehdokas/ehdokas_lomake";
	}
	
	// ota syötetyt tiedot lomakkeesta
	@RequestMapping(value = { "/lomake", "*/lomake",
			"*/*/lomake" }, method = RequestMethod.POST)
	public String getTietoLomake(
			@ModelAttribute(value = "ehdokas") @Valid EhdokasImpl ehdokas,
			BindingResult result, Model model,
			@RequestParam(value = "ala") String ala) {

		if (result.hasErrors()) {
			return "secure/ehdokas/ehdokas_lomake";
		} else {
			int alaId = aladao.getAlaId(ala);
			ehdokasdao.postEhdokas(ehdokas, alaId);
			return "redirect:/ehdokas";
		}
	}

	@RequestMapping(value = "/duunintiedot/{id}", method = RequestMethod.GET)
	public String naytaYksiDuuni(@PathVariable(value = "id") int id, Model model) {
		Duuni duuni = duunidao.showYksiDuuni(id);
		model.addAttribute("duuni", duuni);
		return "duuni/yksipaikka";
	}

	// Siirrä ilmoittautumissivulle
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String moveIlmoittatumis(Model model) {
		Kayttaja kayttaja = new KayttajaImpl();
		model.addAttribute("kayttaja", kayttaja);
		return "register";
	}

	// Luoda uusi käyttäjä
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String insertUusiKayttaja(
			@ModelAttribute(value = "kayttaja") @Valid KayttajaImpl kayttaja,
			BindingResult rs, Model model) {
		    Mail mail = new MailImpl();
		     String to = kayttaja.getSposti();
		     String subject = "Tervetuloa VietJob.fi";
		     String content  = "<html>"+
		                       "<head>"+
		                       "<meta http-equiv="+"\"Content-Type\""+"content="+"\"text/html; charset=UTF-8\""+">"+
		    		           "</head>"+
		    		           "<body>Hei "+ kayttaja.getEtu()+" "+kayttaja.getSuku()+",<br>"+
		                       "Kiitos että tulla meidän jäseniksi. Tällä on sinun tunnuksesi <b>"+kayttaja.getTunnus()+"</b><br>"+
		    		           "Nyt pystyt luoda oma lomake ja lähetä hakemuksesi työpaikkaan.<br>"+
		                       "Ystävällisin terveisin.<br>"+
		    		           "<b>Vietjob.fi</b></body></html>";
		     mail.setSubject(subject);
		     mail.setContent(content);
		if (rs.hasErrors()) {
			return "register";
		} else {
			String tunnus = kayttaja.getTunnus();
			if (kayttajadao.onkoKayttaja(tunnus) == null) {
				kayttajadao.insertKayttaja(kayttaja);
				applicationmailer.sendHtmlEmail(mail, to);
				return "redirect:/";
			} else {
				return "redirect:/error";
			}
		}

	}
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String forwardRegister(Model model){
		Kayttaja kayttaja = new KayttajaImpl();
		String virhe = "Tunnus on rekisteröyty, unohdatko salasana?!";
		model.addAttribute("virhe", virhe);
		model.addAttribute("kayttaja", kayttaja);
		return "register";
	}

	@RequestMapping(value = "/sendCV", method = RequestMethod.GET)
	public String checkCV(
			@ModelAttribute(value = "kayttaja") KayttajaImpl kayttaja,
			@RequestParam(value = "duuni_id", required = false) Integer duuni_id,
			Model model) {
		return null;
	}

	@RequestMapping(value = "/sendCV", method = RequestMethod.POST)
	public String receiveCV(@RequestParam(value = "duuni_id") Integer duuni_id,
			@RequestParam(value = "ehdokas_id") Integer ehdokas_id,
			@ModelAttribute(value = "ehdokas") EhdokasImpl ehdokas, Model model) {
		HakemusImpl hakemus = new HakemusImpl();
		hakemus.setEhdokas_id(ehdokas_id);
		hakemus.setDuuni_id(duuni_id);
		if (hakemusdao.checkAppliedOrNot(hakemus) == false) {
			ehdokasdao.editEhdokas(ehdokas);
			hakemusdao.insertHakemus(hakemus);
			return "redirect:tyopaikat";
		}

		return "redirect:/";
	}

	// show and get feedback from user
	@RequestMapping(value = "/palaute", method = RequestMethod.GET)
	public String doPalaute(Model model) {
		Mail mail = new MailImpl();
		model.addAttribute("mail", mail);
		return "feedback";
	}

	@RequestMapping(value = "/palaute", method = RequestMethod.POST)
	public String getPalaute(@ModelAttribute(value = "mail") MailImpl mail,
			@RequestParam(value = "from") String from, Model model) {
		applicationmailer.receiveMail(mail, from);
		return "redirect:/";
	}
	
	@RequestMapping(value = {"/news","*/news","**/news"}, method = RequestMethod.GET)
	public String showNew(Model model){
		List<Uutinen> uutiset = uutinendao.showUutiset();
		model.addAttribute("uutiset", uutiset);
		return "new";
	}
}
