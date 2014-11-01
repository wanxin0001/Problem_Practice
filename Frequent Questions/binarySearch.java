public class binarySearch {
	public int binarySearchMethod (int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		} 

		int left = 0;
		int right = A.length - 1;
		int mid;

		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (A[mid] == target) {
				return mid;
			}
			else if (A[mid] < target) {
				left = mid;
			} else {
				rigtht = mid;
			}

			
		}

		if (A[left] == target) {
			return left;
		} else if (A[right] == target) {
 			return right;
		} 

		return -1;

	}
}