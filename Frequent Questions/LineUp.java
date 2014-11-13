/*
一些人排成队，每个人知道自己前面有多少个人比自己高。已知每个人的身高。要求根据这些信息求出原先排好的队。
贪心算法，

*/
import java.util.*;
public class LineUp {
	private  static class Person {
		int height;
		int beforeNum;
		public Person(int height, int beforeNum) {
			this.height = height;
			this.beforeNum = beforeNum;
		}
	}
	public void lineUp(Person[] input) {
		Arrays.sort(input, new Comp());
		for (int i = 1; i < input.length; i++) {
			int beforeNum = 0, shiftLeft = i;
			for (int j = 0; j < i; j++) {
				if (input[j].height > input[i].height) {
					beforeNum++;
				}
			}

			while (beforeNum > input[shiftLeft].beforeNum  && shiftLeft >= 1) { //Notice it is input[shiftLeft]
				if (input[shiftLeft].height < input[shiftLeft - 1].height) {
					beforeNum--;
				}
				swap(shiftLeft, shiftLeft - 1, input);
				shiftLeft--;
			}
		}
	}

	private void swap(int left, int right, Person[] input) {
		Person tmp = input[left];
		input[left] = input[right];
		input[right] = tmp;
	}

	private class Comp implements Comparator<Person> {
		public int compare(Person a, Person b) {
			return b.height - a.height;
		}
	}

	public static void main(String[] args) {
		LineUp obj = new LineUp();
            // 8 3 5 6 9 1 2 7 4
          Person[] array = {new Person(5, 1), new Person(2, 1), new Person(9, 0),
                              new Person(8, 0), new Person(4, 3), new Person(1, 5),
                              new Person(7, 2), new Person(6, 1), new Person(3, 1)};
            obj.print(array);
            obj.lineUp(array);
            obj.print(array);

    }

    public static void print(Person[] array) {
        System.out.print("Height: ");
        for (Person p : array)
                System.out.print(p.height + " ");
        System.out.print("\nHigher: ");
        for (Person p : array)
                System.out.print(p.beforeNum + " ");
        System.out.println("\n");
	}

}