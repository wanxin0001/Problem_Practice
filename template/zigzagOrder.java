public class zigzagOrder(TreeNode root) {
	public ArrayList<ArrayList<Integer>> zigzagOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null ) {
			return result;
		}

		Stack<TreeNode> s = new Stack<TreeNode>();
		boolean order = true;
		s.push(root);

		while(!s.isEmpty()) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			Stack<TreeNode> next = new Stack<TreeNode>();

			while (!s.pop()) {
				TreeNode current = s.pop();
				tmp.add(current.val);
				if (order) {
					if (current.left != null) {
						next.push(current.left);
					} 

					if (current.right != null) {
						next.push(current.right);
					}
				} else {
					if (current.right != null) {
						next.push(current.right);
					} else {
						next.push(current.left);
					}
				}

				order = !order;
				s = next;
				rst.add(tmp);
			}
		}
	}
}