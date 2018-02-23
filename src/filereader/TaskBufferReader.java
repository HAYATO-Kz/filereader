package filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Read a file by BufferReader,collect a data as String 
 * @author Hayato Kawai
 *
 */
public class TaskBufferReader  implements Runnable {
	
	private int size = (readFileToStringWithBufferedReader("src/Alice.txt").length());
	
	/**
	 * read a file by BufferReader,append lines to String and return that to String
	 * @param filename is the file's name that will read
	 * @return a content in the file with String
	 */
	public static String readFileToStringWithBufferedReader(String filename) {
		String data = "";
		BufferedReader bReader = null;
		FileReader fReader = null;
		try {
			fReader = new FileReader(filename);
			bReader = new BufferedReader(fReader);
			int c;
			while (true) {
				c = bReader.read();
				if (c < 0)
					break;
				data = data + (char) c;
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		if (bReader != null)
			try {
				bReader.close();
			} catch (IOException ex) {

			}
		return data;
	}

	@Override
	public void run() {
		readFileToStringWithBufferedReader("src/Alice.txt");
	}
	
	/**
	 * show how many char in the file
	 */
	@Override
	public String toString () {
		return String.format("[BufferString]Read %d-char",size);
	}
}
