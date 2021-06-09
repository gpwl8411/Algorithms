package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_13460 {

	static int n, m;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 삼성 sw역량 테스트-구슬탈출 2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m][n][m];
		Pair red = null;
		Pair blue = null;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					red = new Pair(i, j, 0);
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					blue = new Pair(i, j, 0);
					map[i][j] = '.';
				}
			}
		}
		System.out.println(bfs(red, blue));
	}

	static int bfs(Pair red, Pair blue) {
		Queue<Pair> redQ = new LinkedList<>();
		Queue<Pair> blueQ = new LinkedList<>();
		redQ.add(red);
		blueQ.add(blue);

		while (!redQ.isEmpty() && !blueQ.isEmpty()) {
			Pair curR = redQ.poll();
			Pair curB = blueQ.poll();
			if (curR.time+1 > 10)
				return -1;
			for (int i = 0; i < 4; i++) {
				int rx = curR.x;
				int ry = curR.y;
				int bx = curB.x;
				int by = curB.y;
				boolean flag = false;// 이동방향에 빨간색 구슬이 있을경우
				boolean oFlag = false;// 파란구슬이 구멍에 빠질경우
				visited[rx][ry][bx][by] = true;
				while (true) {
					bx += dx[i];
					by += dy[i];
					if (bx == rx && by == ry) {
						flag = true;
						break;
					}
					if (map[bx][by] == '#') {
						bx -= dx[i];
						by -= dy[i];
						break;
					}
					if (map[bx][by] == 'O') {
						oFlag = true;
						break;
					}
				}
				while (!oFlag) {
					rx += dx[i];
					ry += dy[i];
					if (rx == bx && ry == by) {
						if (!visited[rx - dx[i]][ry - dy[i]][bx][by]) {
							redQ.add(new Pair(rx - dx[i], ry - dy[i], curR.time + 1));
							blueQ.add(new Pair(bx, by, curB.time + 1));
						}
						break;
					}
					if (map[rx][ry] == '#') {
						if (!visited[rx - dx[i]][ry - dy[i]][bx][by]) {
							redQ.add(new Pair(rx - dx[i], ry - dy[i], curR.time + 1));
							if (flag)
								blueQ.add(new Pair(rx - dx[i] - dx[i], ry - dy[i] - dy[i], curR.time + 1));
							else
								blueQ.add(new Pair(bx, by, curB.time + 1));
						}
						break;
					}
					if (map[rx][ry] == 'O') {
						if (oFlag || flag) {
							break;
						}
						return curR.time + 1;
					}
				}
			}
		}
		return -1;
	}

	static class Pair {
		int x;
		int y;
		int time;

		Pair(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

}
