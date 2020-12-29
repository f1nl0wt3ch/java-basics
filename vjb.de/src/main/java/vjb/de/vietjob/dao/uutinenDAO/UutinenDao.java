package vjb.de.vietjob.dao.uutinenDAO;

import java.util.List;

import vjb.de.vietjob.bean.uutinen.Uutinen;

public interface UutinenDao {
      public void postNew(Uutinen u, String link);
      public void deleteNew (int id);
      public List<Uutinen> showUutiset();
      public void editUutinen(Uutinen u);
}
