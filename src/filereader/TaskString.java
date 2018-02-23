package filereader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Read a file by InputStreamReader,collect a data as String 
 * @author Hayato Kawai
 */
public  class TaskString  implements Runnable {

	 private int size = (readFileToString("src/Alice.txt").length());

	 /**
	   * Read a file by InputStreamReader, append to StringBuilder and return that to String
	   * @param filename is the file's name that will read
	   * @return a content in the file with String
	   */
	public String readFileToString(String filename) {
		String data = "";
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while (true) {
				c = reader.read();
				if (c < 0)
					break;
				data = data + (char) c;
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		if (in != null)
			try {
				in.close();
			} catch (IOException ex) {

			}
		return data;
	}

	@Override
	public void run() {
		readFileToString("src/Alice.txt");
	}
	
	/**
	 * show how many char in the file
	 */
	@Override
	public String toString () {
		return String.format("[String]Read %d-char",size);
	}
}
