public class Kustantaja {
private String knimi; 
private String osoite;
private String puhelin;
public Kustantaja ()
{
knimi = "";
osoite = null;
puhelin = null;
}
public Kustantaja (String knimi, String osoite, String puhelin)
{
this.knimi = knimi;
this.osoite = osoite;
this.puhelin = puhelin;
}
public String getKnimi()
{return this.knimi;}
public String getOsoite()
{return this.osoite;}
public String getPuhelin()
{return this.puhelin;}
public void setKnimi (String knimi)
{this.knimi = knimi;}
public void setOsoite(String osoite)
{this.osoite = osoite;}
public void setPuhelin(String puhelin)
{this.puhelin = puhelin;}
public String toStringg()
{

return this.knimi;
}
}