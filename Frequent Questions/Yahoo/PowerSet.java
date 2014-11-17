import java.util.*;
public class PowerSet {
	public Set<Set<Character>> method (Set<Character> input) {
		Set<Set<Character>> result = new HashSet<Set<Character>>();
		Set<Character> tmp = new HashSet<Character>();

		ArrayList<Character> list = new ArrayList<Character>();
		for (Character letter : input) {
			list.add(letter);
		}
		boolean[] table = new boolean[input.size()];
		dfs(result, tmp, list, table);
		return result;
	}

	private void dfs(Set<Set<Character>> result, Set<Character> tmp, ArrayList<Character> list, boolean[] table) {
		//System.out.println("1111 " + tmp);
		result.add(new HashSet<Character>(tmp));



		for (int i = 0; i < list.size(); i++) {
			if (table[i] == false) {
				table[i] = true;
				tmp.add(list.get(i));
				dfs(result, tmp, list, table);
				tmp.remove(list.get(i));
				table[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		HashSet<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('b');
		set.add('c');
		PowerSet obj = new PowerSet();

		Set<Set<Character>> result = obj.method(set);
		for (Set<Character> sub : result) {
			System.out.println(sub);
		}
	}


}