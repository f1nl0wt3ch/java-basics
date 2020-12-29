package vjb.de.vietjob.functions;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;

import vjb.de.vietjob.bean.duuni.Duuni;
import vjb.de.vietjob.dao.duuniDAO.DuuniDao;

public class FunctionsImpl implements Functions {
	
	@Inject
	private DuuniDao duunidao;
	
	
	public DuuniDao getDuunidao() {
		return duunidao;
	}

	public void setDuunidao(DuuniDao duunidao) {
		this.duunidao = duunidao;
	}

	public String moveOikeanSivu(int rooliID) {
		String admin = "redirect:/admin.do";
		String partneri = "redirect:/partner.do";
		String ehdokas = "redirect:/employee.do";
		switch (rooliID) {
		case 1:
			return admin;
		case 2:
			return partneri;
		case 3:
			return ehdokas;
		default:
			return "redirect:/";
		}
	}

	public String adminAction(String submit, Model model, int id) {
		
		  List<String> listNimi = duunidao.getDuuniNimi();
		  List<String> listPaikka = duunidao.getPaikka();
		if(submit.equals("Poista")){
			System.out.println(duunidao);
			duunidao.deleteDuuni(id);
			List<Duuni> duuniList = duunidao.showDuunit();
			model.addAttribute("listNimi", listNimi);
			model.addAttribute("listPaikka", listPaikka);
			model.addAttribute("duunit", duuniList);
			return "admin/admin_jobs";
		} else if(submit.equals("Lisätieto")){
			return "admin/admin_jobs";
		} else if(submit.equals("Muokata")){
			return "admin/admin_jobs";
		} else {
			return "admin/admin_jobs";
		}
	}

}
