public class RemoveYuanYin {
	public static String remove(String input) {
		String word = "aeiouAEIOU";
		if (input == null || input.length() == 0) {
			return input;
		}

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			if (word.indexOf(input.charAt(i)) == -1) {
				buffer.append(input.charAt(i));
			}
		}

		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(remove("apple"));
	}
}