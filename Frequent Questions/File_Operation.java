import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_Operation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("some.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("to_write.txt"));
		
		String line = "";
		while ((line = br.readLine()) != null) {
			bw.write(line + "\n");
		}
		
		br.close();
		bw.close();
	}
}