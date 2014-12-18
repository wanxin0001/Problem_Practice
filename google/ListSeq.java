import java.util.*;
public class ListSeq {
	public String encode(List<String> words) {
		StringBuffer bf = new StringBuffer();
		Iterator it = words.iterator();
		while (it.hasNext()) {
			String cur = (String) it.next();
			for (int i = 0; i < cur.length(); i++) {
				bf.append(cur.charAt(i));
				if (cur.charAt(i) == '`') {
					bf.append("`");
				}
			}
			bf.append("`");
		}

		bf.deleteCharAt(bf.length() - 1);
		return bf.toString();
	}

	public ArrayList<String> decode(String input) {
		ArrayList<String> result = new ArrayList<String>();
		//int head = 0;
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '`') {
				bf.append(input.charAt(i));
			} else if (i < input.length() - 1 && input.charAt(i + 1) == '`') {
				bf.append(input.charAt(i));
				i++;
				continue;
			} else {
				result.add(bf.toString());
				bf = new StringBuffer();
			}

		}

		if (bf.length() != 0) {
			result.add(bf.toString());
		} 

		return result;
	} 

	public static void main(String[] args) {
		ListSeq obj = new ListSeq();
		ArrayList<String> list = new ArrayList();
		list.add("apple");
		list.add("google");
		list.add("Jack`s box");

		String tmp = obj.encode(list);
		System.out.println(tmp);

		ArrayList<String> result = obj.decode(tmp);
		for (String item : result) {
			System.out.println(item);
		}
	}
}