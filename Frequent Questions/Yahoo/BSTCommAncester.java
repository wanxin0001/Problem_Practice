public class BSTCommAncester {
	private static class Node {
		int val;
		Node left;
		Node right;
		public Node (int val) {
			this.val = val;
			left = null;
			right = null;

		}
	}
	public Node method (Node root, int val1, int val2) { // Notice: val1 <= val2
		if (root == null)  {
			return null;
		}



		if (root.val >= val1 && root.val <= val2) {
			if (find(val1, root) && find(val2, root)) {
				return root;
			}
			return null;
		} else if (root.val <= val1 && root.val <= val2) {
			return method(root.right, val1, val2);
		} else {
			return method(root.left, val1, val2);
		}
	}
	public boolean find(int val, Node root) {
		if (root == null) {
			return false;
		}
		if (root.val == val) {
			return true;
		}

		if (root.val < val) {
			return find( val, root.right);
		} else {
			return find( val, root.left);
		}


	}
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(-1);
		root.left.right = new Node(3);
		root.right.right = new Node(10);
		root.right.left = new Node(6);
		BSTCommAncester obj = new BSTCommAncester();
		System.out.println(obj.method(root, 3, 10).val);
		System.out.println(obj.method(root, -1, 3).val);
		System.out.println(obj.method(root, 2, 6).val);
		System.out.println(obj.method(root, 2, 9));

	}
}