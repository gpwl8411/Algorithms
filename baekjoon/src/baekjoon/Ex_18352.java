package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_18352 {

	static List<Integer>[] list;
	static boolean[] visited;
	static int[] dist;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//다익스트라 특정 거리의 도시 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		list = new List[n+1];
		dist = new int[n+1];
		visited = new boolean[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0;i<=n;i++)
			list[i]=new ArrayList<>();
		dist[x]=0;
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
		}
		
		dijk(x);
		StringBuilder ans = new StringBuilder();
		for(int i=0;i<=n;i++) {
			if(dist[i]==k)
				ans.append(i+"\n");
		}
		if(ans.length()==0)
			ans.append("-1");
		System.out.println(ans);
		
	}
	static void dijk(int start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start,0});
		visited[start]=true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curNode = cur[0];
			int curDis = cur[1];
			
			for(int i=0;i<list[curNode].size();i++) {
				int next = list[curNode].get(i);
				if(dist[next] > curDis+1 && !visited[next]) {
					dist[next] = curDis+1;
					visited[next]=true;
					q.add(new int[] {next,curDis+1});
				}
			}
		}
	}


}