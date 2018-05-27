 
import java.io.FileReader;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class jsonParser {

	private static final String FILENAME = "data\\timeTable.json";

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    
		} finally {
		    br.close();
		}

	}

}
