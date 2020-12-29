import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class FileFolderAction {

	public static void main(String[] args) throws IOException {
		String sourceStr = "file.txt";
		String targetStr = "newfile.txt";
		//Get file location in project
        Path source = Paths.get(sourceStr);
        System.out.println("File name is "+ source.getFileName());
        System.out.println("File path is "+ source.toString());
        Path target = Paths.get(targetStr);
        //Copy from exist file
        Files.copy (source, target, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(target.getFileName()+" has been created");
        //Delete file
        Files.delete(target);
        System.out.println("Then was deleted");
        //Create a folder
        Path newdir = Paths.get("files");
        Path root = Paths.get("");
        //Files.createDirectory(newdir);
        //Move file to directory
        Files.move(Paths.get("files/fileclone.txt"), root.resolve("fileclone.txt"));
        Files.move(Paths.get("fileclone.txt"), newdir.resolve(Paths.get("fileclone.txt").getFileName()), StandardCopyOption.REPLACE_EXISTING);
        //All function with folder
        //Get hash code number
        System.out.println(newdir.hashCode());
        //Get folder's location in computer
        System.out.println(newdir.toUri());
	}

}
