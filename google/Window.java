import java.util.*;
public class Window {
	private int size;
	
	private long sum;
	private Queue<Integer> queue;
	public Window(int size) {
		this.size = size;
		queue = new LinkedList<Integer>();
		sum = 0;
	}

	public double getNext(int input) {
		if (queue.size() >= size) {
			int tmp = queue.poll();
			sum -= tmp;
		}

		queue.offer(input);
		sum += input;
		return (double)sum / queue.size();
	}

	public static void main(String[] args) {
		Window m = new Window(2);
		System.out.println(m.getNext(1));
		System.out.println(m.getNext(2));
		System.out.println(m.getNext(3));
		System.out.println(m.getNext(4));

	}


}