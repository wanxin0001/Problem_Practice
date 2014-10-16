public class BinaryOne {
	public static void main(String[] str) {
		System.out.println(method(1));
		System.out.println(method(2));
		System.out.println(method(3));
		System.out.println(method(4));
		System.out.println(method(-1));

	}
	public static int method(int num) {
		int result = 0;
		for (int i = 0; i < 32; i ++) {
			if (((num >> i) & 0x1) == 1) {
				result++;
			}
		}

		return result;
	}
}