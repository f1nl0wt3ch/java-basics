

public class Auto 
{
private String malli;
private String merkki;
private String reknumero;
private int vuosimalli;


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
	return this.malli +" "+this.merkki;
}


}
