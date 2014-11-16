public class Singleton {
	private static Singleton singleton = null;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}

		return singleton;
	}

	public static void demoMethod() {
		System.out.println("demoMethod for singleton");
	}
}