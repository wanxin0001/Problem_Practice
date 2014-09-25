//Method 1: Iterating over entries using For-each Loop
Map<Integer, Integer> map = new Map<Integer, Integer>();
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}

//Method 2: Iterating over keys or values using For-Each Loop
Map<Integer, Integer> map = new HashMap<Integer, Integer>();

for (Integer key : map.keySet()) {
	System.out.println("Key = " + key);
}

for (Integer value : map.values()) {
	System.out.println("Value = " + value);
}


//Method 3: Iterating using Iterator
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
while (entries.hasNext()) {
	Map.Entry<Integer, Integer> entry = entries.next();
	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}