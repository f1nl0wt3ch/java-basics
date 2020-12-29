package vjb.de.vietjob.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vjb.de.vietjob.bean.duuni.Duuni;
import vjb.de.vietjob.bean.duuni.DuuniImpl;
import vjb.de.vietjob.bean.ehdokas.Ehdokas;
import vjb.de.vietjob.bean.ehdokas.EhdokasImpl;
import vjb.de.vietjob.bean.mail.Mail;
import vjb.de.vietjob.bean.mail.MailImpl;
import vjb.de.vietjob.bean.uutinen.Uutinen;
import vjb.de.vietjob.dao.duuniDAO.DuuniDao;
import vjb.de.vietjob.dao.ehdokasDAO.EhdokasDao;
import vjb.de.vietjob.dao.kayttajaDAO.KayttajaDao;
import vjb.de.vietjob.dao.mailDAO.MailDao;
import vjb.de.vietjob.dao.uutinenDAO.UutinenDao;
import vjb.de.vietjob.functions.ThreadForLoopKaupunki;
import vjb.de.vietjob.functions.ThreadForLoopNimi;
import vjb.de.vietjob.functions.ThreadForLoopPaikka;
import vjb.de.vietjob.utils.ImageUpload;
import vjb.de.vietjob.utils.ImageUploadException;

/**
 * Metodit: public String moveAdminPage(Model model) public String
 * showDuuni(Model model)
 *
 */
@Controller
@RequestMapping(value = "/")
public class AdminController {
	@Inject
	private DuuniDao duunidao;
	@Inject
	private KayttajaDao kayttajadao;
	@Inject
	private EhdokasDao ehdokasdao;
	@Inject
	private UutinenDao uutinendao;
	@Inject
	private MailDao maildao;

	public MailDao getMaildao() {
		return maildao;
	}

	public void setMaildao(MailDao maildao) {
		this.maildao = maildao;
	}

	public UutinenDao getUutinendao() {
		return uutinendao;
	}

	public void setUutinendao(UutinenDao uutinendao) {
		this.uutinendao = uutinendao;
	}

	public DuuniDao getDuuniDao() {
		return this.duunidao;
	}

	public void setDuuniDao(DuuniDao duunidao) {
		this.duunidao = duunidao;
	}

	public EhdokasDao getEhdokasDao() {
		return ehdokasdao;
	}

	public void setEhdokasDao(EhdokasDao ehdokasdao) {
		this.ehdokasdao = ehdokasdao;
	}

	public KayttajaDao getKayttajaDao() {
		return this.kayttajadao;
	}

	public void setKayttajaDao(KayttajaDao kayttajadao) {
		this.kayttajadao = kayttajadao;
	}

	/**
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/secure/admin", method = RequestMethod.GET)
	public String getUutinen(Model model) {
		model.addAttribute("uutiset", uutinendao.showUutiset());
		model.addAttribute("uutinen", new Uutinen());
		return "secure/admin/admin_home";
	}

	@RequestMapping(value = "/secure/admin", method = RequestMethod.POST)
	public String postUutinen(
			@ModelAttribute(value = "uutinen") @Valid Uutinen uutinen,
			BindingResult result,
			@RequestParam(value = "kuva", required = false) MultipartFile kuva,
			Model model) {
		ImageUpload imageupload = new ImageUpload();
		SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
		if (!kuva.isEmpty()) {
			try {
				imageupload.validateKuva(kuva);
				imageupload.saveKuva(
						uutinen.getId() + "-" + fm.format(uutinen.getPaiva())
								+ ".jpg", kuva);
				if (!result.hasErrors()) {
					String link = uutinen.getId() + ".jpg";
					System.out.println("Id "+ uutinen.getId());
					uutinendao.postNew(uutinen, link);
				}
			} catch (ImageUploadException e) {
				result.reject(e.getMessage());
				return "secure/admin/admin_home";
			}
		}
		return "redirect:admin";
	}

	/*********************** Jobs control **********************************************/
	@RequestMapping(value = { "/joblist", "secure/admin/joblist",
			"secure/joblist" }, method = RequestMethod.GET)
	public String showDuuni(Model model) {
		List<String> listNimi = duunidao.getDuuniNimi();
		List<String> listPaikka = duunidao.getPaikka();
		List<Duuni> listDuuni = duunidao.showDuunit();

		List<Duuni> duunit = new ArrayList<Duuni>();
		duunit = duunidao.showDuunit();
		model.addAttribute("duuni", new DuuniImpl());
		model.addAttribute("listNimi", listNimi);
		model.addAttribute("listDuuni", listDuuni);
		model.addAttribute("listPaikka", listPaikka);
		model.addAttribute("duunit", duunit);
		return "secure/admin/admin_joblist";
	}

	@RequestMapping(value = { "/joblist", "secure/admin/joblist",
			"secure/joblist" }, method = RequestMethod.POST)
	public String jobSearch(@ModelAttribute(value = "duuni") DuuniImpl duuni,
			Model model) throws SQLException {
		String paikka = duuni.getPaikka();
		String nimi = duuni.getNimi();
		List<String> listNimi = duunidao.getDuuniNimi();
		List<String> listPaikka = duunidao.getPaikka();

		ThreadForLoopNimi loopnimi = new ThreadForLoopNimi();
		ThreadForLoopPaikka looppaikka = new ThreadForLoopPaikka();
		loopnimi.start();
		looppaikka.start();
		if (paikka.equals("Kaikki") || nimi.equals("Kaikki")) {
			List<Duuni> listDuuni = duunidao.showDuunit();
			model.addAttribute("listDuuni", listDuuni);
			model.addAttribute("listPaikka", listPaikka);
			model.addAttribute("listNimi", listNimi);
			return "secure/admin/admin_joblist";
		} else {
			if (loopnimi.searchNimi(nimi, listNimi) == true
					&& looppaikka.searchPaikka(paikka, listPaikka) == false) {
				List<Duuni> listDuuni = duunidao.searchByNimi(nimi);
				model.addAttribute("listDuuni", listDuuni);
				model.addAttribute("listPaikka", listPaikka);
				model.addAttribute("listNimi", listNimi);
				return "secure/admin/admin_joblist";
			} else if (loopnimi.searchNimi(nimi, listNimi) == false
					&& looppaikka.searchPaikka(paikka, listPaikka) == true) {
				List<Duuni> listDuuni = duunidao.searchByPaikka(paikka);
				model.addAttribute("listDuuni", listDuuni);
				model.addAttribute("listPaikka", listPaikka);
				model.addAttribute("listNimi", listNimi);
				return "secure/admin/admin_joblist";
			} else if (loopnimi.searchNimi(nimi, listNimi) == true
					&& looppaikka.searchPaikka(paikka, listPaikka) == true) {
				List<Duuni> listDuuni = duunidao.searchDuuniByPaikkaAndNimi(
						paikka, nimi);
				model.addAttribute("listDuuni", listDuuni);
				model.addAttribute("listPaikka", listPaikka);
				model.addAttribute("listNimi", listNimi);
				return "secure/admin/admin_joblist";
			} else {
				List<Duuni> listDuuni = null;
				model.addAttribute("listDuuni", listDuuni);
				model.addAttribute("listPaikka", listPaikka);
				model.addAttribute("listNimi", listNimi);
				return "secure/admin/admin_joblist";
			}
		}

	}

	@RequestMapping(value = { "/jobaction", "secure/admin/jobaction",
			"secure/jobaction" }, method = RequestMethod.POST)
	public String doDuuni(Model model,
			@RequestParam(value = "id", required = false) Integer id,
			@ModelAttribute(value = "duuni") DuuniImpl duuni,
			@RequestParam(value = "submit") String submit) throws SQLException {
		List<String> listNimi = duunidao.getDuuniNimi();
		List<String> listPaikka = duunidao.getPaikka();
		if (submit.equals("Poista") || submit.equals("Delete")) {
			duunidao.deleteDuuni(id);
			List<Duuni> listDuuni = duunidao.showDuunit();
			model.addAttribute("duuni", new DuuniImpl());
			model.addAttribute("listNimi", listNimi);
			model.addAttribute("listDuuni", listDuuni);
			model.addAttribute("listPaikka", listPaikka);
			return "secure/admin/admin_joblist";

		} else if (submit.equals("Muokkaa") || submit.equals("Edit")) {
			model.addAttribute("id", id);
			return "redirect:jobedit";
		} else {
			List<Duuni> listDuuni = duunidao.showDuunit();
			model.addAttribute("duuni", new DuuniImpl());
			model.addAttribute("listNimi", listNimi);
			model.addAttribute("listDuuni", listDuuni);
			model.addAttribute("listPaikka", listPaikka);
			return "secure/admin/admin_joblist";
		}

	}

	@RequestMapping(value = { "jobedit", "secure/admin/jobedit",
			"secure/jobedit" }, method = RequestMethod.GET)
	public String editDuuni(Model model, @RequestParam(value = "id") Integer id) {
		Duuni duuni = duunidao.showYksiDuuni(id);
		model.addAttribute("duuni", duuni);
		return "secure/admin/admin_jobedit";
	}

	@RequestMapping(value = { "jobedit", "secure/admin/jobedit",
			"secure/jobedit" }, method = RequestMethod.POST)
	public String saveDuuni(
			@ModelAttribute(value = "duuni") @Valid DuuniImpl duuni,
			BindingResult result) {
		if (result.hasErrors()) {
			return "secure/admin/admin_jobedit";
		} else {
			duunidao.editDuuni(duuni);
			return "redirect:joblist";
		}
	}

	/*********************** Employees control **********************************************/

	@RequestMapping(value = { "/employeeaction",
			"secure/admin/employeeaction", "secure/employeeaction" }, method = RequestMethod.POST)
	public String doEhdokas(Model model,
			@RequestParam(value = "id", required = false) Integer id,
			@ModelAttribute(value = "ehdokas") EhdokasImpl ehdokas,
			@RequestParam(value = "submit") String submit) {
		List<String> kaupunkiList = ehdokasdao.getKotiKaupunki();
		if (submit.equals("Delete") || submit.equals("Poista")) {
			ehdokasdao.deleteEhdokasById(id);
			List<Ehdokas> ehdokasList = ehdokasdao.showKaikkiEhdokkaat();
			model.addAttribute("ehdokas", new EhdokasImpl());
			model.addAttribute("kaupunkiList", kaupunkiList);
			model.addAttribute("ehdokasList", ehdokasList);
			return "secure/admin/admin_employeelist";
		} else if (submit.equals("Muokka") || submit.equals("Edit")) {
			model.addAttribute("id", id);
			return "redirect:employeeedit";
		}
		return null;
	}

	
	@RequestMapping(value = {"employeeedit","secure/admin/employeeedit"}, method = RequestMethod.GET)
	public String editEmployee(@RequestParam(value="id") Integer id, Model model){
		Ehdokas ehdokas = ehdokasdao.searchEhdokasById(id);
		model.addAttribute("ehdokas", ehdokas);
		return "secure/admin/admin_employeeedit";
	}

	@RequestMapping(value =  {"employeeedit","secure/admin/employeeedit"}, method = RequestMethod.POST)
	public String saveEhdokas(
			@ModelAttribute(value = "ehdokas") @Valid EhdokasImpl ehdokas,
			BindingResult result) {
		if (result.hasErrors()) {
			return "secure/admin/admin_employeeedit";
		} else {
			ehdokasdao.editEhdokas(ehdokas);
			return "redirect:employeelist";
		}
	}

	@RequestMapping(value = { "/employeelist",
			"secure/admin/employeelist", "secure/employeelist" }, method = RequestMethod.GET)
	public String showEmployees(Model model) {
		List<String> kaupunkiList = ehdokasdao.getKotiKaupunki();
		List<Ehdokas> ehdokasList = ehdokasdao.showKaikkiEhdokkaat();

		model.addAttribute("kaupunkiList", kaupunkiList);
		model.addAttribute("ehdokasList", ehdokasList);
		model.addAttribute("ehdokas", new EhdokasImpl());
		return "secure/admin/admin_employeelist";
	}

	@RequestMapping(value = { "/employeelist",
			"secure/admin/employeelist", "secure/employeelist" }, method = RequestMethod.POST)
	public String searchEmployee(
			@ModelAttribute(value = "ehdokas") EhdokasImpl ehdokas,
			@RequestParam(value = "kaupunki") String kaupunki, Model model) {
		List<String> kaupunkiList = ehdokasdao.getKotiKaupunki();
		ThreadForLoopKaupunki loopkaupunki = new ThreadForLoopKaupunki();
		if (kaupunki.equals("Kaikki")) {
			List<Ehdokas> ehdokasList = ehdokasdao.showKaikkiEhdokkaat();
			model.addAttribute("ehdokasList", ehdokasList);
			model.addAttribute("kaupunkiList", kaupunkiList);
			return "secure/admin/admin_employeelist";
		} else {
			if (loopkaupunki.searchKaupunki(kaupunki, kaupunkiList) == true) {
				List<Ehdokas> ehdokasList = ehdokasdao
						.getEhdokasByKaupunki(kaupunki);
				model.addAttribute("ehdokasList", ehdokasList);
				model.addAttribute("kaupunkiList", kaupunkiList);
				return "secure/admin/admin_employeelist";
			} else {
				List<Ehdokas> ehdokasList = null;
				model.addAttribute("ehdokasList", ehdokasList);
				model.addAttribute("kaupunkiList", kaupunkiList);
				return "secure/admin/admin_employeelist";
			}
		}

	}

	@RequestMapping(value = { "/deletenew", "secure/admin/deletenew",
			"secure/deletenew" }, method = RequestMethod.POST)
	public String deleteNew(Model model, @RequestParam(value = "id") Integer id) {
		uutinendao.deleteNew(id);
		List<Uutinen> uutiset = uutinendao.showUutiset();
		model.addAttribute("uutinen", new Uutinen());
		model.addAttribute("uutiset", uutiset);
		return "redirect:secure/admin";
	}

	@RequestMapping(value = {"/email","/secure/admin/email","**/email"}, method = RequestMethod.GET)
	public String doEmail(Model model) {
		Mail mail = new MailImpl();
		List<Mail> mailList = maildao.getListMail();

		model.addAttribute("mailList", mailList);
		model.addAttribute("mail", mail);
		return "secure/admin/admin_email";
	}

}
