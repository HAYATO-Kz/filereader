package filereader;

public class Main {

	public static void main (String []args) {
		TaskTimer.measureAndPrint(new TaskString());
		TaskTimer.measureAndPrint(new TaskStringBuilder());
		TaskTimer.measureAndPrint(new TaskBufferReader());
	}
}
