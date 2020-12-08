package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_1707 {
	static char[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// bfs 이분 그래프
//		1
//		4 3
//		1 4
//		3 4
//		2 3

//		1
//		5 5
//		1 2
//		3 2
//		3 4
//		4 5
//		3 5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			String ans = "";
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			visited = new char[v + 1];
			Arrays.fill(visited, ' ');
			List<Integer>[] list = new List[v + 1];
			for (int j = 1; j < list.length; j++) {
				list[j] = new ArrayList<>();
			}
			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}
			boolean first = true;
			for (int j = 1; j <= v; j++) {

				if (visited[j] == ' ') {
					if (first) {
						visited[j] = 'R';
						first = false;
					}
					ans = bfs(list, j);
				}

				if (ans.equals("NO"))
					break;
			}
			System.out.println(ans);
		}
	}

	static String bfs(List<Integer>[] list, int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			int v = q.poll();

			for (int e : list[v]) {
				if (visited[e] == ' ') {
					q.add(e);
					visited[e] = visited[v] == 'R' ? 'B' : 'R';
				} else {
					if (visited[e] == visited[v]) {
						return "NO";
					}
				}
			}

		}
		return "YES";

	}

}
