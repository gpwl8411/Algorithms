package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex_1504 {
	static final int INF = 200000000;
	static List<Node2>[] list;
	static int n1,n2;
	static int[] dist;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int cnt1=0;
		int cnt2=0;
		list = new ArrayList[n+1];
		dist = new int[n+1];
		visited = new boolean[n+1];
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int sNode = Integer.parseInt(st.nextToken());
			int eNode = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[sNode].add(new Node2(eNode,weight));
			list[eNode].add(new Node2(sNode,weight));
		}
		st = new StringTokenizer(br.readLine());
		n1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
		cnt1 += dijkstra(1,n1);
		cnt1 += dijkstra(n1,n2);
		cnt1 += dijkstra(n2,n);
		
		cnt2 += dijkstra(1,n2);
		cnt2 += dijkstra(n2,n1);
		cnt2 += dijkstra(n1,n);
		
		if(cnt1>=INF && cnt2 >= INF)
			System.out.println(-1);
		else
			System.out.println(Math.min(cnt1, cnt2));
		
	}
	static int dijkstra(int start, int end) {
		PriorityQueue<Node2> q = new PriorityQueue<>();
		Arrays.fill(visited, false);
		Arrays.fill(dist,INF);
		q.add(new Node2(start,0));
		dist[start]=0;
		while(!q.isEmpty()) {
			Node2 curNode = q.poll();
			if(visited[curNode.end]) continue;
			visited[curNode.end] = true;
			
			for(int i=0;i<list[curNode.end].size();i++) {
				Node2 nextNode = list[curNode.end].get(i);
				
				if(!visited[nextNode.end] && 
						dist[nextNode.end] > curNode.w+nextNode.w) {
					dist[nextNode.end] = curNode.w+nextNode.w;
				}
				q.add(new Node2(nextNode.end,dist[nextNode.end]));
			}
		}
		return dist[end];
	}
	

}
class Node2 implements Comparable<Node2>{
	int end;
	int w;
	Node2(int end,int w){
		this.end = end;
		this.w = w;
	}
	@Override
	public int compareTo(Node2 o) {
		//오름차순
		return w-o.w;
	}
	
}
