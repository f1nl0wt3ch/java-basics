import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Henkilo {
private String nimi;
private String hetu;
private int syntymavuosi;
private double sijoitustenYhteisarvo;
private List<Sijoitus> sijoitukset ;


public Henkilo(){
	nimi="";
	hetu="";
	syntymavuosi =0;
	sijoitustenYhteisarvo=0.00;
	sijoitukset = new ArrayList<Sijoitus>();
	}
public Henkilo(String nimi, String hetu, int syntymavuosi, double sijoitustenYhteisarvo){
	
	this.nimi=nimi;
	this.hetu= hetu;
	this.syntymavuosi=syntymavuosi;
	this.sijoitustenYhteisarvo = sijoitustenYhteisarvo;
	
	Sijoitus sijoitus = new Sijoitus();
	sijoitukset.add(sijoitus);
	
	
}
public String getNimi(){
	return nimi;
}
public void setNimi(String nimi){
	this.nimi = nimi;
}
public String getHetu(){
	return hetu;
}
public void setHetu(String hetu){
	this.hetu = hetu;
}
public int getSyntymavuosi(){
	return syntymavuosi;
}
public void setSyntymavuosi(int syntymavuosi){
	this.syntymavuosi= syntymavuosi;
}
public double getSijoitustenYhteisarvo(){
	return sijoitustenYhteisarvo;
}
public void setSijoitustenYhteisarvo(double sijoitustenYhteisarvo){
	this.sijoitustenYhteisarvo = sijoitustenYhteisarvo;
}
public void lisaaSjoituksienMaaraa(double lisattavaMaara, int arvo){
	
   sijoitustenYhteisarvo = arvo + lisattavaMaara;
}
public int getIka(){
	int ika;
	Date tanaan = new Date();
	SimpleDateFormat fm = new SimpleDateFormat("yyyy");
	int nykyvuosi =Integer.parseInt(fm.format(tanaan));
	ika = nykyvuosi - syntymavuosi;
	return ika;
}

// lista metodit
public void lisaaSijoitus(Sijoitus sijoitus){
	
	 Sijoitus uusi = new Sijoitus(sijoitus.getNimi(), sijoitus.getArvo());
		sijoitukset.add(uusi);
	 
	
}
public List<Sijoitus> kerroSijoitukset(){
	
	 List<Sijoitus> kopio = new ArrayList<Sijoitus>();
		for (int i=0; i< sijoitukset.size(); i++){
			kopio.add(new Sijoitus(sijoitukset.get(i).getNimi(), sijoitukset.get(i).getArvo()));
		}
		return kopio;
	
}
public String toString(){
	return "Nimi "+ this.nimi;
}

}
