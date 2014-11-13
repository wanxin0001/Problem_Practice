/*
二叉树直径
http://www.geeksforgeeks.org/diameter-of-a-binary-tree/ 
*/

public class TreeDiameter {
	private static class Node {
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
	}
	public int diameter(Node root) {
		int[] height = new int[1];
		return diameterHelper(root, height);
	}

	private int diameterHelper(Node root, int[] height) {
		int[] leftHeight = new int[1];
		int[] rightHeight = new int[1];

		int leftDiameter = 0;
		int rightDiameter = 0;

		if (root == null) {
			height[0] = 0;
			return 0;
		}

		leftDiameter = diameterHelper(root.left, leftHeight);
		rightDiameter = diameterHelper(root.right, rightHeight);

		height[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;
		return Math.max(1 + leftHeight[0]+ rightHeight[0], Math.max(leftDiameter, rightDiameter));
	}

	public static void main(String[] args) {
		TreeDiameter obj = new TreeDiameter();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println(obj.diameter(root));
	}
}