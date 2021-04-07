package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_2637 {

	static List<Node3>[] list;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 위상정렬 장난감조립
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		list = new List[n + 1];
		int[] in = new int[n + 1];
		dp = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Node3>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int inNode = Integer.parseInt(st.nextToken());
			int outNode = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			in[inNode] += 1;
			list[outNode].add(new Node3(inNode, num));
		}
		for (int i = 1; i <= n; i++) {
			if (in[i] == 0) {
				dfs(i);
				bw.append(i + " " + dp[i] + "\n");
			}
		}
		bw.flush();

	}
	static int dfs(int start) {
		int sum = 0;
		if(dp[start]!=0)
			return dp[start];
		
		for(Node3 node : list[start]) {
			if(list[node.node].size()==0)
				sum+=node.num;
			else
				sum+=dfs(node.node)*node.num;
		}
		dp[start] = sum;
		return sum;
	}

}

class Node3 {
	int node;
	int num;

	public Node3(int node, int num) {
		this.node = node;
		this.num = num;
	}
}
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main {
//
//	static int N, M;
//	static int[] indegree, pure;
//	static int[][] cost;
//	static ArrayList<Integer>[] inputs;
//	
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = null;
//		
//		N = Integer.parseInt(br.readLine());
//		M = Integer.parseInt(br.readLine());
//		
//		indegree = new int[N+1];
//		pure = new int[N+1];
//		cost = new int[N+1][N+1];
//		inputs = new ArrayList[N+1];
//		
//		for (int i = 0; i < N+1; i++) {
//			inputs[i] = new ArrayList<>();
//			cost[i][i] = 1;
//		}
//		
//		for (int m = 0; m < M; m++) {
//			st = new StringTokenizer(br.readLine());
//			
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			int c = Integer.parseInt(st.nextToken());
//			inputs[b].add(a);
//			indegree[a]++;
//			cost[a][b] = c;
//		}
//		
//		query();
//		
//		for (int i = 1; i <= N; i++) {
//			if(pure[i] == 1) {
//				System.out.println(i + " " + cost[N][i]);
//			}
//		}
//		
//		br.close();
//	}
//	
//	public static void query() {
//		Queue<Integer> que = new LinkedList<>();
//		for (int i = 1; i <= N; i++) {
//			if(indegree[i] == 0) {
//				pure[i] = 1;
//				que.add(i);
//			}
//		}
//		
//		while(!que.isEmpty()) {
//			int now = que.poll();
//			for (Integer next : inputs[now]) {
//				for (int i = 1; i < N; i++) {
//					if(now == i) continue;
//					cost[next][i] += cost[next][now] * cost[now][i];
//				}
//				indegree[next]--;
//				if(indegree[next] == 0) {
//					que.add(next);
//				}
//			}
//		}
//	}
//	
//}

