/*
给string, 只包含{0,1,?}, ?可以代表0或者1, 输出所有的组合. 例如"10?", 输出"100", "101"
*/
import java.util.*;
public class RandComb {
	public ArrayList<String> method(String input) {
		ArrayList<String> result = new ArrayList<String>();
		if (input == null || input.length() == 0) {
			return result;
		}

		dfs(result, "", input, input.length());
		return result;

	}

	private void dfs(ArrayList<String> result, String tmp, String input, int len) {
		if (input.length() == 0) {
			result.add(new String(tmp));
			return;
		}

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '?') {
				tmp += input.charAt(i);
				//dfs(result, tmp, input.substring(i + 1));

				if (tmp.length() == len) {
					result.add(new String(tmp));
					return;
				}
			} else {
				dfs(result, tmp + "1", input.substring(i + 1), len);
				dfs(result, tmp + "0", input.substring(i + 1), len);

			}
		}


	}

	public static void main(String[] args) {
		RandComb obj = new RandComb();
		System.out.println(obj.method("123"));
		System.out.println(obj.method("1?23"));
		System.out.println(obj.method("?123"));
		System.out.println(obj.method("123?"));
		System.out.println(obj.method("123??"));
	}
}