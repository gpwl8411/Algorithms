package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_2887 {

	static int[] root;
	static List<Planet> list;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 최소 스패닝 트리 - 물대기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] dist = new int[n + 1][3];
		list = new ArrayList<Planet>();
		root = new int[n + 1];
		for (int i = 1; i <= n; i++)
			root[i] = i;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			dist[i][0] = x;
			dist[i][1] = y;
			dist[i][2] = z;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = i+1; j <= n; j++) {
				int val = Math.min(Math.abs(dist[i][0] - dist[j][0]),
						Math.min(Math.abs(dist[i][1] - dist[j][1]), Math.abs(dist[i][2] - dist[j][2])));
				list.add(new Planet(i, j, val));

			}
		}
		Collections.sort(list);

		int cnt = 0;
		long result = 0;
		while (cnt < list.size()) {
			int start = list.get(cnt).start;
			int end = list.get(cnt).end;
			int res = find(start, end);
			if (res == 1) {
				cnt++;
				continue;
			}
			make_union(start, end);
			result += list.get(cnt).val;
			cnt++;
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

class Planet implements Comparable<Planet> {
	int start;
	int end;
	int val;

	Planet(int start, int end, int val) {
		this.start = start;
		this.end = end;
		this.val = val;
	}

	@Override
	public int compareTo(Planet o) {
		return Integer.compare(this.val, o.val);
	}
}
