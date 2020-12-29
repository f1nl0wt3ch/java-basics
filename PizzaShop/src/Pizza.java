import java.text.SimpleDateFormat;
import java.util.Date;


public class Pizza {
	private int id;
	private String nimi;
	private String sisalto;
	Date poisto;
	
	public Pizza(){
		id =0;
		nimi="";
		sisalto ="";
		poisto = new Date();
				
	}
    public Pizza(int id, String nimi, String sisalto, Date poisto){
    	this.id = id;
    	this.nimi = nimi;
    	this.sisalto = sisalto;
    	this.poisto = poisto;
    }
    public int getId(){
    	return id;
    }
    public void setId(int id){
    	this.id = id;
    }
    public String getNimi(){
    	return nimi;
    }
    public void setNimi(String nimi){
    	this.nimi = nimi;
    }
    public String getSisalto(){
    	return sisalto;
    }
    public void setSisalto(String sisalto){
    	this.sisalto = sisalto;
    }
    public String toString(){
    	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    	return "Id "+this.id+" Nimi "+this.nimi+" Sisältö "+this.sisalto+
    			" Postomerkkitty "+ date.format(this.poisto);
    }
}
