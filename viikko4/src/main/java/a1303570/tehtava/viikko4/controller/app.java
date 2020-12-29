package a1303570.tehtava.viikko4.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import a1303570.tehtava.viikko4.bean.Levy;
import a1303570.tehtava.viikko4.dao.LevyDao;

public class app {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"levy.xml");
		LevyDao dao = (LevyDao) context.getBean("daoLuokka");
		List<Levy> Levyt = dao.naytaListaLevy();
		for (Levy l : Levyt) {
			System.out.println(l.getId() + " | " + l.getNimi() + " | "
					+ l.getArtisti());
		}
		context.close();
	}

}
