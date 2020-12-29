package vjb.de.vietjob.dao.hakemusDAO;

import java.util.List;

import vjb.de.vietjob.bean.apply.Apply;
import vjb.de.vietjob.bean.hakemus.Hakemus;

public interface HakemusDao {
     public void insertHakemus(Hakemus hakemus);
     public void deleteHakemus(int hakemus_id);
     public void editHakemus(Hakemus h);
     public List<Hakemus> showHakemukset();
     public List<Apply> showListAppliedDuuni(int ehdokas_id);
     public boolean checkAppliedOrNot(Hakemus hakemus);
}
