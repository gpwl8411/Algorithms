package programers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Kakao21_TaxiPrice {
	
	private static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//카카오 블라인드 21 합승 택시요금
		int n=6;
		int s=4;
		int a=6;
		int b=2;
		int[][] fares= {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		
		map = new int[n+1][n+1];
		N=n;
		int ans = 0;
		for(int i=0;i<fares.length;i++) {
			int node1 = fares[i][0];
			int node2 = fares[i][1];
			int weight = fares[i][2];
			
			map[node1][node2]=weight;
			map[node2][node1]=weight;
		}
		
		int[] sdist = dijkstra(s);
		int[] adist = dijkstra(a);
		int[] bdist = dijkstra(b);
		
		//합승 x
		ans = sdist[a]+sdist[b];
		//합승 o
		int sum=INF;
		for(int i=1;i<=N;i++) {
			if(sdist[i]==INF || adist[i]==INF || bdist[i]==INF)
				continue;
			sum = Math.min(sum, sdist[i]+adist[i]+bdist[i]);
		}
		ans = Math.min(ans, sum);
		System.out.println(ans);
	}
	
	static int[] dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(dist, INF);
		dist[start]=0;
		
		q.add(new Node(start,0));
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.weight > dist[node.idx])
				continue;
			for(int i=1;i<=N;i++) {
				if(map[node.idx][i]!=0 && !visited[node.idx]) {
					if(dist[i] > dist[node.idx]+map[node.idx][i]) {
						dist[i]=dist[node.idx]+map[node.idx][i];
						q.add(new Node(i,dist[i]));
					}
				}
			}
			visited[node.idx]=true;
		}
		return dist;
	}
	static class Node implements Comparable<Node>{
		int idx;
		int weight;
		
		Node(int idx,int weight){
			this.idx = idx;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return weight-o.weight;
		}
	}

}
