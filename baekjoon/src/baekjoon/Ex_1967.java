package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_1967 {

	static boolean[] visited;
	static List<NodeW>[] list;
	static int ans=0;
	static int maxNode=0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//그래프탐색 트리의 지름
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		list = new List[n+1];
		visited = new boolean[n+1];
	
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[node1].add(new NodeW(node2,weight));
			list[node2].add(new NodeW(node1,weight));
	
		}
//		for(int i=n;i>0;i--) {
			dfs(1,0);
				Arrays.fill(visited, false);
			dfs(maxNode,0);
//		}
		System.out.println(ans);
		
	}
	static void dfs(int node,int weight) {
		visited[node]=true;
		if(ans < weight) {
			ans = weight;
			maxNode = node;
		}
		for(NodeW n : list[node]) {
			
//			if(visited[start][n.node] || visited[n.node][start]
			if(visited[n.node]) {
				continue;
			}
//			visited[start][n.node]=true;
//			visited[n.node][start]=true;
//			visited[node][n.node]=true;
//			visited[n.node][node]=true;
			visited[n.node]=true;
			dfs(n.node,n.weight+weight);
		}
		
	}

}
class NodeW{
	int node;
	int weight;
	NodeW(int node,int weight){
		this.node = node;
		this.weight = weight;
	}
}
//public class Main {
//	static ArrayList<Node>list[] ;
//	static int n;
//	static int max = 0;
//	static boolean visited[];
//	static int max_idx = 0;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		
//		n = Integer.parseInt(br.readLine());
//		
//		
//		list = new ArrayList[n+1];
//		
//		for(int i=0; i<=n; i++) {
//			list[i] = new ArrayList<>();
//		}
//		
//		
//		
//		
//		for(int i=0; i<n-1; i++) {
//			String [] t = br.readLine().split(" ");
//			int parent = Integer.parseInt(t[0]);
//			int child = Integer.parseInt(t[1]);
//			int weight = Integer.parseInt(t[2]);
//			list[parent].add(new Node(child,weight));
//			list[child].add(new Node(parent,weight));
//		}
//		
//		visited = new boolean[n+1];
//		visited[1] = true;
//		dfs(1,0);
//		
//		
//		visited = new boolean[n+1];
//		visited[max_idx] = true;
//		dfs(max_idx,0);
//		System.out.println(max);
//		
//	}
//	public static void dfs(int idx, int cnt) {
//		
//		if(max < cnt) {
//			max = cnt;
//			max_idx = idx;
//		}
//		
//		
//		
//		for(Node a : list[idx]) {
//			if(!visited[a.idx]) {
//				visited[a.idx] = true;
//				dfs(a.idx, cnt+a.cnt);
//			}
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//}
//class Node{
//	int idx,cnt;
//	Node(int idx, int cnt){
//		this.idx = idx;
//		this.cnt = cnt;
//	}
//}