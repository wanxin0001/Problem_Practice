/* 
给一个 string,返回含有 word 的 list。word 的定义是空格(大于等于一个)之间的或者引号 之间的,如果引号里面有空格要做为一个
word 返回。比如 string 是 I have a "faux coat" 要返回[I, have, a, faux coat] 
Notice: split("\"", -1), if the first character is just ", the items[0] would be ""
*/

import java.util.*;
public class extractWords {
	public static void main(String args[]) {
		System.out.println(method("I have a \"fax coat\""));
		System.out.println(method("\"I have\" a \"fax coat\""));
	}

	public static List<String> method(String input) {
		List<String> result = new ArrayList<String>();
		if (input == null || input.length() == 0) {
			return result;
		}

		String[] parts = input.split("\"");
		
		for (int i = 0; i < parts.length; i++) {
			
			if (i % 2 == 1) {
				if (!parts[i].equals("")) {
					result.add(parts[i]);
				}
			} else {
				String[] items = parts[i].split(" ", -1);
				for (int j = 0; j < items.length; j++) {
					if (!items[j].equals("")) {
						result.add(items[j]);
					}
				}
			}
			
		}

		return result;
 	}
}