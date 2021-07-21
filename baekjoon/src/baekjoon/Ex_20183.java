package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex_20183 {

	static List<Node>[] list;
	static int a,b,n;
	static long c;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 다익스트라 골목 대장 호석-효율2-시간초과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Long.parseLong(st.nextToken());
		list = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		List<Integer> dis = new ArrayList<>();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list[s].add(new Node(e, d));
			list[e].add(new Node(s, d));
			if(!dis.contains(d))
				dis.add(d);
		}
		dis.sort(null);
		int l = 0;
		int r = dis.size()-1;
		int ans=-1;
		while(l <= r ) {
			int mid =(l+r)/2;
			if(dijk(dis.get(mid))) {
				ans = dis.get(mid);
				r = mid-1;
			}else {
				l = mid+1;
			}
		}
		System.out.println(ans);
	}
	static boolean dijk(int x) {
		long[] dist = new long[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(a,0));
		dist[a]=0;
		while(!q.isEmpty()){
			Node cur = q.poll();
			if(dist[cur.idx] != cur.dis)
				continue;
			for(Node next : list[cur.idx]) {
				if(next.dis <= x && dist[next.idx] > cur.dis+next.dis) {
					dist[next.idx] = cur.dis+next.dis;
					if(next.idx==b && dist[next.idx] <= c)
						return true;
					q.add(new Node(next.idx,dist[next.idx]));
				}
			}
		}
		return false;
	}

	static class Node implements Comparable<Node> {
		int idx;
		long dis;
		long min;

		Node(int idx, long dis) {
			this.idx = idx;
			this.dis = dis;
		}

		Node(int idx, long dis, long min) {
			this.idx = idx;
			this.dis = dis;
			this.min = min;
		}

		@Override
		public int compareTo(Node n) {
			return dis > n.dis ? 1 : -1;
		}
	}

}
