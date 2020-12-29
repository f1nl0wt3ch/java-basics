
public class Auto 
{
private String malli;
private String merkki;
private String reknumero;
private int vuosimalli;

public String getMalli()
{
	return this.malli;	
}
public String getMerkki()
{
	return this.merkki;
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
{this.malli = malli;}
public void setMerkki(String merkki)
{this.merkki= merkki;}
public void setReknumero(String reknumero)
{this.reknumero= reknumero;}
public void setVuosimalli(int vuosimalli)
{this.vuosimalli = vuosimalli;}

public Auto()
{
	malli = "";
	merkki = "";
	reknumero ="";
	vuosimalli=0;
}
public Auto(String malli, String merkki, String reknumero, int vuosimalli)
{
	this.malli = malli;
	this.merkki = merkki;
	this.reknumero = reknumero;
	this.vuosimalli = vuosimalli;
}
public String toString()
{
	return "Merkki ja malli: "+this.merkki+ this.malli+"\nRekisterinumero: "+ this.reknumero+ "\nVuosimalli: "+this.vuosimalli;
}

public int getIka (int nykyvuosi)
{
int ika = nykyvuosi - vuosimalli;
return ika;
}
}
