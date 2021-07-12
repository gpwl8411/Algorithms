package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KakaoIntern21_EscapeMaze {

	static List<Node>[] list;
	static int ans = Integer.MAX_VALUE;
	static List<Integer> trap;
	static List<String>[] visited;
	static boolean[] check = new boolean[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 카카오인턴21 미로 탈출
		int n = 3;
		int start = 1;
		int end = 3;
		int[][] roads = { {1, 2, 2}, {3, 2, 3} };
		int[] traps = { 2};

		trap = Arrays.stream(traps).boxed().collect(Collectors.toList());
		list = new List[n + 1];
		visited = new List[n + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			visited[i] = new ArrayList<>();
		}
		for (int i = 0; i < roads.length; i++) {
			int s = roads[i][0];
			int e = roads[i][1];
			int time = roads[i][2];
			Node node = new Node(s, e, time, true);
			list[s].add(node);
			if (trap.contains(e) || trap.contains(s)) {
				list[e].add(node);
				node = new Node(e, s, time, false);
				list[s].add(node);
				list[e].add(node);
			}
		}
		dijk(start,end);
		System.out.println(ans);
	}

	static void dijk(int start,int end) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, start, 0, true));

		while (!q.isEmpty()) {
			Node node = q.poll();
			int curNode = node.start;
			for (int i = 0; i < 10; i++) {
				if (check[i] != node.trap[i]) {
					check[i] = node.trap[i];
					for (int j = 0; j < list[trap.get(i)].size(); j++) {
						list[trap.get(i)].get(j).chk = list[trap.get(i)].get(j).chk ? false : true;
					}
				}
			}
			if (visit(curNode))
				continue;
			if(curNode==end) {
				ans = Math.min(node.time, ans);
				continue;
			}
			for (int i = 0; i < list[curNode].size(); i++) {
				Node next = list[curNode].get(i);

				if (next.start != curNode || !next.chk)
					continue;
				if(node.time+next.time > ans)
					continue;
				Node nextNode = new Node(next.end, next.end, node.time + next.time, true);
				nextNode.setTrap(check);
				if(trap.contains(next.end)) {
					nextNode.trap[trap.indexOf(next.end)] = nextNode.trap[trap.indexOf(next.end)] ? false : true;
				}
				q.add(nextNode);
			}
		}

	}

	static boolean visit(int cur) {
		StringBuilder sb = new StringBuilder();
		for (boolean b : check)
			sb.append(b);
		if (visited[cur].contains(sb.toString()))
			return true;
		visited[cur].add(sb.toString());
		return false;
	}

	static class Node implements Comparable<Node> {
		int start;
		int end;
		int time;
		boolean chk;
		boolean[] trap = new boolean[10];

		Node(int start, int end, int time, boolean chk) {
			this.start = start;
			this.end = end;
			this.time = time;
			this.chk = chk;
		}

		void setTrap(boolean[] trap) {
			for (int i = 0; i < trap.length; i++)
				this.trap[i] = trap[i];
		}

		@Override
		public int compareTo(Node n) {
			return time - n.time;
		}
	}

}
