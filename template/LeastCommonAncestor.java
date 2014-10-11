public class LeastCommonAncestor {
	public TreeNode getAncestor (TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || root == node1 || root == node2) {
			return root;
		}

		//Divide
		TreeNode left = getAncestor(root.left, node1, node2);
		TreeNode right = getAncestor(root.right, node1, node2);

		//Conquer
		if (left != null && right != null) {
			return root;
		} else if (left != null ) {
			return left;
		} else if (right != null) {
			return right;
		}

		return null;
	}

	public TreeNode latestCommonAncestor(TreeNode node1, TreeNode node2) {
		if (node1 == null || node2 == null) {
			return null;
		}

		TreeNode root = getRoot(node1);
		return getAncestor(root, node1, node2);
	}
}