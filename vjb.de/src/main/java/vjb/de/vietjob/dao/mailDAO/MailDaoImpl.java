package vjb.de.vietjob.dao.mailDAO;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vjb.de.vietjob.bean.mail.Mail;

@Repository
public class MailDaoImpl implements MailDao {
	@Inject
    private JdbcTemplate jdbcTemplate;
	  public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
	public Mail getMailById(int id) {
        String sql = "select * from mail where mail_id=?";
        Object[] ob = new Object[]{id};
        RowMapper<Mail> rm = new MailRowMapper();
        return jdbcTemplate.queryForObject(sql, rm, ob);
	}

	public void insertMail(Mail mail) {
		String sql = "insert into mail(mail_subject, mail_content, mail_name) values (?,?,?)";
		String subject = mail.getSubject();
		String content = mail.getContent();
		String name = mail.getName();
		Object[] ob = new Object[]{subject,content,name};
		jdbcTemplate.update(sql, ob);
	}

	public void deleteMailById(int id) {
		String sql = "delete from mail where mail_id=?";
		Object[] ob = new Object[]{id};
		jdbcTemplate.update(sql,ob);
		
	}

	public void editMailById(Mail mail) {
		String sql = "update mail set mail_subject=?,mail_content=?,mail_name=? where mail_id=? ";
		int id = mail.getId();
		String subject = mail.getSubject();
		String content = mail.getContent();
		String name = mail.getName();
		
		Object[] ob = new Object[]{subject,content,name,id};
		jdbcTemplate.update(sql, ob);
	}

	public List<Mail> getListMail() {
		String sql = "select * from mail";
		RowMapper<Mail> rm = new MailRowMapper();
		return jdbcTemplate.query(sql,rm);
	}

}
