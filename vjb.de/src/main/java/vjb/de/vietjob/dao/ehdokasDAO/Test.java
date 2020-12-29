package vjb.de.vietjob.dao.ehdokasDAO;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import vjb.de.vietjob.bean.ehdokas.Ehdokas;
import vjb.de.vietjob.bean.ehdokas.EhdokasImpl;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		EhdokasDaoImpl dao = (EhdokasDaoImpl) context.getBean("ehdokasDao");
		Ehdokas e = new EhdokasImpl();
		e.setEtu("Dinh");
		e.setSuku("Duc");
		e.setOsoite("Keihästie 3");
		e.setSukupuoli("Mies");
		e.setKansalaisuus("Vietnamilainen");
		e.setKieli("Suomi");
		e.setKaupunki("Tampere");
		e.setId(1);
		e.setKansalaisuus("Vietnam");
		e.setSposti("babyface1m75@yahoo.com.vn");
		e.setKokemus(3);
		e.setTutkinto("päiväkoti");
		e.setPuh("+358445206766");
		
		dao.editEhdokas(e);
		
		context.close();
	}	

}
