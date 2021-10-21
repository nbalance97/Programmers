
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class Paper {
	int priority;
	int index;
	
	public Paper(int priority, int index) {
		this.priority = priority;
		this.index = index;
	}
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] prior_copy = Arrays.copyOf(priorities, priorities.length);
        List<Integer> list = Arrays.stream(prior_copy).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        
        Queue<Paper> printer = new LinkedList<Paper>();
        Queue<Integer> next_prior = new LinkedList<Integer>();
        
        for (int i = 0; i<priorities.length; i++) {
        	printer.offer(new Paper(priorities[i], i));
        	next_prior.offer(list.get(i));
        }
        
   
        while (true) {
        	Paper top = printer.peek();
        	int priority = next_prior.peek();
        	
        	if (top.priority == priority) {
        		answer++;
        		if (top.index == location) {
        			break;
        		}
        		next_prior.poll();
        		printer.poll();
        	} else {
        		printer.offer(printer.poll());
        	}
        }
        
        return answer;
    }
}
