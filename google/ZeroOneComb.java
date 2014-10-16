/*
给 string, 只包含{0,1,?}, ?可以代表 0 或者 1, 输出所有的组合. 例如"10?", 输出"100", "101"
*/

import java.util.*;
public class ZeroOneComb {
	public static void main(String[] args) {
		String input = "10?";
		System.out.println(combination(input));
	}

	public static ArrayList<String> combination(String input) {
		ArrayList<String> result = new ArrayList<String>();
		if (input == null || input.length() == 0) {
			return result;
		}

		dfs(result, "", input, 0);
		return result;
	}

	private static void dfs(ArrayList<String> result, String tmp, String input, int pos) {
		if (pos == input.length()) {
			result.add(new String(tmp));
			return;
		}

		for (int i = pos; i < input.length(); i++) {
			if (input.charAt(i) == '?') {
				dfs(result, tmp + '0', input, i + 1);
				dfs(result, tmp + '1', input, i + 1);
			} else {
				tmp += input.charAt(i);		
			}
		}
	}
}