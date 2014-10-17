/*
Give you an array which has n integers,it has both positive and negative integers.Now you need sort this array in a special way.After that,the negative integers should in the front,and the positive integers should in the back.Also the relative position should not be changed. 
eg. -1 1 3 -2 2 ans: -1 -2 1 3 2. 
o(n)time complexity and o(1) space complexity is perfect.
*/

public class SpecialOrder {
	public static void main(String[] args) {
		int[] input = {-1, 1, 3, -2, 2};
		specialOrder(input, 0, input.length - 1);
		
	}

	public static void specialOrder(int[] input, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = (left + right) / 2;
		specialOrder(input, left, mid);
		specialOrder(input, mid + 1, right);

		merge(input, left, right, mid);
	}

	private static void merge(int[] input, int left, int right, int mid) {
		int first = 0;
		int second = mid + 1;
		//System.out.println(mid + " " + input[mid]);
		if (input[mid] < 0 || input[mid + 1] > 0) {
			return;
		}

		while (first <= mid) {
			if (input[first] < 0) {
				first++;
			} else {
				break;
			}
		}

		int len = 0;
		while (second <= right) {
			if (input[second] < 0) {
				len++;
				second++;
			} else {
				break;
			}
		}

		swap(input, first, second - 1);
		swap(input, first, first + len - 1);
		swap(input, first + len, second - 1);
		for (int i : input) {
			System.out.println(i);
		}
	}

	private static void swap(int[] input, int first, int second) {
		while (first < second) {
			int tmp = input[first];
			input[first] = input[second];
			input[second] = tmp;
			first++;
			second--;
		}
		return;
	}
}