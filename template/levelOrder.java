public class levelOrder {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				level.add(head.val);
				if (head.left != null) {
					queue.add(head.left);
				} else {
					queue.add(head.right);
				}

			}

			result.add(level);
		}

		return result;
	}
}