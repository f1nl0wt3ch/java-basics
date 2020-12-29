import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReadWriteFile {

	public static void main(String[] args) {
        Path source = Paths.get("file.txt");
        Path target = Paths.get("files/fileclone.txt");
        Charset charset = Charset.forName("UTF-8");
        List<String> lines = new ArrayList<String>();
        // Read file content
        try {
			BufferedReader reader = Files.newBufferedReader(source, charset);
			String line = null;
			while((line = reader.readLine()) != null){
				lines.add(line);
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Error cause "+e);
		}
        // Write content to a file
           try (BufferedWriter writer = Files.newBufferedWriter(target, charset)) {
        	   Iterator<String> iterator = lines.iterator();
        	   while(iterator.hasNext()){
        		  String s = iterator.next();
        		  writer.append(s, 0, s.length());
        		  writer.newLine();
        	   }
		} catch (IOException e) {
			System.out.println("Error cause "+e);
		}
	}

}
