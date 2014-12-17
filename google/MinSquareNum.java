import java.util.*;
public class MinSquareNum {
	public void method(int input) {
		if (input < 1) {
			return;
		
		}

		int num = 1;
		while (num * num <= input) {
			num = num + 1;
		}

		num--;
		int[] array = new int[num];
		for (int i = 1; i <= num; i++) {
			array[i - 1] = i * i;
		}
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		int[] minSize = new int[1];
		minSize[0] = input;
		int[] curSize = new int[1];
		curSize[0] = 0;
		helper(input, array, tmp, minSize, curSize, res);

		for (int item : res) {
			System.out.println(item);
		}
	}

	private void helper(int input, int[] array, ArrayList<Integer> tmp, int[] minSize, int[] curSize, ArrayList<Integer> res) {
		if (input == 0) {
			minSize[0] = Math.min(minSize[0], curSize[0]);
			System.out.println(tmp);
			res.clear();
			res.addAll(tmp);
			return;
		}

		
		for (int i = array.length - 1; i >= 0; i--) {
			if (input >= array[i]) {
				tmp.add(array[i]);
				curSize[0]++;
				if (curSize[0] < minSize[0]) {
					helper(input - array[i], array, tmp, minSize, curSize, res);
				}
				curSize[0]--;
				tmp.remove(tmp.size() - 1);
			}
		}

		return;
	}

	public static void main(String[] args) {
		MinSquareNum obj = new MinSquareNum();
		obj.method(50);
		obj.method(14);
	}
}