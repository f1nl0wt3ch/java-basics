import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Opiskelija {
	
	private String nimi;
	private String hetu;
	private int aloitusvuosi;
	private double opintopiste;
	private List<Kurssi> kurssiIlmottautumiset;
	
	public Opiskelija(){
		nimi="";
		hetu="";
		aloitusvuosi=0;
		opintopiste=0.0;
		kurssiIlmottautumiset = new ArrayList<Kurssi>();
		
	}
	public Opiskelija(String nimi, String hetu, int aloitusvuosi, double opintopiste){
		this.nimi = nimi;
		this.hetu = hetu;
		this.aloitusvuosi = aloitusvuosi;
		this.opintopiste = opintopiste;
		Kurssi kurssi = new Kurssi();
		kurssiIlmottautumiset.add(kurssi);
	}
	// listan metodit
	public void lisaaIlmottautuminen(Kurssi kurssi){
		Kurssi uusi = new Kurssi(kurssi.getNimi(), kurssi.getOpintoPiste());
		kurssiIlmottautumiset.add(uusi);
	}
	public List<Kurssi> kerroIlmottautumiset(){
		List<Kurssi> kopio = new ArrayList<Kurssi>();
		for (int i=0; i< kurssiIlmottautumiset.size(); i++){
			kopio.add(new Kurssi(kurssiIlmottautumiset.get(i).getNimi(), kurssiIlmottautumiset.get(i).getOpintoPiste()));
		}
		return kopio;
		
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
   public int getAloitusVuosi(){
	   return aloitusvuosi;
   }
   public void setAloitusVuosi(int aloitusvuosi){
	   this.aloitusvuosi = aloitusvuosi;
   }
   public double getOpintoPiste(){
	   return opintopiste;
   }
   public void setOpintoPiste(double opintopiste){
	   this.opintopiste = opintopiste;
   }
   
   public void lisaaOpintoPisteita(int lisattavaMaara){
	   opintopiste = opintopiste + lisattavaMaara;
   }
   public double getKeskimaarainen(){
	  double keskimaarainen;
	  Date date = new Date();
	  SimpleDateFormat fm = new SimpleDateFormat("yyyy");
	  int nykyvuosi = Integer.parseInt(fm.format(date));
	  keskimaarainen =  opintopiste / (nykyvuosi - aloitusvuosi);
      return keskimaarainen;
   }
   public String toString(){
	   return "Nimi "+ this.nimi+ "\nHetu "+this.hetu;
}

}
