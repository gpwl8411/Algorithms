package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex_16234 {

	static int n;
	static int[][] map;
	static int[][] copy;
	static boolean[][] visited;
	static int l;
	static int r;
	static int union = 0;

	static boolean flag = false;

	public static void main(String[] armaps) throws IOException {
		// TODO Auto-mapenerated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		l = Integer.parseInt(str[1]);
		r = Integer.parseInt(str[2]);

		map = new int[n][n];
		visited = new boolean[n][n];
		copy = new int[n][n];
		int mcnt = 0;
		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < str.length; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		while (true) {

			if (flag)
				break;
			flag = true;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] != true) {
						bfs(new Country(i, j));
//						System.out.println("=======" + mcnt);
					}

				}
			}
			mcnt++;

			for (int i = 0; i < n; i++) {
					Arrays.fill(visited[i], false);
			}
		}

		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[0].length; j++) {
//				System.out.print(map[i][j]);
//				System.out.println(visited[i][j]);
			}
		}
		System.out.println(mcnt-1);

	}

	public static void move(int sum, int cnt) {

		flag = false;
//		System.out.println(sum);
//		System.out.println(cnt);
		int avg = sum / cnt;
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[0].length; j++) {
				if (copy[i][j] == union) {
					map[i][j] = avg;
				}
			}
		}

	}

	public static void bfs(Country c) {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int sum = 0;
		int cnt = 0;
		union++;
		Queue<Country> q = new LinkedList<>();
		q.add(c);
		sum += map[c.x][c.y];
		cnt++; //가나다라마바사

		while (!q.isEmpty()) {

			Country tmp = q.poll();
			visited[tmp.x][tmp.y] = true;
			copy[tmp.x][tmp.y] = union;

			for (int i = 0; i < 4; i++) {
				int sx = tmp.x + dx[i];
				int sy = tmp.y + dy[i];

				if (sx < 0 || sx >= n || sy < 0 || sy >= n) {
					continue;
				}
				int diff = Math.abs(map[tmp.x][tmp.y] - map[sx][sy]);
				if ((diff < l || diff > r) || visited[sx][sy] == true) {
					continue;
				}
				q.add(new Country(sx, sy));
				visited[sx][sy] = true;
				copy[sx][sy] = union;
				sum += map[sx][sy];
				cnt++;
			}

		}
		if (cnt == 1)
			return;
		move(sum, cnt);
		return;

	}

}

class Country {
	int x;
	int y;
	int cnt;

	Country(int x, int y) {
		this.x = x;
		this.y = y;

	}
}
