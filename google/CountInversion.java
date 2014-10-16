/*
求 array 里 unordered pair 的数量(前一个数比后一个数大)比如{1, 3, 2}里面有一个(3, 2), {1, 2, 3}里面没有, {3, 2, 1}里面有三个(3, 2) (3, 1) (2, 1)
Time Complexity is O(nlogn)

*/
import java.util.*;
public class CountInversion {
	public static void main(String[] args) {
		int[] input = {3, 2, 1};
		CountInversion obj = new CountInversion();
		System.out.println(obj.invCount(input));

		int[] input1 = {1, 2, 3};
		System.out.println(obj.invCount(input1));

		int[] input2 = {1, 3, 2};
		System.out.println(obj.invCount(input2));

	}

	public int merge(int[] arr, int[] left, int[] right) {
		int invNum = 0;
		int i = 0;
		int j = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[i + j] = left[i];
				i++;
			} else {
				arr[i + j] = right[j];
				j++;
				invNum += left.length - i;
			}

			
			
		}

		while (i != left.length) {
			arr[i + j] = left[i];
			i++;
		}

		while (j != right.length) {
			arr[i + j] = right[j];
			j++;
		}

		return invNum;
	}

	public int invCount(int[] arr) {
		if (arr.length < 2) {
			return 0;
		}

		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);

		return invCount(left) + invCount(right) + merge(arr, left, right);
	}
}