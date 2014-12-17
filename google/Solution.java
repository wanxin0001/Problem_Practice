import java.util.*;
public class Solution {
	public char method(String s1, String s2) {
		

		if (s2 == null || s2.length() == 0) {
			return s1.charAt(0);
		}

		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < s2.length(); i++) {
			set.add(s2.charAt(i));
		}

		for (int i = 0; i < s1.length(); i++) {
			if (!set.contains(s1.charAt(i))) {
				return s1.charAt(i);
			}
		}

		return ' ';
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println(obj.method("apple","amazon"));
	}
}