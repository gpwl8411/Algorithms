package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex_1202 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//그리디/우선순위 큐 보석도둑
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] bag = new int[k];
		Jewelry[] jewelry = new Jewelry[n]; 
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewelry[i] = new Jewelry(m,v);
		}
		for(int i=0;i<k;i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);
		Arrays.sort(jewelry);
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		long ans=0;
		int j=0;
		for(int i=0;i<k;i++) {
			while(j < n && jewelry[j].m <= bag[i]) {
				q.add(jewelry[j].v);
				j++;
			}
			if(!q.isEmpty()) {
				ans += q.poll();
			}
		}
		
		System.out.println(ans);
		
	}

}
class Jewelry implements Comparable<Jewelry>{
	int m;//무게
	int v;//가격
	
	Jewelry(int m, int v){
		this.m = m;
		this.v = v;
	}
	
	@Override
	public int compareTo(Jewelry o) {
		return m - o.m;
	}
}
