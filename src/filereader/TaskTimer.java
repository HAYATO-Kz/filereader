package filereader;


public class TaskTimer {

	public static void measureAndPrint(Runnable runnable) {
		System.out.println(runnable);
		Stopwatch sw = new Stopwatch();
		sw.start();
		runnable.run();
		sw.stop();
		System.out.printf("use %.6f sec.\n",sw.getElapsed());
	}

}
