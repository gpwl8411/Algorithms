package programers;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

	public static void main(String[] args) {
		String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int[] answer = new int[2];
		for (int i = 0; i < operations.length; i++) {
			String[] s = operations[i].split(" ");
			if (s[0].equals("D") && !minHeap.isEmpty() && !maxHeap.isEmpty()) {
				if (s[1].equals("1")) {
					int max = maxHeap.poll();
					minHeap.remove(max);
				} else if (s[1].equals("-1")) {
					int min = minHeap.poll();
					maxHeap.remove(min);
				}
			}
			else if(s[0].equals("I")){
				minHeap.add(Integer.parseInt(s[1]));
				maxHeap.add(Integer.parseInt(s[1]));				
			}

		}

		if(!minHeap.isEmpty()&&!maxHeap.isEmpty()){
			answer[0]=maxHeap.poll();
			answer[1]=minHeap.poll();
		}
			System.out.println(answer[0]+" , "+answer[1]);
		
	}

}
