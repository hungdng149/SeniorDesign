import java.nio.file.Files;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;


public class FProcessing {

	public static void main(String[] args) throws IOException {
		List myList = new ArrayList();
		String filename = "C:\\Users\\PC\\Downloads\\text.txt";
		String content = new String(Files.readAllBytes(Paths.get(filename)));

		Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
		Matcher reMatcher = re.matcher(content);
		while (reMatcher.find()) {
		   myList.add(reMatcher.group());
		}
		for (int i=0; i<myList.size();i++) {
		String x = String.valueOf(i);
		try {
		File myObj = new File("E:\\textfolder\\sentence" + x);
		     if (myObj.createNewFile()) {
		       System.out.println("File created: " + myObj.getName());
		       try {
		           FileWriter myWriter = new FileWriter("E:\\textfolder\\sentence" + x);
		           myWriter.write(String.valueOf(myList.get(i)));
		           myWriter.close();
		           System.out.println("Successfully wrote to the file.");
		         } catch (IOException e) {
		           System.out.println("An error occurred.");
		           e.printStackTrace();
		         }
		     } else {
		       System.out.println("File already exists.");
		     }
		   } catch (IOException e) {
		     System.out.println("An error occurred.");
		     e.printStackTrace();
		}

		}

		}
}
	
