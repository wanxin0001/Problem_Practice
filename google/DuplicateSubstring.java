/*
Given an input string S write a function which returns true if it satisfies S = nT. Basically you have to find if a given string can be represented from a substring by iterating it “n” times. n >= 2

An example would suffice –

Function should return true if

1) S = “abab”

2) S = “abcdabcd”

3) S = “abcabcabc”

4) S = “zzxzzxzzx”

Function should return false if

1) S = “abac”

2) S = “abcdabbd”

3) S = “abcabcefg”

4) S = “zzxzzyzzx”


*/
import java.util.*;
public class DuplicateSubstring{
	public static void main(String[] args) {
		System.out.println(check("abab"));
		System.out.println(check("abcdabcd"));
		System.out.println(check("abcabcabc"));
		System.out.println(check("zzxzzxzzx"));
		System.out.println(check("abac"));
		System.out.println(check("abcdabbd"));
		System.out.println(check("abcabcefg"));
		System.out.println(check("zzxzzyzzx"));
	}

	public static boolean check(String input) {
		if (input == null || input.length() < 2) {
			return false;
		}

		ArrayList<Integer> pos = new ArrayList<Integer>();
		for (int i = 1; i <= input.length() / 2; i++) {  //NOTICE: i must <= input.length(), not <
			if (input.charAt(i) == input.charAt(0)) {
				pos.add(0, i);
			}
		}

		if (pos.size() == 0) {
			return false;
		}

		for (int idx : pos) {
			int len = idx;
			if (input.length() % len != 0) {
				continue;
			} else {
				boolean flag = true;
				for (int i = 0; i < input.length() / len; i++) {
					if (!input.substring(i * len, (i + 1) * len).equals(input.substring(0, len))) {
						flag = false;
						break;
					}
				}

				if (flag) {
					return true;
				}
			}
		}

		return false;
	}
}