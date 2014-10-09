import java.util.*;

public class Test_2D_Key {
	public static void main (String[] args) {
		HashMap<Node, Integer> map = new HashMap<Node, Integer>();
		Node[] nodes = new Node[3];
		nodes[0] = new Node(0, 1);
		nodes[1] = new Node(0, 1);
		nodes[2] = new Node(0, 2);

		for (int i = 0; i < nodes.length; i++) {
			if (map.containsKey(nodes[i])) {
				map.put(nodes[i], map.get(nodes[i]) + 1);
			} else {
				map.put(nodes[i], 1);
			}
		}

		for (Map.Entry<Node, Integer> set :  map.entrySet()) {
			System.out.println(set.getKey().x +" " + set.getKey().y + " " + set.getValue());
		}

		return;
	}

	private static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean equals(Node comp) {
			if (this.x == comp.x && this.y == comp.y) {
				return true;
			} else {
				return false;
			}
		}
		public int hashCode() {
			System.out.println(Integer.toString(this.x).hashCode() * Integer.toString(this.y).hashCode());
			return Integer.toString(this.x).hashCode() * Integer.toString(this.y).hashCode();
		}
	}


}