public class CompressString {
	public static String compress(String input) {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			int size = 0;
			while (i < input.length() && input.charAt(i) == cur) {
				size++;
				i++;
			}

			i--; // Very Important!!! notice
			buffer.append(cur).append(size);
		}

		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(compress("aaabbcccccded"));
	}
}