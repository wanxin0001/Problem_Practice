/* 2. 坐标系第一象限上加射线，接下来所有输入的数据都是不相等的整数，不用考虑任何edge case。 想要这两个操作：1. insertX（x）， insertY（y），比如insertX，
就是现有的图上面加上x这条射线，象限会被插入的这些射线分成网格，每个格叫一个区域。 2. find（x，y），
就是给个坐标，返回这个坐标所在的区域。可以返回区域的id，区域的id自己定。用二叉树。*/


import java.util.*;
public class TwoDGraph {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

	public  static TreeNode rootX;
	private static TreeNode rootY;

	public TwoDGraph() {
		rootX = new TreeNode(0);
		rootY = new TreeNode(0);
	}

	public static void insertX(int x) {
		TreeNode cur = rootX;
		while (cur != null) {
			if (cur.val > x) {
				if (cur.left == null) {
					cur.left = new TreeNode(x);
					return;
				} else {
					cur = cur.left;
				}
			} else {
				if (cur.right == null) {
					cur.right = new TreeNode(x);
					return;
				} else {
					cur = cur.right;
				}
			}
		}
	}

	public static void insertY(int y) {
		TreeNode cur = rootY;
		while (cur != null) {
			if (cur.val > y) {
				if (cur.left == null) {
					cur.left = new TreeNode(y);
					return;
				} else {
					cur = cur.left;
				}
			} else {
				if (cur.right == null) {
					cur.right = new TreeNode(y);
					return;
				} else {
					cur = cur.right;
				}
			}
		}
	}

	public int[] find(int x, int y) {
		int[] result = new int[2];

		result[0] = search(rootX, x);
		result[1] = search(rootY, y);		

		return result;
	}

	private int search(TreeNode root , int val) {
		int[] range = {0, Integer.MAX_VALUE};
		TreeNode cur = root;
		while (cur != null) {
			if (cur.val == val) {
				return cur.val;
			} else if (cur.val < val) {
				if (cur.right != null) {
					range[0] = cur.val;
					cur = cur.right;
					
					continue;
				}

				range[0] = cur.val;
				break;
			} else {
				if (cur.left != null) {
					range[1] = cur.val;
					cur = cur.left;
					
					continue;
				}
				range[1] = cur.val;
				break;
			}
		}

		return range[0];
	}

	public static void main(String[] args) {
		TwoDGraph obj = new TwoDGraph();
		obj.insertX(5);
		System.out.println(obj.rootX.right.val);
		obj.insertY(5);
		System.out.println(Arrays.toString(obj.find(1, 1)));
		System.out.println(Arrays.toString(obj.find(6, 6)));
		System.out.println(Arrays.toString(obj.find(1, 6)));
		System.out.println(Arrays.toString(obj.find(6, 1)));
	}

}