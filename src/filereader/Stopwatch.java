package filereader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * A Stopwatch that measures elapsed time between a starting time and stopping
 * time, or until the present time.
 * @author Hayato Kawai
 */
public class Stopwatch {

	private final double NANOSECOND = 1.0E-9;
	private long startT;
	private long stopT;
	private boolean running = false;

	/**
	 * reset the stopwatch and start if if stopwatch is
	 * not running. If the stopwatch is already running then start does nothing.
	 */
	public void start() {
		if (running)
			return;
		running = true;
		startT = System.nanoTime();
	}

	/**
	 *  stop the stopwatch. If the stopwatch is already
	 *  stopped, then stop does nothing
	 */
	public void stop() {
		if (!running)
			return;
		running = false;
		stopT = System.nanoTime();

	}

	/**
	 * check the stopwatch is running or not
	 * @return true if it running , false if it is stopped
	 */
	public boolean isRunning() {
		return running;

	}

	/**
	 * return the elapsed time in seconds, 
	 *  If the stopwatch is running, then return the time since start() until the current time.
	 *  If stopwatch is stopped, then return the time between the start and stop times.
	 * @return the time that used
	 */
	public double getElapsed() {
		if (running)
			return (System.nanoTime() - startT) * NANOSECOND;
		return (stopT - startT) * NANOSECOND;
	}
}
