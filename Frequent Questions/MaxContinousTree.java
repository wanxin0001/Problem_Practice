public class MaxContinousTree {
	
	private static class Node {
		Node left;
		Node right;
		int val;

		public Node(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

	public int maxLength(Node root) {
		if (root == null) {
			return 0;
		}
		int[] maxLen = new int[1];
		maxLen[0] = 1;
		dfs(root, 0, maxLen);

		return maxLen[0];
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(2);
		MaxContinousTree obj = new MaxContinousTree();
		System.out.println(obj.maxLength(root));
	}

	private void dfs(Node root, int prev, int[] maxLen) {
		if (root == null) {
			maxLen[0] = Math.max(maxLen[0], prev);
			return;
		}

		if (root.left != null) {
			if (root.val == root.left.val  - 1) {
				dfs(root.left, prev + 1, maxLen);
			} else {
				maxLen[0] = Math.max(maxLen[0], prev);
				dfs(root.left, 1, maxLen);
			}
		} else {
			maxLen[0] = Math.max(maxLen[0], prev + 1);
		}

		if (root.right != null) {
			if (root.val == root.right.val - 1) {
				dfs(root.right, prev + 1, maxLen);
			} else {
				maxLen[0] = Math.max(maxLen[0], prev);
				dfs(root.right, 1, maxLen);
			}
		} else {
			maxLen[0] = Math.max(maxLen[0], prev + 1);
		}
	}
}