package programers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location=2;
		
		Queue<Pair> queue = new LinkedList<>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		int cnt=1;
		
		for(int i=0;i<priorities.length;i++) {
			queue.add(new Pair(i,priorities[i]));
			priorityQueue.add(priorities[i]);
		}
		while(!queue.isEmpty()) {
			if(queue.peek().priority == priorityQueue.peek()) {
				if(queue.peek().location==location) {
					break;
				}
				queue.poll();
				priorityQueue.poll();
				cnt++;
			}
			else {
				Pair p = queue.poll();
				queue.add(p);
			}
			
			
		}
		System.out.println(cnt);
	}
	

}
class Pair{
	int location;
	int priority;
	Pair(int location,int priority){
		this.location = location;
		this.priority = priority;
	}
}
