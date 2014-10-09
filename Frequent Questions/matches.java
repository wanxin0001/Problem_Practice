public class matches {
	public static void main(String[] args) {
		
		if (matchMethod1("apple", "pplea")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}


		if (matchMethod2("apple", "pplea")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}


	//by using matches() method
	//Notice: the grammer is "appleapple".matches("(.*)" + "pplea" + "(.*)");
	public static boolean matchMethod1(String first, String second) {
		if (first.length() != second.length()) {
			return false;
		}

		String newStr = first + first;

		if (newStr.matches("(.*)" + second + "(.*)")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean matchMethod2(String first, String second) {
		if (first.length() != second.length()) {
			return false;
		}
		String newStr = first + first;
		for (int i = 0; i < newStr.length() - second.length(); i++) {
			if (newStr.charAt(i) == second.charAt(0) && newStr.substring(i, i + second.length()).equals(second)) {
				return true;
			}
		}

		return false;
	}
}