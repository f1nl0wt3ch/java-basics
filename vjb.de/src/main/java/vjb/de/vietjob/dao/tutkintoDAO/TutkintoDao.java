package vjb.de.vietjob.dao.tutkintoDAO;

import java.util.List;

import vjb.de.vietjob.bean.tutkinto.Tutkinto;

public interface TutkintoDao {
     public List<String> showTutkinnot();
     public void addTutkinto(Tutkinto tut);
     public void deleteTutkinto(int id);
     public void editTutkinto(Tutkinto tut);
}
