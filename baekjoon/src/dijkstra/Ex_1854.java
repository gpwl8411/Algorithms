package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex_1854 {

	static List<Edge>[] list;
	static PriorityQueue<Integer>[] dist;
	static int n,k;
	public static void main(String[] args) throws Exception{
		// k번째 최단경로 찾기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dist = new PriorityQueue[n+1];
		list = new List[n+1];
		
		for(int i=1;i<=n;i++) {
			dist[i] = new PriorityQueue<>(Collections.reverseOrder());
			list[i] = new ArrayList<>();
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b,c));
		}
		dijkstra();
		for(int i=1;i<=n;i++) {
			if(dist[i].size() < k) {
				bw.append(-1+"\n");
			}else {
				bw.append(dist[i].peek()+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	static void dijkstra() {
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(1,0));
		dist[1].add(0);
		
		while(!q.isEmpty()) {
			Edge cur = q.poll();
			
			for(Edge next : list[cur.node]) {
				int nextTime = cur.time + next.time;
				
				if(dist[next.node].size() < k) {
					dist[next.node].add(nextTime);
					q.add(new Edge(next.node, nextTime));
					
				}else if(dist[next.node].peek() > nextTime) {
					dist[next.node].poll();
					dist[next.node].add(nextTime);
					q.add(new Edge(next.node, nextTime));
				}
			}
		}
	}

}
class Edge implements Comparable<Edge>{
	int node;
	int time;
	
	Edge(int node, int time) {
		this.node = node;
		this.time = time;
	}
	
	public int compareTo(Edge o) {
		return time - o.time;
	}
}
