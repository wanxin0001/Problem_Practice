/*
找 two largest values,我开始写了个 bubble sorting,然后写到一半想到一个更好的。然后跟 他说我有个更好的
*/
import java.util.*;
public class twoLargest {
	public static void main(String[] args) {
		int[] input = {1, -1, 3, 9, 3, 2, 9,30, 2};
		int[] result = findTwoLargestVal(input);

		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int[] findTwoLargestVal(int[] input) {
		int[] result = {-1, -1};
		if (input == null || input.length < 2) {
			return result;
		}

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(2);
		for (int i = 0; i < input.length; i++) {
			if (i < 2) {
				heap.offer(input[i]);
			} else {
				if (input[i] > heap.peek()) {
					heap.poll();
					heap.add(input[i]);
				}
			}
		}

		result[1] = heap.poll();
		result[0] = heap.poll();
		return result;
	}
}