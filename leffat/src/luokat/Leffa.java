package luokat;


public class Leffa {
	
	private int elokuvaId;
	private String elokuvaNimi;
	private String ohjaaja;
	private int valmistumisvuosi;

	public Leffa() {
		elokuvaId = 0;
		elokuvaNimi = "";
		ohjaaja = "";
		valmistumisvuosi = 0;
	}

	public Leffa(int elokuvaId, String elokuvaNimi, String ohjaaja,
			int valmistumisvuosi) {
		this.elokuvaId = elokuvaId;
		this.elokuvaNimi = elokuvaNimi;
		this.ohjaaja = ohjaaja;
		this.valmistumisvuosi = valmistumisvuosi;
	}
	public Leffa(String elokuvaNimi, String ohjaaja,
			int valmistumisvuosi) {
		this.elokuvaNimi = elokuvaNimi;
		this.ohjaaja = ohjaaja;
		this.valmistumisvuosi = valmistumisvuosi;
	}

	public int getElokuvaId() {
		return elokuvaId;
	}

	public void setElokuvaId(int elokuvaId) {
		this.elokuvaId = elokuvaId;
	}

	public String getElokuvaNimi() {
		return elokuvaNimi;
	}

	public void setElokuvaNimi(String elokuvaNimi) {
		this.elokuvaNimi = elokuvaNimi;
	}

	public String getOhjaaja() {
		return ohjaaja;
	}

	public void setOhjaaja(String ohjaaja) {
		this.ohjaaja = ohjaaja;
	}

	public int getValmistumisvuosi() {
		return valmistumisvuosi;
	}

	public void setValmistumisvuosi(int valmistumisvuosi) {
		this.valmistumisvuosi = valmistumisvuosi;
	}

	@Override
	public String toString() {
		return "Leffa elokuvaId=" + elokuvaId + ", elokuvaNimi=" + elokuvaNimi
				+ ", ohjaaja=" + ohjaaja + ", valmistumisvuosi="
				+ valmistumisvuosi;
	}
	
}

