package vjb.de.vietjob.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ImageUploadException extends RuntimeException {
      public ImageUploadException(String content, Exception e){
    	  super(e);
      }
}
