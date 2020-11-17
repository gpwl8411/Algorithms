package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_11724 {

	static int answer;
	static boolean[] visited;
	static List<Integer>[] list;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ; 
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1;i<=n;i++) {
			if(visited[i])
				continue;
			visited[i]=true;
			dfs(i);
			answer++;
		}
		System.out.println(answer);
		
		
	}
	static void dfs(int v) {
		for(int i=0;i<list[v].size();i++) {
			int u = list[v].get(i);
			if(visited[u])
				continue;
			visited[u]=true;
			dfs(u);
		}
	}

}
