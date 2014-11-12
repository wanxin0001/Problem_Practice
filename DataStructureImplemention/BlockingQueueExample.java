import java.util.concurrent.*;

public class BlockingQueueExample {
	public static void main(String[] args) throws Exception{
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);

		
		t1.start();
		t2.start();

 		try {
 			t1.join();
 			t2.join();
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		}


	}
}