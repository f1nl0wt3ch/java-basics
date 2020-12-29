package vjb.de.vietjob.utils;

import java.util.List;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import vjb.de.vietjob.bean.mail.Mail;

@Repository
public class ApplicationMailer {
	
    @Inject
    private JavaMailSender mailSender;
    
  
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(Mail mail, String to){
		SimpleMailMessage message = new SimpleMailMessage();
		  message.setTo(to);
    	  message.setSubject(mail.getSubject());
    	  message.setText(mail.getContent());
    	  mailSender.send(message);
      }

    public void sendMoreMails(Mail mail, List<String> toList){
    	SimpleMailMessage message = new SimpleMailMessage();
    	message.setSubject(mail.getSubject());
    	message.setText(mail.getContent());
    	for (String to : toList){
    		message.setTo(to);
    		mailSender.send(message);
    	}
    }
    
    public void receiveMail(Mail mail, String from){
    	SimpleMailMessage message = new SimpleMailMessage();
    	message.setFrom(from);
    	message.setSubject(mail.getSubject());
  	    message.setText(mail.getContent());
  	    message.setTo("habanero.pizzarien@gmail.com");
  	    System.out.println(mailSender);
  	    mailSender.send(message);
    }
    
    public void sendHtmlEmail(Mail mail, String to){
    	MimeMessage message = mailSender.createMimeMessage();
    	try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getContent(),true);
			mailSender.send(message);
		} catch (MessagingException e) {
           Logger.getLogger(ApplicationMailer.class.getName()).log(null, e);
		} 
    	
    }
}
