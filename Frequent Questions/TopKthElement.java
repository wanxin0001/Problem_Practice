import java.util.*;
public class TopKthElement {
	public static int selectKth(int[] input, int k) {
		if (input == null || input.length <= k) {
			throw new Error();
		}

		int from = 0, to = input.length - 1;

		while (from < to) {
			int left = from;
			int right = to;
			int mid = input[(left + right) / 2];

			while (left < right ) {
				if (input[left] >= mid) {
					int tmp = input[left];
					input[left] = input[right];
					input[right] = tmp;
					right--;
				} else {
					left++;
				}
			}

			if (input[left] > mid) {
				left--;
			}

			if (k <= left) {
				to = left;
			} else {
				from = left + 1;
			}
		}

		return input[k];
	}

	public static void main(String[] args) {
		Integer[] input = {-1, -5, -8, 4, 6, 3, 8};
		System.out.println(selectKth(input, 1)); // k starts at 0
		
	}
}


