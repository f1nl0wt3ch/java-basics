import java.util.List;
import java.util.ArrayList;


public class Kalastaja {
	private String nimi;
	private List<Kala> kalat;
	
	
	public Kalastaja(){
		nimi = "";
		kalat = new ArrayList<Kala>();
	}
	public Kalastaja(String nimi){
		this.nimi = nimi;
		Kala kala = new Kala();
		kalat.add(kala);
		
	}
	public String getNimi(){
		return this.nimi;
	}
	public List<Kala> getKalat(){
		List<Kala> kopio = new ArrayList<Kala>();
		for (int i=0; i< kalat.size(); i++){
			kopio.add(new Kala(kalat.get(i).getNimi(), kalat.get(i).getPaino(), kalat.get(i).getPituus()));
		}
		return kopio;
	}
	
	public void setNimi(String nimi){
		this.nimi = nimi;
	}
	public void addKalaLista(Kala kala){
		Kala uusi = new Kala(kala.getNimi(), kala.getPaino(), kala.getPituus());
		kalat.add(uusi);
	}
	public String toString(){
		return "Nimi "+this.nimi+ "\nSaalis:"+ kalat;
		
	}
	

}
