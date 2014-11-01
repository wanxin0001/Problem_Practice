import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class org {
	private static class Person {
		String name;
		String boss;
		String position;
		int year;
		public Person(String input[]) {
			name = input[0];
			boss = input[1];
			position = input[2];
			year = Integer.parseInt(input[3]);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/wanxin/Downloads/org_chart.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/wanxin/Downloads/org.out"));

		int numCases = Integer.parseInt(br.readLine());
		for (int caseNum = 1; caseNum <= numCases; caseNum++) {
			String[] items = br.readLine().split("--");
			int num = items.length;
			Person[] collection = new Person[num];
			int i = 0;
			Person boss = null;
			for (String item : items) {
				String[] inputs = item.split(",");
				/*
				for (String str : inputs) {
					System.out.println(str);
				}
				*/
				collection[i] = new Person(inputs);
				if (inputs[1].equals("NULL")) {
					boss = collection[i];
				}
				i++;
			}

			TreeMap<String, TreeSet<String>> map = new TreeMap<String, TreeSet<String>>();
			HashMap<String, Person> hashMap = new HashMap<String, Person>();
			for (Person person : collection) {
				//System.out.println(person.name);
				hashMap.put(person.name, person);
				map.put(person.name, new TreeSet<String>());
			}

			for (Person person : collection) {
				if(!person.boss.equals("NULL")) {
					map.get(person.boss).add(person.name);
				} 
			}

			bw.write("Case #" + caseNum + "\n");
			dfs(map, hashMap, boss, 0, bw);


			
		}

		bw.close();
		br.close();
	}

	private static void dfs(TreeMap<String, TreeSet<String>> map, HashMap<String, Person> hashMap, Person boss, int pos, BufferedWriter bw) throws IOException{
		print(boss, pos, bw);
		TreeSet<String> employees = map.get(boss.name);
		for (String employee : employees) {
			Person person = hashMap.get(employee);
			dfs(map, hashMap, person, pos + 1, bw);
		}
	}

	private static void print(Person person, int pos, BufferedWriter bw) throws IOException{
		String slash = "";
		for (int i = 0 ;i < pos; i++) {
			slash += "-";
		}
		//System.out.println(person.name + " " + person.position + " " + person.year);
		bw.write(slash + person.name + " (" + person.position + ") " + person.year);
		bw.write("\n");
	}


}