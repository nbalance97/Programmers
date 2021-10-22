import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class element {
	int index;
	int count;
	public element(int index, int count) {
		this.index = index;
		this.count = count;
	}
}

class Solution {
    public boolean compare(String a, String b) {
    	int collect_count = 0;
    	for (int i = 0; i<a.length(); i++) {
    		if (a.charAt(i) == b.charAt(i)) {
    			collect_count += 1;
    		}
    	}
    	
    	if (collect_count == a.length() - 1) {
    		return true;
    	} else {
    		return false;
    	}
    }
	
	public int solution(String begin, String target, String[] words) {
      Queue<element> queue = new LinkedList<element>();
      boolean[] visited = new boolean[words.length];
    	int answer = 0;
    	
    	for (int i = 0; i<visited.length; i++)
    		visited[i] = false;
    	
    	for (int i = 0; i<words.length; i++) {
    		if (compare(begin, words[i])) {
    			visited[i] = true;
    			queue.offer(new element(i, 1));
    		}
    	}
    	
    	while (!queue.isEmpty()) {
    		element item = queue.poll();
    		if (words[item.index].equals(target)) {
    			answer = item.count;
    			break;
    		}
    		
    		for (int i = 0; i<words.length; i++) {
    			if (!visited[i] && compare(words[i], words[item.index])) {
    				visited[i] = true;
    				queue.offer(new element(i, item.count + 1));
    			}
    		}
    	}
    	
      return answer;
    }
}
