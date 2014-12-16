public class findNum {
	public  int findNum(int[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid =  left + (right - left) / 2;
			if (array[mid] == mid) {
				left = mid;
			} else if (array[mid] > mid) {
				right = mid;
			} else {
				left = mid;
			}
		}

		int index = -1;
		if (array[right] > right) {
			index = right;
		}

		if (array[left] > left) {
			index = left;
		}

		return array[index - 1] + 1;


	}

	public static void main(String[] agrs) {
		findNum obj = new findNum();
		int[] array1 = {0, 2, 3, 4, 5};
		int[] array2 = {0, 1, 3, 4, 5};
		int[] array3 = {0, 1, 2, 4, 5};
		int[] array4 = {0, 1, 2, 3, 5};
		
		System.out.println(obj.findNum(array1));
		System.out.println(obj.findNum(array2));
		System.out.println(obj.findNum(array3));
		System.out.println(obj.findNum(array4));

	}
}