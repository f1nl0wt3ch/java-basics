package vjb.de.vietjob.functions;

import java.util.List;

public class ThreadForLoopKaupunki {
      public boolean searchKaupunki(String kaupunki, List<String> kaupungit){
    	  for(String k : kaupungit) {
    		  if(k.equals(kaupunki))
    			  return true;
    	  }
		return false;
      }
}
