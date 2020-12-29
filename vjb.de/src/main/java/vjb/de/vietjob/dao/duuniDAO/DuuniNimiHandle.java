package vjb.de.vietjob.dao.duuniDAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import vjb.de.vietjob.bean.duuni.Duuni;
import vjb.de.vietjob.bean.duuni.DuuniImpl;
import vjb.de.vietjob.dao.duuniDAO.DuuniDao;

public class DuuniNimiHandle {

	public static void main(String[] args) throws SQLException, ParseException {
		SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		DuuniDao dao = (DuuniDaoImpl) context.getBean("duuniDao");
		/*String dateStr="2012-12-12";
		Duuni duuni = new DuuniImpl();
		duuni.setNimi("Espoo");
		duuni.setErapv(fm.parse(dateStr));
		duuni.setPaikka("Espoo");
		duuni.setPalkka("2000/kk");
		duuni.setTiedot("World");
		duuni.setSopimus("Määräaikainen");
		duuni.setVaatimus("Ahkera");
		duuni.setId(9);
	    dao.editDuuni(duuni);*/
		
		
		/*String paikka = null;
		String nimi = "korjaaja";
		List<Duuni> duunit= dao.searchDuuniByPaikkaAndNimi(paikka, nimi);
	    
		System.out.println("Id"+" | "+"Työ"+" | "+"Paikka"+" | "+"Palkka"+" | "+"Julkistupäivä"+"\n");
		for(int i=0; i< duunit.size(); i++){
		      System.out.println(duunit.get(i).getId()+" | "+duunit.get(i).getNimi()+" | "+duunit.get(i).getPalkka()+" | "+fm.format(duunit.get(i).getJulkaistupv()));
		}*/
		
		List<Duuni> list = dao.searchDuuniByPartneriId(1);
		for(Duuni d: list){
			System.out.println(d.getNimi());
		}
		context.close();
		

	}

}
