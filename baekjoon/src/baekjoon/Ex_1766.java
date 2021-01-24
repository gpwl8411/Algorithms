package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex_1766 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//위상정렬 최종 순위
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new List[n+1];
		int[] in = new int[n+1];
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			in[to]+=1;
			list[from].add(to);
		}
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=1;i<=n;i++) {
			if(in[i]==0) {
				q.add(i);
			}
			
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int num = q.poll();
			sb.append(num+" ");
			for(int i : list[num]) {
				in[i]-=1;
				if(in[i]==0)
					q.add(i);					
				
			}
			
		}
		System.out.println(sb);
	}

}
