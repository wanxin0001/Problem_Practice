/* Given a m * n grid and the coordination of left bottom cell is (1, 1) and the
one of right top cell is (m, n). At each cell say (x, y), you have to choice to
move, going up or right. If you go up, the destination is (x, x+ y). Otherwise
your destination is (x + y, y). Find the minimum number of steps to reach the
cell (m, n) from (1, 1). */

import java.util.*;

public class TwoDPath {
	public static void main(String[] args) {
		System.out.println(computePath(4, 5));
	}
	public static int computePath(int m, int n) {
		
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		Integer[] orign = {1, 1};
		Integer[] dest = {m , n};
		queue.add(orign);
		int step = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer[] cur = queue.poll();
				if (isValid(cur[0] + cur[1], cur[1], m, n)) {
					if (cur[0] + cur[1] == dest[0] && cur[1] == dest[1]) {
						return step + 1;
					}
					Integer[] next = {cur[0] + cur[1], cur[1]};
					queue.add(next);
				}

				if (isValid(cur[0], cur[0] + cur[1], m, n)) {
					if (cur[0] == dest[0] && cur[0] + cur[1] == dest[1]) {
						return step + 1;
					}
					Integer[] next = {cur[0], cur[1] + cur[0]};
					queue.add(next);
				}
			}

			step++;
		}

		return -1;
	}

	private static boolean isValid(int m, int n, int row, int col) {
		if (m < 1 || m > row) {
			return false;
		}

		if (n < 1 || n > col) {
			return false;
		}

		return true;
	}
}