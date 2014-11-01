public class String2Long {
	public static long stringToLong(String s) throws NumberFormatException {
		if (s == null || s.length() == 0) {
			throw new NumberFormatException("The input is null");
		} 

		long result = 0;
		boolean isNegative = false;
		if (s.length() == 1 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
			throw new NumberFormatException(s + " is not the valid number format");
		}
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && s.charAt(i) == '-') {
				isNegative = true;
				continue;
			} else if (i == 0 && s.charAt(i) == '+') {
				continue;
			}

			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				result = 10 * result + s.charAt(i) - '0';
			} else {
				throw new NumberFormatException(s + " is not the valid number format");
			}
		}

		if (isNegative) {
			return 0 - result;
		} else {
			return result;
		}
	}

	public static void test(String s) {
		long i = stringToLong(s);
		if (i == 123) {
			System.out.println(i);
			System.out.println("Success");
		} else {
			System.out.println(i);
		}
	}

	public static void main (String[] args) {
		test("123");
		test("11111111111111");
		test("-1");
		test("-");
	}
}