package vjb.de.vietjob.dao.mailDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vjb.de.vietjob.bean.mail.Mail;
import vjb.de.vietjob.bean.mail.MailImpl;

public class MailRowMapper implements RowMapper<Mail> {

	public Mail mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mail mail = new MailImpl();
		mail.setId(rs.getInt("mail_id"));
		mail.setName(rs.getString("mail_name"));
		mail.setSubject(rs.getString("mail_subject"));
		mail.setContent(rs.getString("mail_content"));
		return mail;
	}
      
}
