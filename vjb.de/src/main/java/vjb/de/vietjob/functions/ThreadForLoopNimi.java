package vjb.de.vietjob.functions;

import java.util.List;

public class ThreadForLoopNimi extends Thread {
	
    public boolean searchNimi(String nimi, List<String> listNimi)  {
    	for(String nm : listNimi ){
    		if(nm.equals(nimi))
    			return true;
    	}
		return false;
    }
}
