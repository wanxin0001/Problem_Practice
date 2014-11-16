public class ClosestVal {
	public int method(int[] array, int target) {
		if (target <= array[0]) {
			return array[0];
		}

		if (target >= array[array.length - 1]) {
			return array[array.length - 1];
		}

		int left = 0;
		int right = array.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return target;
			} else if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}

		int diff = target - array[left];
		int returnVal = array[left];

		if (diff > array[right] - target) {
			return array[right];
		} else {
			return returnVal;
		}
	}

	public static void main(String[] args) {
		ClosestVal obj = new ClosestVal();
		int[] array = {1, 2, 5, 6, 8,  10, 15};
		System.out.println(obj.method(array, 4));
		System.out.println(obj.method(array, 2));
		System.out.println(obj.method(array, 11));
	}
}