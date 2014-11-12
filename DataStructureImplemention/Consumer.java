import java.util.concurrent.*;
public class Consumer implements Runnable {
	private BlockingQueue<String> queue = null;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}