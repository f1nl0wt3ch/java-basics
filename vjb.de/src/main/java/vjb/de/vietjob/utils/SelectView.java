package vjb.de.vietjob.utils;

public class SelectView {
	public String returnViewDuunit(String tunnus){
		if(tunnus.equals("anonymousUser"))
			return "public/duuni_list_login";
		else
			return "public/duuni_list_logout";
	}
	
	public String returnViewEhdokkaat(String tunnus){
		if(tunnus.equals("anonymousUser"))
			return "public/ehdokas_list_login";
		else
			return "public/ehdokas_list_logout";
	}
	public String returnViewYksiEhdokas(String tunnus){
		if(tunnus.equals("anonymousUser"))
			return "public/ehdokas_yksi_login";
		else
			return "public/ehdokas_yksi_logout";
	}
	public String returnViewYksiDuuni(String tunnus){
		if(tunnus.equals("anonymousUser"))
			return "public/duuni_yksi_login";
		else
			return "public/duuni_yksi_logout";
	}
}
