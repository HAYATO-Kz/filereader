package filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TaskBufferReader  implements Runnable {
	
	private int size = (readFileToStringWithBufferedReader("src/Alice.txt").length());
	
	public static String readFileToStringWithBufferedReader(String filename) {
		String data = "";
		BufferedReader reader = null;
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			reader = new BufferedReader(fr);
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
		if (reader != null)
			try {
				reader.close();
			} catch (IOException ex) {

			}
		return data;
	}

	@Override
	public void run() {
		readFileToStringWithBufferedReader("src/Alice.txt");
	}
	
	public String toString () {
		return String.format("[BufferString]Read %d-char",size);
	}
}
