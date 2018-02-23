package filereader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Read a file by InputStreamReader,collect a data as StringBuilder 
 * @author Hayato Kawai
 *
 */
public class TaskStringBuilder implements Runnable {
	
	private int size = (readFileToStringBuilder("src/Alice.txt").length());
	
	/**
	   * Read a file by InputStreamReader, append to String and return that to String
	   * @param filename is the file's name that will read
	   * @return a content in the file with String
	   */
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
	
	/**
	 * show how many char in the file
	 */
	@Override
	public String toString () {
		return String.format("[StringBuilder]Read %d-char",size);
	}
}
