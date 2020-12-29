package vjb.de.vietjob.dao.uutinenDAO;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import vjb.de.vietjob.bean.uutinen.Uutinen;

public class Test {
       public static void main(String[] args){
    	   ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
   		   UutinenDaoImpl dao = (UutinenDaoImpl) context.getBean("uutinenDao");
   		   Uutinen u = new Uutinen();
   		   u.setAihe("hello");
   		   u.setSisalto("hello everyone!");
   		   context.close();
       }
}
