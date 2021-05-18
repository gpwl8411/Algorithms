package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_10423 {

	static int[] root;
	static List<City> city;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 최소 스패닝 트리 - 전기가 부족해
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		root = new int[n + 1];
		city = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			root[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int idx = Integer.parseInt(st.nextToken());
			root[idx] = -1;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			city.add(new City(start, end, weight));
		}
		Collections.sort(city);
		int result = 0;
		for (int i = 0; i < city.size(); i++) {
			City c = city.get(i);
			if (find(c.start, c.end))
				continue;
			makeUnion(c.start, c.end);
			result += c.weight;
			if (isAllConnect()) {
				break;
			}
		}
		System.out.println(result);
	}

	static boolean isAllConnect() {
		for (int i = 0; i < root.length; i++) {
			if (root[i] != -1)
				return false;
		}
		return true;
	}

	static int parent(int node) {
		if (root[node] == node)
			return node;
		if (root[node] == -1)
			return -1;
		else
			return root[node] = parent(root[node]);
	}

	static boolean find(int start, int end) {
		start = parent(start);
		end = parent(end);
		if (start == end)
			return true;
		else
			return false;
	}

	static void makeUnion(int start, int end) {
		start = parent(start);
		end = parent(end);

		if(start < end)
			root[end] = start;
		else 
			root[start] = end;
	}
}

class City implements Comparable<City> {
	int start;
	int end;
	int weight;

	City(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(City o) {
		return weight - o.weight;
	}
}
