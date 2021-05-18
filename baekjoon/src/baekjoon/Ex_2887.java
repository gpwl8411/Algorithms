package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex_2887 {

	static int[] root;
	static Planet[] planet;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 최소 스패닝 트리 - 행성 터널
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		planet = new Planet[n];
		root = new int[n];
		for (int i = 0; i < n; i++)
			root[i] = i;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planet[i] = new Planet(i, x, y, z);
		}

		ArrayList<Edge> edges = new ArrayList<>();

		// X 좌표 정렬
		Arrays.sort(planet, (p1, p2) -> p1.x - p2.x);
		for (int i = 0; i < n-1 ; i++) {
			int cost = Math.abs(planet[i].x - planet[i + 1].x);

			edges.add(new Edge(planet[i].idx, planet[i + 1].idx, cost));
		}
		// Y
		Arrays.sort(planet, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < n-1; i++) {
			int cost = Math.abs(planet[i].y - planet[i + 1].y);

			edges.add(new Edge(planet[i].idx, planet[i + 1].idx, cost));
		}
		// Z
		Arrays.sort(planet, (p1, p2) -> p1.z - p2.z);
		for (int i = 0; i < n-1 ; i++) {
			int cost = Math.abs(planet[i].z - planet[i + 1].z);

			edges.add(new Edge(planet[i].idx, planet[i + 1].idx, cost));
		}
		Collections.sort(edges);
		
		int result = 0;
		for(int i=0;i<edges.size();i++) {

			Edge edge = edges.get(i);
			int res = find(edge.start,edge.end);
			if(res==1) {
				continue;
			}
				
			make_union(edge.start,edge.end);
			result += edge.cost;
		}

		System.out.println(result);
	}

	static int find(int start, int end) {
		start = parent(start);
		end = parent(end);
		if (start == end)
			return 1;
		else
			return 0;
	}

	static void make_union(int start, int end) {
		start = parent(start);
		end = parent(end);
		if (start < end)
			root[end] = start;
		else
			root[start] = end;

	}

	static int parent(int node) {
		if (root[node] == node)
			return node;
		else
			return root[node] = parent(root[node]);
	}

}

class Edge implements Comparable<Edge> {

	int start, end;
	int cost;

	Edge(int start, int end, int cost) {

		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {

		return cost-o.cost;
	}
}

class Planet {
	int idx;
	int x;
	int y;
	int z;

	Planet(int idx, int x, int y, int z) {
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.z = z;
	}

}
