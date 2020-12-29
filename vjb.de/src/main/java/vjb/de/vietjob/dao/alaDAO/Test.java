package vjb.de.vietjob.dao.alaDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		AlaDao dao = (AlaDao) context.getBean("alaDao");
		System.out.println(dao.getAlaId("IT"));
		/*List<String> list = new ArrayList<String>();
		list = dao.getListAlaNimi();
		for(int i=0; i< list.size(); i++){
	    System.out.println(list.get(i));
		}*/
		context.close();
	}
   
}
