public class OddEven {
	public static void method (int[] input) {
		if (input == null || input.length == 0) {
			return;
		}

		int left = 0;
		int right = input.length - 1;
		while (left < right) {
			while (input[left] % 2 != 0) {
				left++;
			} 

			while (input[right] % 2 != 1) {
				right--;
			}

			if (left < right) {
				int tmp = input[left];
				input[left] = input[right];
				input[right] = tmp;
				left++;
				right--;
			}
		}

		for (int i : input) {
			System.out.print(i + " ");
		}

		System.out.println("");

		int pos = 0;
		while (input[left] % 2 == 0) {
			if (left != 0) {
				left--;
			} else {
				break;
			}
		}
		pos = left;
		helper = new int[input.length];
		if (pos == 0) {
			sort(input, 0, input.length - 1);
		} else {
			System.out.println(pos);
			sort(input, 0, pos);
			sort(input, pos + 1, input.length - 1);
		}

		for (int i : helper) {
			System.out.print(i + " ");
		}

		System.out.println("");


		return;
	}

	private static int[] helper;
	private static int[] sort(int[] input, int left, int right) {

		if (left <= right) {

			int mid = left + (right - left) / 2;
			int[] firstArray = sort(input, left, mid);
			int[] secondArray = sort(input, mid + 1, right);

			return merge1(firstArray, secondArray);
		}
		int[] result = new int[0];
		return result;
	}


	private static int[] merge1(int[] firstArray, int[] secondArray) {
		if (firstArray == null) {
			return secondArray;
		}

		if (secondArray == null) {
			return firstArray;
		}

		int i = 0;
		int j = 0;
		int pos = 0;
		int[] result = new int[firstArray.length + secondArray.length];

		while (i < firstArray.length && j < secondArray.length){
			if (firstArray[i] <= secondArray[j]) {
				result[pos] = firstArray[i];
				i++;
			} else {
				result[pos] = secondArray[j];
				j++;
			}

			pos++;
		} 

		if (i < firstArray.length) {
			System.arraycopy(firstArray, i, result, pos, firstArray.length - i);
		}

		if (j < secondArray.length) {
			System.arraycopy(secondArray, j, result, pos, secondArray.length - j);
		}

		return result;
	}

	

	private static void swap(int[] input, int first, int second) {
		int tmp = input[first];
		input[first] = input[second];
		input[second] = tmp;
		return;
	}

	public static void main(String[] argv) {
		int[] input = {2, 1, 4, 3, 5, 6, 7};
		method(input);
	}
}