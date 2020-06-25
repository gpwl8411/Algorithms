package programers;

import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy {
	
	public static void main(String[] args) {
		int[] scoville ={1,2,3};
		int K = 11;
		int answer=0;
		//min 힙생성 . 우선순위 큐 이용
		//우선순위 큐 - 힙으로 구성
		Queue<Integer> minheap =new  PriorityQueue<>();
		//힙에 값 넣기
		for(int scovilleVal : scoville){
			minheap.add(scovilleVal);
		}
		//root와 자식값 스코빌지수 계산-K보다 넘으면 return 아니면 -1
		while(true){
			int min1=minheap.poll();
			if(min1>=K)
				break;
			if(minheap.size()==0){
				answer=-1;
				break;
			}
			int min2=minheap.poll();
			int calcVal = calcScoville(min1,min2);
			minheap.add(calcVal);
			answer++;
		}
		System.out.println(answer);
	}
	public static int calcScoville(int a,int b){
		return a+b*2;
	}
	
	

}
