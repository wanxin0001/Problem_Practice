public class DFS {

	//Method1: DFS
	public void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		//do something with root
		traverse(root.left);
		//do something with root
		traverse(root.right);
		//do something with root
	}

	//Method2: Divide & Conquer
	public TreeNode traverse1(TreeNode root) {
		if (root == null) {
			// do somehting and return;
		}

		//Divide
		TreeNode left = traverse1(root.left);
		TreeNode right = traverse1(root.right);


		//Conquer
		TreeNode result = Merge from left to right
		return result;
	}
}