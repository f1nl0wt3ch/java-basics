package vjb.de.vietjob.dao.partneriDAO;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		PartneriDaoImpl dao = (PartneriDaoImpl) context.getBean("partneriDao");
		int id = dao.getPartneriByTunnus("partneri").getId();
		System.out.println("partnerin id is "+id);
		context.close();
	}

}
