public class Kirja {
private String nimi;
private String isbn;
private double hinta;
private Kustantaja kustantiedot;
public Kirja()
{
nimi = null;
isbn = null;
hinta = 0.0;
kustantiedot = null;
}
public Kirja(String nimi, String isbn, double hinta, Kustantaja kustantiedot)
{
this.nimi = nimi;
this.isbn = isbn;
this.hinta = hinta;
this.kustantiedot = kustantiedot;
}
public Kustantaja getKustantiedot()
{
return this.kustantiedot;
}
public void setKustantiedot(Kustantaja kustantiedot)
{this.kustantiedot = kustantiedot;}
public String getNimi()
{
return this.nimi ;
}
public String getIsbn()
{
return this.isbn;
}
public double getHinta()
{
return this.hinta;
}
public void setNimi(String nimi)
{this.nimi = nimi;}
public void setIsbn(String isbn)
{this.isbn = isbn;}
public void setHinta(double hinta)
{this.hinta = hinta;}
public String toString() {
String palautus ="";
palautus = "Nimi: "+this.nimi+"\nIsbn: "+this.isbn+ "\nHinta: "+ this.hinta+"\nKustantaja: "+ kustantiedot.toStringg();
return palautus ;}
}