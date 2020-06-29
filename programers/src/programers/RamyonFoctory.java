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
		//해당하는 날짜일경우 넣을 수 있음.stock이 비거나 그전에 날짜는 사용할수 있으므로
		//5일에 stock이 빌경우 1~5일까지 공급받을 수 있는 양에서 가장 큰값을 골라서 받음
		//큰값을 고르는 정렬을 priority큐를 이용함
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
