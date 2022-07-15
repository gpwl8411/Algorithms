package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_1197 {

	static List<Edge> list;
	static int[] parent;
	public static void main(String[] args) throws Exception{
		// 최소 스패닝 트리 - 기본 크루스칼
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		list = new ArrayList<>();
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(a,b,c));
		}
		
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		Collections.sort(list);
		int ans = 0;
		for(Edge e : list) {
			if(find(e.a) != find(e.b)) {
				union(e.a,e.b);
				ans+=e.cost;
			}
		}
		System.out.println(ans);
	}
	static int find(int a) {
		if (parent[a] == a) {
			return parent[a];
		}
		return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

}
class Edge implements Comparable<Edge> {
	int a;
	int b;
	int cost;
	
	Edge(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	
	public int compareTo(Edge e) {
		return cost - e.cost;
	}
}
