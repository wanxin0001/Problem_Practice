package SingleTon;
import SingleTon.Logging;


public class Singleton {
	public static void main(String[] args) {
		Logging.getSingleton().log("Test Message!!");
	}
}