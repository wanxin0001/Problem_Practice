public class TrinaryTree {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode mid;
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
			mid = null;
		}
	}

	private static TreeNode root = null;
	private static TreeNode myParent = root;
	


	public void put(int value) {
		if (root == null) {
			root = new TreeNode(value);
			return;
		}

		TreeNode current = findTreeNode(value);
		if (current != null) {
			while (current.mid != null) {
				current = current.mid;
			}
			current.mid = new TreeNode(value);
			return;
		}

		TreeNode newNode = new TreeNode(value);
		if (value < myParent.val) {
			myParent.left = newNode;
		} else {
			myParent.right = newNode;
		}

		return;
	}

	public void remove(int value) {
		TreeNode cur;
		TreeNode parent;
		TreeNode successor;

		// Case 0: there is no the deleted node
		cur = findTreeNode(value);
		if (cur == null) {
			return;
		}

		// Case 1: the deleted node is in the mid pos
		if (cur.mid != null) {
			parent = myParent;
			while (cur.mid != null) {
				parent = cur;
				cur = cur.mid;
			}

			parent.mid = null;
			return; 
		}

		


		// Case 1: the deleted node doesn't have left or right node
		if (cur.left == null && cur.right == null) {
			if (cur == root && cur.mid == null) {
				root = null;
				return;
			}

			parent = myParent;
			if (parent.left == cur) {
				parent.left = null;
			} else if (parent.right == cur) {
				parent.right = null;
			} 

			return;

		}


		//Case 2: the deleted node has only left node or right node
		if (cur.right == null) {
			if (cur == root) {
				root = root.left;
				return;
			}

			parent = myParent;
			if (parent.left == cur) {
				parent.left = cur.left;
			} else {
				parent.right = cur.left;
			}

			return;
		}

		if (cur.left == null) {
			if (cur == root) {
				root = root.right;
				return;
			}

			parent = myParent;
			if (parent.left == cur) {
				parent.left = cur.right;
			} else {
				parent.right = cur.right;
			}

			return;
		}

		//Case 3: the deleted node has both left and right node
		if (cur.right.left == null) {
			cur.val = cur.right.val;
			cur.mid = cur.right.mid;
			cur.right = cur.right.right;
			return;
		}

		TreeNode successorParent = cur;
		successor = cur.right;
		while (successor.left != null) {
			successorParent = successor;
			successor = successor.left;
		}

		cur.val = successor.val;
		cur.mid = successor.mid;
		successorParent.left = successor.right;
	}

	private TreeNode findTreeNode(int value) {
		if (root == null) {
			return null;
		}
		TreeNode cur = root;

		while (cur != null) {
			if (cur.val == value) {

				return cur;
			} else if (cur.val > value) {
				myParent = cur;
				cur = cur.left;
			} else {
				myParent = cur;
				cur = cur.right;
			}
		}

		
		return null;
	}


	public void printnode(TreeNode x, int h)
   {
      
      for (int i = 0; i < h; i++)
         System.out.print("        ");

      System.out.print("[" + x.val + "]");
      while (x.mid != null ) {
      
         System.out.print("    ");

      	System.out.print("[" + x.mid.val + "]");
      	x = x.mid;
      }
      System.out.println("");
   }

   void printBST()
   {
      showR( root, 0 );
      System.out.println("================================");
   }

   public void showR(TreeNode t, int h)
   {
      if (t == null)
         return;

      showR(t.right, h+1);
      printnode(t, h);
      showR(t.left, h+1);
   }
}