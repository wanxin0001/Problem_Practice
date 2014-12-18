/*
find the longest increasing sequence in an integer matrix in 4 directions (up down left right), return the sequence; for example: input:
1234      
8765,  output should be 12345678
这个题我用dfs＋backtracking做的
*/
import java.util.*;
public class IncSeq {
	public ArrayList<Integer> dfs(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean[][] flag =  new boolean[m][n];
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(matrix[i][j]);
				flag[i][j] = true;
				dfsHelper(result, tmp, flag, i, j, matrix);
				flag[i][j] = false;
				tmp.remove(tmp.size() - 1);
			}
		}

		return result;
	}

	private void dfsHelper(ArrayList<Integer> result, ArrayList<Integer> tmp, boolean[][] flag, int i, int j, int[][] matrix) {
		int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
		boolean flag1 = true;
		for (int[] dir : dirs) {
			if (isValid(flag, i, j, dir, matrix)) {
				flag[i + dir[0]][j + dir[1]] = true;
				tmp.add(matrix[i + dir[0]][j + dir[1]]);
				dfsHelper(result, tmp, flag, i + dir[0], j + dir[1], matrix);
				tmp.remove(tmp.size() - 1);
				flag[i + dir[0]][j + dir[1]] = false;
				flag1 = false;
			}
		}
		if (flag1) {
			if (result.size() < tmp.size()) {
				result.clear();
				result.addAll(tmp);
				return;
			}
		}
	}

	private boolean isValid(boolean[][] flag, int i, int j, int[] dir, int[][] matrix) {
		int x = i + dir[0];
		int y = j + dir[1];
		if (x < 0 || x >= flag.length || y < 0 || y >= flag[0].length) {
			return false;
		}
		if (flag[x][y] == true) {
			return false;
		} 

		if (matrix[x][y] > matrix[i][j]) {
			return true;
		} else {
			return false;
		}


	}

	public static void main(String[] args) {
		int[][] input = {{1, 2, 3, 4}, {8, 7, 6, 5}};
		IncSeq obj = new IncSeq();
		System.out.println(obj.dfs(input));
	}

	

}