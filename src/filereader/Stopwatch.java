package filereader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Stopwatch {
	
	private final double NANOSECOND = 1.0E-9;
	private long startT;
	private long stopT;
	private boolean running = false;

	public void start() {
		if (running)
			return;
		running = true;
		startT = System.nanoTime();
	}

	public void stop() {
		if (!running)
			return;
		running = false;
		stopT = System.nanoTime();

	}

	public boolean isRunning() {
		return running;

	}

	public double getElapsed() {
		if (running)
			return (System.nanoTime() - startT) * NANOSECOND;
		return (stopT - startT) * NANOSECOND;
	}
	
	public static String readFileToString(String filename) {
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
	
	public static String readfileToStringwithBufferReader(String filename) {
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
	
	public static void main (String[]args) {
		Stopwatch sw = new Stopwatch();
		 sw.start();
		 String alice1 = readFileToString("src/Alice.txt");
		 sw.stop(); 
		 System.out.printf("[String]Read %d char  in %f sec. \n",alice1.length(),sw.getElapsed());
		 sw.start();
		 String alice2 = readFileToStringBuilder("src/Alice.txt");
		 sw.stop();
		 System.out.printf("[StringBuilder]Read %d char in %f sec. \n",alice2.length(),sw.getElapsed());
		 sw.start();
		 String alice3 = readfileToStringwithBufferReader("src/Alice.txt");
		 sw.stop();
		 System.out.printf("[BufferString]Read %d char in %f sec. \n",alice2.length(),sw.getElapsed());
	}
}
