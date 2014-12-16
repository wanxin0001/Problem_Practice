import java.util.*;
public class Zigzag {
	public String print(char[][] matrix) {
		StringBuffer buffer = new StringBuffer();
		boolean flag = true;
		int m = matrix.length;
		int n = matrix[0].length;
		int x = 0;
		int y = 0;
		for (int i = 0; i < m + n - 1; i++) {
			if (!flag) {
				x = i > m - 1 ? m - 1 : i;
				y = i > m - 1 ? i - m + 1 : 0;
				while (isValid(x, y, m, n)) {
					buffer.append(matrix[x][y]);
					x--;
					y++;
				}
		
			} else {
				x = i > m - 1 ? i - m + 1: 0;
				y = i > m - 1 ? n - 1 : i;
				while (isValid(x, y, m, n)) {
					buffer.append(matrix[x][y]);
					x++;
					y--;
				}
			}
			flag = !flag;
		}

		return buffer.toString();

	}

	private boolean isValid(int x, int y, int m, int n) {
		if (x>= 0 && x < m && y >= 0 && y < n) {
			return true;
		}

		return false;
	}
	public static void main(String[] args) {
		Zigzag obj = new Zigzag();
		char[][] input = {{'a','b','c'}, {'d','e','f'}, {'g','h','i'}};
		System.out.println(obj.print(input));
	}
}