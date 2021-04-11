package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_2573 {

	static int[][] map, copyMap;
	static boolean[][] visited;
	static int r, c, time;
	static Queue<Pair4> searchQ = new LinkedList<>();
	static Queue<Pair4> checkQ = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 그래프 탐색 빙산

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		time = 0;
		int cnt = 0;
		map = new int[r][c];
		copyMap = new int[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copyMap[i][j] = map[i][j];
				if (map[i][j] > 0)
					searchQ.add(new Pair4(i, j));
			}
		}

		int flag = 0;
		do {
			for (int i = 0; i < r; i++) {
				Arrays.fill(visited[i], false);
			}
			checkQ.isEmpty();
			bfs();
			copy();
			time++;
			cnt = 0;
			if (checkQ.isEmpty()) {
				flag = -1;
				break;
			}
			while (!checkQ.isEmpty()) {
				Pair4 p = checkQ.poll();
				searchQ.add(p);
				if (!visited[p.x][p.y]) {
					check(p);
					cnt++;
				}
			}
		} while (cnt < 2);

		System.out.println(flag == -1 ? 0 : time);
	}

	static void bfs() {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		while (!searchQ.isEmpty()) {
			Pair4 p = searchQ.poll();

			for (int i = 0; i < 4; i++) {
				int sx = p.x + dx[i];
				int sy = p.y + dy[i];

				if (sx < 0 || sy < 0 || sx >= r || sy >= c)
					continue;
				if (map[sx][sy] == 0 && copyMap[p.x][p.y] > 0)
					copyMap[p.x][p.y] -= 1;

			}
			if (copyMap[p.x][p.y] > 0)
				checkQ.add(p);
		}

	}

	static void check(Pair4 p) {

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		Queue<Pair4> q = new LinkedList<>();
		q.add(p);
		while (!q.isEmpty()) {
			Pair4 curP = q.poll();
			visited[curP.x][curP.y] = true;

			for (int i = 0; i < 4; i++) {
				int sx = curP.x + dx[i];
				int sy = curP.y + dy[i];

				if (sx < 0 || sy < 0 || sx >= r || sy >= c)
					continue;
				if (visited[sx][sy]) {
					continue;
				}
				if (map[sx][sy] != 0) {
					visited[sx][sy] = true;
					q.add(new Pair4(sx, sy));
				}

			}
		}

	}

	static void copy() {
		for (int i = 0; i < r; i++) {
			System.arraycopy(copyMap[i], 0, map[i], 0, c);
		}
	}

}

class Pair4 {
	int x;
	int y;

	Pair4(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
