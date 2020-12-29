
public class Opiskelija {
private String numero;
private String nimi;
private String kotikunta;

// kompositio
private Tutkinto tutkinto;

public Opiskelija(){
	numero ="";
	nimi= "";
	kotikunta ="";
	tutkinto = new Tutkinto();
}

public Opiskelija(String numero, String nimi, String kotikunta){
	this.numero = numero;
	this.nimi = nimi;
	this.kotikunta = kotikunta;
	tutkinto = new Tutkinto();
}
public Opiskelija(String numero, String nimi, String kotikunta, Tutkinto tutkinto){
	this.numero = numero;
	this.nimi = nimi;
	this.kotikunta = kotikunta;
	if (tutkinto != null ){
		tutkinto = new Tutkinto (tutkinto.getTutkintoNimi(), tutkinto.getSuuntaus(), tutkinto.getTavoiteVuosi());
	}
	else {tutkinto = new Tutkinto(); }
}
// get metodit
public String getNumero(){
	return this.numero;
}
public String getNimi(){
	return this.nimi;
	
}
public String getKotikunta(){
	return this.kotikunta;
}
public Tutkinto getTutkinto(){
	if (tutkinto != null ){
		tutkinto = new Tutkinto (tutkinto.getTutkintoNimi(), tutkinto.getSuuntaus(), tutkinto.getTavoiteVuosi());
	}
	else { tutkinto = new Tutkinto(); }
	return tutkinto;
}
// set metodit
public void setNumero(String numero){
	this.numero = numero;
}
public void setNimi(String nimi){
	this.nimi = nimi;}
public void setTutkinto(Tutkinto tutkinto){
	if (tutkinto != null ){
		this.tutkinto.setTutkintoNimi(tutkinto.getTutkintoNimi());
		this.tutkinto.setSuuntaus(tutkinto.getSuuntaus());
		this.tutkinto.setTavoiteVuosi(tutkinto.getTavoiteVuosi());
	}
}
public void setKotikunta(String kotikunta){
	this.kotikunta = kotikunta;
}
public String toString(){
	return "Numero "+ this.numero+"Nimi "+this.nimi+" Kotikunta "+ this.kotikunta;
}
}
