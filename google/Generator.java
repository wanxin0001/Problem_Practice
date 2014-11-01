import java.util.*;
public class Generator {
	private ArrayList<Integer> list;
	private int left;
	private int right;


	public Generator(int left, int right) {
		list = new ArrayList<Integer>();
		this.left = left;
		this.right = right;
	}

	public Integer next() {
		if (list.size() < right) {
			list.add(1);
			return 1;
		}

		int result = list.get(list.size() - right) + list.get(list.size() - j);

		list.add(result);

		return result;
	}

	public void 

}