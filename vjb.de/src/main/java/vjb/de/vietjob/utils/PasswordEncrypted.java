package vjb.de.vietjob.utils;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncrypted {
      public String encryptPassword(String password){
    	  StandardPasswordEncoder spe = new StandardPasswordEncoder();
    	  return spe.encode(password);
      }
}
