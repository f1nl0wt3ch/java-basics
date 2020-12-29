package vjb.de.vietjob.dao.mailDAO;

import java.util.List;

import vjb.de.vietjob.bean.mail.Mail;

public interface MailDao {
     public Mail getMailById(int id);
     public void insertMail(Mail mail);
     public void deleteMailById(int id);
     public void editMailById(Mail mail);
     public List<Mail> getListMail();
}
