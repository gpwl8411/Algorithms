package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_1922 {

	static int[] root;
	static List<Edge> list;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 최소 스패닝 트리/네트워크 연결
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		root = new int[n + 1];
		list = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Edge(a, b, c));

		}
		for (int i = 0; i <= n; i++)
			root[i] = i;
		
		Collections.sort(list);
		
		long result = 0;
		for (Edge e : list) {
			int start = e.a;
			int end = e.b;
			int res = find(start, end);
			
			if (res == 1) 
				continue;
			
			union(start, end);
			result += e.c;
		}
		System.out.println(result);

	}

	static int parent(int idx) {
		if (root[idx] == idx)
			return idx;
		return root[idx] = parent(root[idx]);
	}

	static void union(int a, int b) {
		a = parent(a);
		b = parent(b);
		if (a < b)
			root[b] = a;
		else
			root[a] = b;
	}

	static int find(int a, int b) {
		a = parent(a);
		b = parent(b);
		if (a == b)
			return 1;
		else
			return 0;
	}

	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int c;

		Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge e) {
			return c - e.c;
		}
	}

}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int adjMatrix[][];
	private static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		adjMatrix = new int[n+1][n+1];
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st  = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjMatrix[a][b] = c;
			adjMatrix[b][a] = c;
		}
		
		prim4();
		System.out.println(result);
	}
	private static void prim3() {
		int minEdge[] = new int[n+1];
		boolean visited[] = new boolean[n+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		
		for(int c = 1; c <= n; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex= i;
				}
			}
			
			visited[minVertex] = true;
			result += min;
			
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && adjMatrix[minVertex][i] < minEdge[i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		
		}
		
	}
	private static void prim() {
		int minEdge[] = new int[n+1];
		boolean visited[] = new boolean[n+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		for(int c = 1; c <= n; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			result += min;
			visited[minVertex] = true;
			
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		
	}

	private static void prim1() {
		int minEdge[] = new int[n+1];
		boolean visited[] = new boolean[n+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		for(int c = 0; c < n; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			result += min;
			visited[minVertex] = true;
			
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i])
					minEdge[i] = adjMatrix[minVertex][i];
			}
		}
	}

	private static void prim2() {
		int minEdge[] = new int[n+1];
		boolean visited[] = new boolean[n+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		for(int c = 1; c <= n; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			result += min;
			visited[minVertex] = true;
			
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && adjMatrix[minVertex][i] < minEdge[i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
			
		}
	}

	private static void prim4() {
		int minEdge[] = new int[n+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		boolean visited[] = new boolean[n+1];
		for(int c = 1; c <= n; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int i = 1; i <=n; i++) {
				if(min > minEdge[i] && !visited[i]) {
					min = minEdge[i];
					minVertex = i;
				}
				
			}
			result += min;
			visited[minVertex] = true;
			for(int i = 1; i <= n; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && adjMatrix[minVertex][i] < minEdge[i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		
	}
} 
 */
