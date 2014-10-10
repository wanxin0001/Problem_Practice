package SingleTon;
public class Logging {
	private static Logging singletonInstance = null;
	private Logging() {

	}

	public static Logging getSingleton() {
		if (singletonInstance == null) {
			singletonInstance = new Logging();
		}
		return singletonInstance;
	}

	public void log(String message) {
		System.out.println(System.currentTimeMillis() + ": " + message);
	}
}