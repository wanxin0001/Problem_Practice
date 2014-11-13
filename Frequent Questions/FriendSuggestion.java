/*
Friend Suggestion，知道一个人在network里的Friends，求Friends的Friends里和这个人最多common friends的人。
Person{
    vector<Person*> Friends;
}类似这样，假设读进来是Person *a
*/

import java.util.*;
public class FriendSuggestion {
	private static class Person {
		public ArrayList<Person> friends;
		public int id;
		public Person(int id, ArrayList<Person> friends) {
			this.friends = friends;
			this.id = id;
		}

	}

	public static void main(String[] args) {
		

		Person p1 = new Person(1, new ArrayList<Person>());
		Person p2 = new Person(2, new ArrayList<Person>());
		Person p3 = new Person(3, new ArrayList<Person>());
		Person p4 = new Person(4, new ArrayList<Person>());
		Person p5 = new Person(5, new ArrayList<Person>());
		Person p6 = new Person(6, new ArrayList<Person>());
		Person p7 = new Person(7, new ArrayList<Person>());
		Person p8 = new Person(8, new ArrayList<Person>());

		p1.friends.add(p2);
		p1.friends.add(p3);
		p2.friends.add(p4);
		p2.friends.add(p5);
		p2.friends.add(p7);
		p3.friends.add(p4);
		p3.friends.add(p6);
		p3.friends.add(p8);

		FriendSuggestion obj = new FriendSuggestion();
		System.out.println(obj.findFriend(p1));
	}

	public int findFriend(Person person) {
		ArrayList<Person> friends = person.friends;
		HashSet<Integer> friendSet = new HashSet<Integer>();
		for (Person friend : friends) {
			friendSet.add(friend.id);
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (Person friend : friends) {
			ArrayList<Person> tmp = friend.friends;
			for (Person stepfriend : tmp) {
				if (map.containsKey(stepfriend.id)) {

					map.put(stepfriend.id, map.get(stepfriend.id) + 1 );
				} else {
					map.put(stepfriend.id, 1);
				}
			}
		}

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer
		,Integer>>(10, new Comp());

		for (Map.Entry<Integer, Integer> item : map.entrySet()) {
			queue.offer(item);
		}

		return queue.peek().getKey();

	}

	private static class Comp implements Comparator<Map.Entry<Integer, Integer>> {
		public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
			return b.getValue() - a.getValue();
		}
	}
}