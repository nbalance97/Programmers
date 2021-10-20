import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
    	HashMap<String, Boolean> hashmap = new HashMap<String, Boolean>();
    	Arrays.sort(phone_book, new Comparator<String>(){
    		@Override
    		public int compare(String a, String b) {
	    		if (a.length() < b.length()) {
	    			return -1;
	    		} else if (a.length() == b.length()) {
	    			return 0;
	    		} else {
	    			return 1;
	    		}
    		}
    	});
        
    	for (String phone:phone_book) {
    		for (int i=0; i<phone.length(); i++) {
    			String temp = phone.substring(0, phone.length()-i);
    			if (hashmap.get(temp) != null) {
    				return false;
    			}
    		}
    		hashmap.put(phone, true);
    	}
    	return true;
    }
}
