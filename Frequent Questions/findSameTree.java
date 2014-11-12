/*
1，给一个二叉树，让找出所有相同的子树。
先说了枚举所有节点对然后递归判断的n^3简单方法，面试官不满意，然后用memo优化到O(n^2)，写完解释了一会就算结束了。
*/
import java.util.*;

public class findSameTree {
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

	public int sameTree(Node root) {
		if (root == null || root.left == null || root.right == null) {
			return 0;
		}

		HashMap<Node, Integer> map = new HashMap<Node, Integer>();
		dfs(map, root);


		HashMap<Integer, ArrayList<Node>> list = new HashMap<Integer, ArrayList<Node>>();

		for (Map.Entry<Node, Integer> entry : map.entrySet()) {
			if (list.containsKey(entry.getValue())) {
				list.get(entry.getValue()).add(entry.getKey());
			} else {
				list.put(entry.getValue(), new ArrayList<Node>()); 
				list.get(entry.getValue()).add(entry.getKey());
			}

		}

		int size = 0;
		for (Map.Entry<Integer, ArrayList<Node>> entry : list.entrySet()){
			ArrayList<Node> cur = entry.getValue();
			if (cur.size() >= 2) {
				for (int i = 0; i < cur.size() - 1; i++) {
					for (int j = i + 1; j < cur.size(); j++) {
						if (isSameTree(cur.get(i), cur.get(j))) {
							size++;
						}
					}
				}
			}
		}

		return size;
	}

	private boolean isSameTree(Node first, Node second) {
		if (first == null && second == null) {
			return true;
		}

		if (first != null && second != null && first.val == second.val) {
			return isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
		}

		return false;
	}

	private int dfs(HashMap<Node, Integer> map, Node root ) {
		if (root.left == null && root.right == null) {
			map.put(root, 1);
			return 1;
		}

		if (root.left == null) {
			int cur = 1 + dfs(map, root.right);
			map.put(root, cur);
			return cur;
		}

		if (root.right == null) {
			int cur = 1 + dfs(map, root.left);
			map.put(root, cur);
			return cur;
		}

		int cur = 1 + Math.max(dfs(map,root.left), dfs(map, root.right));
		map.put(root, cur);
		return cur;
	}

	public static void main(String[] args) {
		findSameTree obj = new findSameTree();
		Node root = new Node(1);
		root.left = new Node(1);
		root.right = new Node(1);
		root.left.left = new Node(2);
		root.left.right = new Node(3);
		root.right.left = new Node(2);
		root.right.right = new Node(3);
		root.right.right.right = new Node(4);

		System.out.println(obj.sameTree(root));
	}
}