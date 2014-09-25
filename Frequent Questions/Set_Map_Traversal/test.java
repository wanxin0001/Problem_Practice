public class test {
	private  static class Node {
		Node next;
		int val;
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public static void main (String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);

		n1.next = n2;
		n2.next = n3;
		Node head = n1;

		delete(head);
		System.out.println(head.val);

	}

	private static void delete(Node head) {
		head.val = head.next.val;
		head.next = head.next.next;
		return;
	}
}