package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_16118 {

	static final long INF = Long.MAX_VALUE;
	static List<Node>[] list;
	static long[] distF;
	static long[][] distW;
	static int n;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 다익스트라 달빛 여우-부분틀림
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new List[n + 1];
		distF = new long[n + 1];
		distW = new long[2][n+1];
		for (int i = 0; i <= n; i++)
			list[i] = new ArrayList<>();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, d));
			list[b].add(new Node(a, d));
		}
		for (int i = 0; i <= n; i++) {
			distF[i] = INF;
			distW[0][i] =INF;
			distW[1][i] = INF;
		}
		dijkF(1);
		dijkW(1);
		int ans = 0;
		for(int i=0;i<=n;i++) {
			System.out.println(Math.min(distW[1][i], distW[0][i]));
		}
		for (int i = 2; i <= n; i++) {
			if (distF[i] * 2 < Math.min(distW[1][i], distW[0][i])) {
				ans++;
			}
		}
		System.out.println(ans);

	}

	static void dijkF(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		distF[start] = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if(distF[cur.b] < cur.d)
				continue;
			for (int i = 0; i < list[cur.b].size(); i++) {
				Node next = list[cur.b].get(i);
				if (distF[next.b] > distF[cur.b] + next.d) {
					distF[next.b] = distF[cur.b] + next.d;
					q.add(new Node(next.b, distF[next.b]));
				}
			}
		}
	}

	static void dijkW(int start) {
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0, 0));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int odd = 1-cur.odd;
			int cost = cur.odd == 1 ? 4 : 1;
			
			if(distW[cur.odd][cur.b] < cur.d)
				continue;
			for (int i = 0; i < list[cur.b].size(); i++) {
				Node next = list[cur.b].get(i);
				long dist = cur.d+ (next.d*cost);
				if (distW[odd][next.b] > dist) {
					distW[odd][next.b] = dist;
					q.add(new Node(next.b, dist, odd));
				}

			}
		}
	}

	static class Node implements Comparable<Node> {
		int b;
		long d;
		int odd;

		Node(int b, long d) {
			this.b = b;
			this.d = d;
		}

		Node(int b, long d, int odd) {
			this.b = b;
			this.d = d;
			this.odd = odd;
		}

		@Override
		public int compareTo(Node o) {
			return d > o.d ? 1 : -1;
		}
	}

}
