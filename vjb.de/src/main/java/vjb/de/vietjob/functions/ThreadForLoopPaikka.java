package vjb.de.vietjob.functions;

import java.util.List;

public class ThreadForLoopPaikka extends Thread {
    public boolean searchPaikka(String paikka, List<String> listPaikka)  {
    	for(String pk : listPaikka ){
    		if(pk.equals(paikka))
    			return true;
    	}
		return false;
    }

}
