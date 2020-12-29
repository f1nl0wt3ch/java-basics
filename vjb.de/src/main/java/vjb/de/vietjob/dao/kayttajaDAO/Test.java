package vjb.de.vietjob.dao.kayttajaDAO;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		KayttajaDao kayttajadao = (KayttajaDao) context.getBean("kayttajaDao");
		
        System.out.println(kayttajadao.getKayttajanRooliId("admin"));
        System.out.println(kayttajadao.getKayttajanRooliId("partneri"));
        System.out.println(kayttajadao.getKayttajanRooliId("ehdokas"));
        System.out.println(kayttajadao.getKayttajaByTunnus("partneri").getSposti());
		context.close();
	}
     
}
