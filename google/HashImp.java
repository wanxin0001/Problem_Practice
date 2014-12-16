import java.util.*;
public class HashImp {
	private String word1;
	private String word2;
	public HashImp(String word1, String word2) {
		this.word1 = word1;
		this.word2 = word2;
	}
	
	@Override
	public int hashCode() {
		return word1.hashCode() ^ word2.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof HashImp) && ((HashImp) obj).word1.equals(word1) && ((HashImp) obj).word2.equals(word2);
	}

	public static void main(String[] args) {
		HashImp obj1 = new HashImp("apple", "google");
		HashImp obj2 = new HashImp("apple", "orange");
		HashImp obj3 = new HashImp("apple", "google");

		HashMap<HashImp, Integer> map = new HashMap<HashImp, Integer>();
		if (map.containsKey(obj1)) {
			map.put(obj1, map.get(obj1) + 1);
		} else {
			map.put(obj1, 1);
		}

		if (map.containsKey(obj2)) {
			map.put(obj2, map.get(obj2) + 1);
		} else {
			map.put(obj2, 1);
		}

		if (map.containsKey(obj3)) {
			map.put(obj3, map.get(obj3) + 1);
		} else {
			map.put(obj3, 1);
		}
		System.out.println(map);
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
	}
}