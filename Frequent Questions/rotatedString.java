public class rotatedString {
	public static void main(String[] args) {
		String str = "applegoogle";
		int len = str.length();
		char[] array = str.toCharArray();

		int k = 6; //move right for 6 bits;
		reverseString(array, 0, len - 1);
		reverseString(array, 0, k - 1);
		reverseString(array, k, len - 1);
		String result = new String(array);
		System.out.println(result);
	}

	private static void reverseString(char[] array, int left, int right) {
		while (left < right) {
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++;
			right--;
		}

		return;
	}
}