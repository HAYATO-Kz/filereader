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
}
