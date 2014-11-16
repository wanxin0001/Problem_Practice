public class BSTSearch {
	public static  Node search(Node root, int val) {
		if (root == null) {
			return null;
		}

		if (root.val == val) {
			return root;
		} else if (root.val < val) {
			return search(root.right, val); 
		} else {
			return search(root.left, val);
		}
	}

	public static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.right.right = new Node(5);

		System.out.println(search(root, 5).val);
		System.out.println(search(root, 4).val);
		System.out.println(search(root, -1));
	}
}