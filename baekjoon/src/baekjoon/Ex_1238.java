package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex_1238 {

	static List<Town>[] list,reverseList;
	static int[] dist;
	static int[] reverseDist;
	static final int INF = Integer.MAX_VALUE;
	static int n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//다익스트라 파티
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		list = new List[n+1];
		reverseList = new List[n+1];
		dist = new int[n+1];
		reverseDist = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<Town>();
			reverseList[i] = new ArrayList<Town>();
		}
		Arrays.fill(dist, INF);
		Arrays.fill(reverseDist, INF);
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			list[a].add(new Town(b,t));
			reverseList[b].add(new Town(a,t));
		}
		
		dijkstra(x,list,dist);
		dijkstra(x,reverseList,reverseDist);
		int max = 0;
		for(int i=1;i<=n;i++) {
			max = Math.max(max, dist[i]+reverseDist[i]);
		}
		System.out.println(max);
	}
	
	static void dijkstra(int start,List<Town>[] list, int[] dist) {
		PriorityQueue<Town> q = new PriorityQueue<>();
		q.add(new Town(start,0));
		dist[start] = 0;
		boolean[] visited = new boolean[n+1];
		
		while(!q.isEmpty()) {
			Town cur = q.poll();
			
			if(visited[cur.node]) 
				continue;
			visited[cur.node]=true;

			for(Town t : list[cur.node]) {
				if(!visited[t.node] && dist[t.node] > dist[cur.node] + t.time) {
					dist[t.node] = dist[cur.node] + t.time;
					q.add(new Town(t.node,dist[t.node]));
				}
			}
		}
	}

}
class Town implements Comparable<Town>{
	int node;
	int time;
	
	Town(int node, int time){
		this.node = node;
		this.time = time;
	}
	
	@Override
    public int compareTo(Town t) {
        return time - t.time;
    }
}
