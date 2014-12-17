/*
	5:08
*/
import java.util.*;
public class MissRange {
	private class Range {
		int left;
		int right;
		public Range(int left, int right) {
			this.left = left;
			this.right = right;
		}
		@Override
		public String  toString() {
			return left + "-" + right + "\n";
		}
	}

	public ArrayList<Range> method(int[] input) {
		ArrayList<Range> result = new ArrayList<Range>();
		result.add(new Range(0, 99));
		if (input == null || input.length == 0) {
			return result;
		}

		int j = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= result.get(j).left && input[i] <= result.get(j).right) {
				if (input[i] == result.get(j).left) {
					result.get(j).left = input[i] + 1;
				} else if (input[i] == result.get(j).right) {
					result.get(j).right = input[i] - 1;
				} else {
					result.get(j).right = input[i] - 1;
					result.add(new Range(input[i] + 1, 99));
					j++;
				}

				
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] input = {0, 3, 5, 23, 24, 60, 99};
		MissRange obj = new MissRange();
		ArrayList<Range> result = obj.method(input);
		for (Range item : result) {
			System.out.println(item.toString());
		}
	}
}