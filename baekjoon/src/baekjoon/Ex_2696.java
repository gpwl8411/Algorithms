package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex_2696 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//중앙값 구하기 자료구조
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minQ = new PriorityQueue<>();
			StringBuilder sb2 = new StringBuilder();
			int i=1;
			while(n > 0) {
				st = new StringTokenizer(br.readLine());
				n-=10;
				while(st.hasMoreTokens()) {
					int num = Integer.parseInt(st.nextToken());
					
	                if (maxQ.size() == minQ.size()) {
	                    maxQ.offer(num);
	                } else {
	                    minQ.offer(num);
	                }
	 
	                if (!minQ.isEmpty()) {
	                    if (maxQ.peek() > minQ.peek()) {
	                        int t1 = maxQ.poll();
	                        int t2 = minQ.poll();
	 
	                        maxQ.offer(t2);
	                        minQ.offer(t1);
	                    }
	                }
					if(i%2==1) {
						sb2.append(maxQ.peek()+" ");
					}
					
					i++;
				}
				if((i-1)%20==0)
					sb2.append("\n");
				
			}
			sb.append((i-1)/2+1+"\n");
			sb.append(sb2.toString());
			sb.append("\n");
			
			
		}
		System.out.println(sb);
	}

}
