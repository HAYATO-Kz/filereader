package filereader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TaskStringBuilder implements Runnable {
	
	private int size = (readFileToStringBuilder("src/Alice.txt").length());
	
	public static String readFileToStringBuilder (String filename) {
		StringBuilder data = new StringBuilder();
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while (true) {
				c = reader.read();
				if (c < 0)
					break;
				data = data.append((char) c);
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		if (in != null)
			try {
				in.close();
			} catch (IOException ex) {

			}
		return data.toString();
	}

	@Override
	public void run() {
		readFileToStringBuilder("src/Alice.txt");
	}
	
	public String toString () {
		return String.format("[StringBuilder]Read %d-char",size);
	}
}
