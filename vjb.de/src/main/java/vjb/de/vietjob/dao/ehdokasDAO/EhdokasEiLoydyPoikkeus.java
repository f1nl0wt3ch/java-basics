package vjb.de.vietjob.dao.ehdokasDAO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EhdokasEiLoydyPoikkeus extends RuntimeException {

	public EhdokasEiLoydyPoikkeus(Exception cause) {
		super(cause);
	}
	
}

