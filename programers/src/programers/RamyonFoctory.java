package programers;

import java.util.Collections;
import java.util.PriorityQueue;

public class RamyonFoctory {

	public static void main(String[] args) {

		int stock=4;
		int[] dates={4,10,15};
		int[] supplies={20,5,10};
		int k=30;
		int answer=0;
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		int index=0;
		for(int i=0;i<k;i++){
			if(index<dates.length && i == dates[index]){
				q.add(supplies[index++]);
			}
			if(stock == 0){
				stock += q.poll();
				answer++;
			}			
				stock--;
		}
		System.out.println(answer);
	}

}
