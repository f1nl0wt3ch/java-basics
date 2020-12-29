import java.util.ArrayList;
import java.util.List;



public class Auto 
{
private String malli;
private String merkki;
private String reknumero;
private int vuosimalli;
private List<Lisavaruste> lisavarusteLista;

public Auto()
{
	malli = "";
	merkki = "";
	reknumero ="";
	vuosimalli=0;
	lisavarusteLista = new ArrayList<Lisavaruste>();
}
public Auto(String malli, String merkki, String reknumero, int vuosimalli)
{
	this.malli = malli;
	this.merkki = merkki;
	this.reknumero = reknumero;
	this.vuosimalli = vuosimalli;
	Lisavaruste varusteet = new Lisavaruste();
	lisavarusteLista.add(varusteet);
	
}
public String getMerkki()
{
	return this.merkki;
}
public String getMalli()
{
	return this.malli;	
}
public String getReknumero()
{
	return this.reknumero;
}
public int getVuosimalli()
{
return this.vuosimalli;	
}
public void setMalli(String malli)
{
this.malli = malli;
}
public void setMerkki(String merkki)
{
this.merkki= merkki;
}
public void setReknumero(String reknumero)
{
this.reknumero= reknumero;
}
public void setVuosimalli(int vuosimalli)
{
this.vuosimalli = vuosimalli;
}

public List<Lisavaruste> getLisavarusteLista(){
	List<Lisavaruste> kopio = new ArrayList<Lisavaruste>();
	for (int i=0; i< lisavarusteLista.size(); i++){
	kopio.add(new Lisavaruste(lisavarusteLista.get(i).getNimi(), lisavarusteLista.get(i).getKuvaus()) );
	}
	return kopio;
}

public void addLisavarusteLista(Lisavaruste lisavaruste){
      Lisavaruste uusi = new Lisavaruste(lisavaruste.getNimi(), lisavaruste.getKuvaus());
      lisavarusteLista.add(uusi);
}
public String toString()
{
	String palautus;
	
	
		palautus = "\nMerkki ja malli: " +this.merkki +" "+this.malli+"\nRekisterinumero: "+ this.reknumero
				+"\nVuosimalli: "+this.vuosimalli+"\nLisŠvarusteet: ";
			
	return palautus;
	
		}


}
