/*
Find the seed of a number. 
Eg : 1716 = 143*1*4*3 =1716 so 143 is the seed of 1716. find all possible seed for a given number.
*/
import java.util.*;

public class Seed {
	public static void main(String[] args) {
		System.out.println(seed(1716));

	}

	public static ArrayList<Integer> seed(int input) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (input < 0) {
			return result;
		} 
		if (input == 0) {
			result.add(0);
			return result;
		}
		int len = 0;
		int tmp = input;
		while (tmp != 0) {
			len++;
			tmp = tmp / 10;
		}

		
		dfs(result, 0, input, len);

		return result;
	}

	private static void dfs(ArrayList<Integer> result, int tmp, int input, int len) {
		if (len == 0) {
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (input % i == 0) {

				if (input / i == tmp * 10 + i) {
					
					result.add(tmp * 10 + i);
					return;
				}

				dfs(result, tmp * 10 + i, input / i, len - 1);
			}
		}
	}
}