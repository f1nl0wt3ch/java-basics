package vjb.de.vietjob.dao.partneriDAO;

import vjb.de.vietjob.bean.partneri.*;


public interface PartneriDao {
      public Partneri getPartneriByTunnus(String tunnus);
      public void updateTiedot(Partneri partneri);
}

