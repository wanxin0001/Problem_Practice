import java.util.*;
public class findTopKValues {
	public static void main(String[] args) {
		int[] input = {1, 2, 4, 3, 4, 7, 3, 9};
		int[] kMaxVals = findMax(input, 3);
		int[] kMinVals = findMin(input, 3);

		System.out.println(Arrays.toString(kMaxVals));
		System.out.println(Arrays.toString(kMinVals));
	}

	private  static int[] findMax(int[] input, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for (int i = 0; i < input.length; i++) {
			if (i < k) {
				queue.offer(input[i]);
			} else {
				if (queue.peek() < input[i]) {
					queue.poll();
					queue.offer(input[i]);
				}
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			result[i] = queue.poll();
		}

		return result;
	}

	private  static int[] findMin(int[] input, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new maxComp());
		for (int i = 0; i < input.length; i++) {
			if (i < k) {
				queue.offer(input[i]);
			} else {
				if (queue.peek() > input[i]) {
					queue.poll();
					queue.offer(input[i]);
				}
			}
		}

		int[] result = new int[k];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = queue.poll();
		}

		return result;
	}

	private static class maxComp implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return b - a;
		}
	}

}