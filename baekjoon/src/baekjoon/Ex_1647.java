package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_1647 {

	static List<Node>[] list;
	static boolean[] visited;
	static int ans = 0;
	static int n;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 최소스패닝 트리 - 도시 분할 계획
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new List[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++)
			list[i] = new ArrayList<>();

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, w));
			list[b].add(new Node(a, w));
		}
		mts();
		System.out.println(ans-max);
	}

	static void mts() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Queue<Integer> nodeQ = new LinkedList<>();
		nodeQ.add(1);
		List<Node> curList;

		while (!nodeQ.isEmpty()) {
			int cur = nodeQ.poll();
			visited[cur] = true;
			curList = list[cur];
			for (int i = 0; i < curList.size(); i++) {
				if (!visited[curList.get(i).end]) {
					pq.add(curList.get(i));
				}
			}
			while (!pq.isEmpty()) {
				Node tmpNode = pq.poll();
				if (!visited[tmpNode.end]) {
					visited[tmpNode.end] = true;
					ans += tmpNode.w;
					max = Math.max(tmpNode.w, max);
					nodeQ.add(tmpNode.end);
					break;
				}
			}
		}

	}

	static class Node implements Comparable<Node> {
		int end;
		int w;

		Node(int end, int w) {
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node n) {
			return w - n.w;
		}
	}

}
