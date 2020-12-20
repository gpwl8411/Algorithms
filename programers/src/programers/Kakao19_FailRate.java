package programers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Kakao19_FailRate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//카카오 블라인드 19 실패율
		int N=5;
		int[] stages= {2,1,2,6,2,4,3,3};
		int[] answer = new int[N];
		PriorityQueue<Integer> stageQ = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<stages.length;i++) {
			stageQ.add(stages[i]);
		}
		PriorityQueue<Stage> rateQ = new PriorityQueue<>();
		double total=0;
		for(int i=N;i>=1;i--) {
			int num=0;
			while(!stageQ.isEmpty()) {
				if(stageQ.peek() > i) {
					total++;
					stageQ.poll();
				}
				else if(stageQ.peek()==i) {
					num++;
					total++;
					stageQ.poll();
				}
				else
					break;
			}
			if(total==0)
				rateQ.add(new Stage(0,i));
			else
				rateQ.add(new Stage(num/total,i));
		}
		int idx=0;
		while(!rateQ.isEmpty()) {
			answer[idx++] = rateQ.poll().stageNum;
		}
		System.out.println(answer[0]);
		
	}

}
class Stage implements Comparable<Stage>{
	double rate;
	int stageNum;
	Stage(double rate,int stageNum){
		this.rate= rate;
		this.stageNum = stageNum;
	}
	@Override
	public int compareTo(Stage s) {
		if(rate == s.rate) {
			return stageNum - s.stageNum;
		}
		else {
			if(rate < s.rate)
				return 1;
			else
				return -1;
		}
	}
	
}
