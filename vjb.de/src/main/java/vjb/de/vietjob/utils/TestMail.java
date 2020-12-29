package vjb.de.vietjob.utils;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import vjb.de.vietjob.bean.mail.Mail;
import vjb.de.vietjob.bean.mail.MailImpl;

public class TestMail {
	 
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ApplicationMailer app = (ApplicationMailer) context.getBean("applicationMailer");
		Mail mail = new MailImpl();
		mail.setContent("Hello test mail");
		mail.setSubject("Hello");
	    app.sendHtmlEmail(mail, "babyface1m75@yahoo.com.vn");
	    context.close();
	}
	
}
