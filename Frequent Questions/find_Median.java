import java.util.*;
public class find_Median {
	

	public static void main (String[] args) {
		int[] array1 = { 2, 7, 8, 3, 4};
		int[] array2 = {2, 7, 8, 3, 4, 6};

		double result1 = findMed(array1);
		double result2 = findMed(array2);
		System.out.println("Result1 : " + result1);
		System.out.println("Result2 : " + result2);

		return;
	}

	private static class PQComparator implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}

	private static double findMed(int[] array) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new PQComparator());
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				maxHeap.add(array[i]);
			} else {
				if (array[i] <= maxHeap.peek()) {
					maxHeap.add(array[i]);
				} else {
					minHeap.add(array[i]);
				}

				if (maxHeap.size() - minHeap.size() > 1) {
					minHeap.add(maxHeap.poll());
				} else if (maxHeap.size() - minHeap.size() < -1) {
					maxHeap.add(minHeap.poll());
				}
			}
		}

		if (maxHeap.size() == minHeap.size()) {
			return (double) (maxHeap.peek() + minHeap.peek()) / 2;
		} else if (maxHeap.size() > minHeap.size()) {
			return (double) maxHeap.peek();
		} else {
			return (double) minHeap.peek();
		}
	}

}