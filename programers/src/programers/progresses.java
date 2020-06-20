package programers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class progresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pro = {30,30,30};
		int[] sp = {60,60,60};
		int[] answer ={};
//		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int j=1;
		int cnt=0;
		for(int i=0;i<pro.length;i++){
			while(j<100){
				//pro[i]=sp[i]*j;
				System.out.println(i+" : " +pro[i]);
				if(pro[i]+sp[i]*j>=100){
					cnt++;
					break;
				}
				j++;
				if(cnt!=0){
					arr.add(cnt);
					cnt=0;
				}
			}
//			q.offer(pro[i]);
//			while(!q.isEmpty()){
//				
//			}
		}
		arr.add(cnt);
		answer = new int[arr.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = arr.get(i);
            //System.out.println(answer[i]);
        }
        System.out.println(answer[0]+" , ");
	}

}
