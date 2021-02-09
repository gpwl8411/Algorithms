package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_9466 {
	static int ans;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//텀 프로젝트 그래프 탐색
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			ans=0;
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			List<Integer>[] in = new List[n+1];
			boolean[] visited = new boolean[n+1];
			for(int i=0;i<=n;i++) {
				in[i] = new ArrayList<>();
			}
			for(int i=1;i<=n;i++) {
				int num = Integer.parseInt(st.nextToken());
				 in[num].add(i);

			}
			for(int i=1;i<=n;i++) {
				if(in[i].size()==0) {
					visited[i]=true;
					continue;
				}
				if(!visited[i]) 
					dfs(i,i,in,visited,0);
			}
			bw.append(n-ans+"\n");
			
			
		}
		bw.flush();
	}
	static void dfs(int start,int num,List<Integer>[] in,boolean[] visited,int cnt) {

		if(start==num && visited[num]) {
			ans+=cnt;
			return;
		}
		if(visited[num])
			return;
		visited[num]=true;
		for(int i : in[num]) {
			if(!visited[i] || i==start)
				dfs(start,i,in,visited,cnt+1);
		}
	}

}
