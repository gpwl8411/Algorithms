package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_1005 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//ACM Craft 위상정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			List<Integer>[] list = new List[n+1];
			int[] in = new int[n+1];
			int[] d = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=n;i++) {
				d[i] = Integer.parseInt(st.nextToken());
				list[i] = new ArrayList<>();
			}
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				in[to]+=1;
				list[from].add(to);
			}
			int w = Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			int[] time = new int[n+1];
			for(int i=1;i<=n;i++) {
				if(in[i]==0)
					q.add(i);
				time[i] = d[i];
			}
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int i : list[cur]) {
					time[i] = Math.max(time[i], time[cur]+d[i]);
					in[i]-=1;
					if(in[i]==0)
						q.add(i);
				}
				
			}
			bw.append(time[w]+"\n");
			
			
		}
		bw.flush();
	}

}
