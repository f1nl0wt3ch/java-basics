package vjb.de.vietjob.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImageUpload {
	public void validateKuva(MultipartFile kuva){
		if(kuva.getContentType().equals("jpg/jpeg/png")){
			Exception e = null;
			throw new ImageUploadException("Only JPG images accepted upload", e);
		}
	}
	
	public void saveKuva(String kuvanimi, MultipartFile kuva) throws ImageUploadException{
		try {
			String rootPath = System.getProperty("catalina.home");
			File file = new File(rootPath+ "resources/images/news" + kuvanimi);
			FileUtils.writeByteArrayToFile(file, kuva.getBytes());
		} catch (IOException e) {
			throw new ImageUploadException("Unable to save image", e);
		}
	}
}
