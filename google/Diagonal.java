/*
题目是给一个 n*m 的二维数组返回一个一维数组,这个数组包含之前数组的对角线的和。 下面是例子:
[1, 2, 3
4, 5, 6
7, 8, 9] 要返回 [7, 12, 15, 8, 3]
*/
import java.util.*;

public class Diagonal {
	public static void main(String[] args) {
		int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(Arrays.toString(compute(input)));
		int[][] input1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		System.out.println(Arrays.toString(compute(input1)));
		int[][] input2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		System.out.println(Arrays.toString(compute(input2)));
	}

	public static int[] compute(int[][] input) {
		if (input == null || input.length == 0) {
			return null;
		}

		int len = input.length + input[0].length - 1;
		int[] result = new int[len];

		for (int i = 0; i < len; i++) {
			result[i] = diagonalSum(i, input);
		}

		return result;
	}

	private  static int diagonalSum(int pos, int[][] input) {
		int m = input.length;
		int n = input[0].length;
		int sum = 0;
		
		int originX = 0;
		int originY = 0;
		if (pos < m) {
			originX = m - 1 - pos;
			originY = 0;
		} else {
			originX = 0;
			originY = pos - m + 1;
		}	

		while (originX < m && originY < n) {
			sum += input[originX][originY];
			originX++;
			originY++;
		}
		return sum;
	}
}