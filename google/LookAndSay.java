import java.util.*;
public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        
        if (n == 1) {
            return "1";
        }
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = helper(result);
        }
        
        return result;
    }
    
    private String helper(String input) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            int size = 1;
            while(i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                size++;
                i++;
            }
            bf.append(size);
            bf.append(input.charAt(i));
        }
        return bf.toString();
    }

    public String decode(String input) {
    	StringBuffer bf = new StringBuffer();
    	for (int i = 0; i < input.length(); i = i + 2) {
    		int size = Integer.parseInt(input.charAt(i)+"");
    		for (int j = 0; j < size; j++) {
    			bf.append(input.charAt(i + 1));
    		}
    	}

    	return bf.toString();
    }

    public static void main(String[] args) {
    	Solution obj = new Solution();
    	System.out.println(obj.decode("111221"));
    }
}