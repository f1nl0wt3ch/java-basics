import java.text.SimpleDateFormat;
import java.util.Date;



public class Tutkinto {
private String tutkintoNimi;
private String suuntaus;
private int tavoiteVuosi;


public Tutkinto(){
	tutkintoNimi ="";
	suuntaus = "";
	tavoiteVuosi = 0;
}
public Tutkinto(String tutkintoNimi, String suuntaus, int tavoiteVuosi){
	this.tutkintoNimi = tutkintoNimi;
	this.suuntaus = suuntaus;
	this.tavoiteVuosi = tavoiteVuosi;
}
// get metodit
public String getTutkintoNimi(){
	return this.tutkintoNimi;
}
public String getSuuntaus(){
	return this.suuntaus;
}
public int getTavoiteVuosi(){ 
	
	return this.tavoiteVuosi;
}

// set metodit
public void setTutkintoNimi(String tutkintoNimi){
	this.tutkintoNimi = tutkintoNimi;
}
public void setSuuntaus(String suuntaus){
	this.suuntaus = suuntaus;
}
public void setTavoiteVuosi(int tavoiteVuosi){
	this.tavoiteVuosi = tavoiteVuosi;
}
// get opintotilanne
public String getTilanne(int tavoiteVuosi){
	String palautus ="";
	Date today = new Date();
	SimpleDateFormat date = new SimpleDateFormat("yyyy");
	String Strnykyvuosi = date.format(today);
	int nykyvuosi = Integer.parseInt(Strnykyvuosi);
	int valmisvuosi = tavoiteVuosi - ( nykyvuosi + 3);
	if (valmisvuosi <= 0 ){ palautus = "suorittaa" ;
		}
	else { palautus = " ei vielŠ suorittanut" ; }
	return palautus;
}
public String toString(){
	return "Tutkinto "+ this.tutkintoNimi+" Suuntaus "+ this.suuntaus+ " Tavoite Vuosi "+ this.tavoiteVuosi;
}
}
