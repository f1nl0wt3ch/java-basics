package vjb.de.vietjob.bean.mail;

public interface Mail {
	public int getId() ;
	public void setId(int id) ;
	public String getSubject() ;
	public void setSubject(String subject);
	public String getContent();
	public void setContent(String content);
	public String getName();
	public void setName(String name);
}
