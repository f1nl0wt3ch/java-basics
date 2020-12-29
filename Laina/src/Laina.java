import java.text.DecimalFormat;


public class Laina {
	DecimalFormat df = new DecimalFormat("0.00");
	private double maara;
	private double korko;
	private double lyhennys;
	private static double kulut =1.8;
	public Laina()
	{
		maara=0.0;
		korko=0.0;
		lyhennys=0.0;
		
	}
   public Laina(double maara, double korko, double lyhennys, double kulut)
   {
	   this.maara= maara;
	   this.korko = korko;
	   this.lyhennys=lyhennys;
   }
   public double getMaara()
   {return this.maara;}
   public double getKorko()
   {return this.korko;}
   public double getLyhennys()
   {return this.lyhennys;}
   
   public void setMaara(double maara)
   {this.maara = maara;}
   public void setKorko(double korko)
   {this.korko=korko;}
   public void setLyhennys(double lyhennys)
   {this.lyhennys = lyhennys;}
   
   public static double getKuukausiEra(double maara, double korko, double lyhennys)
   {double kuukausiera = maara * (korko / 100.0 / 12) + kulut +
   lyhennys; 
   return kuukausiera; }
   
   public static double getKuukausiKorko(double maara, double korko)
   {   double kuukausikorko = maara*(korko/100.0/12);
	   return kuukausikorko;}
   
   public static double getKulut()
   {return kulut;}
   public static void setKulut()
   {kulut = 1.8;}
   public String toString()
   {  double kuukausiera = Laina.getKuukausiEra(maara, korko, lyhennys);
      double kuukausikorko = Laina.getKuukausiKorko(maara, korko);
	   return "Maksettava kokonaiseräerä on "+df.format(kuukausiera)+"\nLyhennys on "+df.format(this.lyhennys)+"\nKoron osuus on "+df.format(kuukausikorko)+"\nKulujen osuus on "+df.format(kulut);}
}
