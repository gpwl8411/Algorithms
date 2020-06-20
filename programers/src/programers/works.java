package programers;

import java.util.Collections;
import java.util.PriorityQueue;

public class works {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int works[]={4,3,3};
		long answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<works.length;i++){
			q.add(works[i]);
		}
		for(int i=0;i<n;i++){
			int max = q.poll();
			max--;
			//if(max<0) return answer;
			q.add(max);
		}
		while(!q.isEmpty()){
			int t = q.poll();
			answer+=t*t;
		}
		System.out.println(answer);
	}

}
