import java.util.*;
public class FlattenList {
	public List<Integer> flattenList(int[][] input) {
		List<Integer> result = new ArrayList<Integer>();
		if (input == null || input.length == 0) {
			return result;
		}

		int size = input.length;
		int maxLen = 0;
		for (int i = 0; i < size; i++) {
			maxLen = Math.max(maxLen, input[i].length);
		}

		for (int i = 0; i < maxLen; i++) {
			for (int j = 0; j < size; j++) {
				if (input[j].length >= i + 1) {
					result.add(input[j][i]);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		FlattenList obj = new FlattenList();
		int[][] input = {{7, 8, 9}, {}, {2, 3, 5}, {1, 19}};
		System.out.println(obj.flattenList(input));
	}
}