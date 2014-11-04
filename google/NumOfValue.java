/*
Given sorted array and a target number, find the number of occurrences of the target number.
Solution 2: binary search, 找到target然后往两边linear搜索直到不是target为止.
Solution 3: 基于方法2，继续binary search，O(n)for worst case.
然后问我2和3什么区别，方法2：O(logn)just for best case and O(n) for worst case, 方法3：需要左右边界分开搜O(2*logn)，3更好。最后想起来如果target找不到怎么办，return-1.

*/

public class NumOfValue {
	public static void main(String[] args) {
		int[] input = {-1, 2, 3, 4, 5, 5, 5};
		System.out.println(method(input, 5));
		System.out.println(method2(input, 5));
	}

	public static int method(int[] input, int target) {
		if (input == null || input.length == 0) {
			return 0;
		}

		int left = 0, right = input.length - 1;
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (input[mid] == target) {
			
				return size(input, target, mid);
			}
			if (input[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}

		}

		if (input[left] == target) {
			return size(input, target, left);
		}

		if (input[right] == target) {
			return size(input, target, right);
		}

		return 0;

	}

	private static int size(int[] input, int target, int idx) {
		int size = 1;
		int left = idx - 1;
		while (left >= 0 && input[left] == target) {
			left--;
			size++;
		}

		int right = idx + 1;
		while (right < input.length && input[right] == target) {
			right++;
			size++;
		}

		return size;
	}

	public static int method2(int[] input, int target) {
		if (input == null || input.length == 0) {
			return 0;
		}
		if (findLeft(input, target) == -1) {
			return 0;
		}
		return findRight(input, target) - findLeft(input, target) + 1;
	}

	private static int findLeft(int[] input, int target) {
		int left = 0; 
		int right = input.length - 1;
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (input[mid] == target) {
				right = mid;
			} else if (input[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}

		}

		if (input[left] == target) {
			return left;
		} 

		if (input[right] == target) {
			return right;
		}

		return -1;
	}

	private static int findRight(int[] A, int target) {
		int left = 0; 
		int right = A.length - 1;
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (A[mid] == target) {
				left = mid;
			} else if (A[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}

		}

		if (A[right] == target) {
			return right;
		} 

		if (A[left] == target) {
			return left;
		}

		return -1;
	}
}