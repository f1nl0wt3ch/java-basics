package vjb.de.vietjob.dao.hakemusDAO;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import vjb.de.vietjob.bean.apply.Apply;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        HakemusDao dao = (HakemusDao) context.getBean("hakemusDao");
        List<Apply> applyList = dao.showListAppliedDuuni(1);
       
        
        for(Apply apply : applyList){
        	System.out.println(apply.getNimi());
        	System.out.println(apply.getHakemuspv());
        	System.out.println(apply.getTyopaikka());
        	System.out.println(apply.getHakupaattyy());
        }
        context.close();
	}

}
