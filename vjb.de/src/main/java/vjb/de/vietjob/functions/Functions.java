package vjb.de.vietjob.functions;

import org.springframework.ui.Model;

public interface Functions {
        public abstract String moveOikeanSivu(int rooliID);
        public abstract String adminAction(String submit, Model model, int id);
}
