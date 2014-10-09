public class indexOf {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		String v = "aeiouAEIOU";
		String string = "banadde";
		for (int i = 0; i < string.length(); i++) {
			if (v.indexOf(string.charAt(i)) == -1) {
				sb.append(string.charAt(i));
			}
		}
		System.out.println(sb.toString());
	}
}