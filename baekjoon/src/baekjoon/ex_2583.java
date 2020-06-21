package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ex_2583 {
	static int n;
	static int m;
	static boolean[][] visited;
	static int[][] g;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		String[] str = in.readLine().split(" ");
		m = Integer.parseInt(str[0]);
		n = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		g = new int[m][n];
		visited = new boolean[m][n];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int[] row : g) {
			Arrays.fill(row, 0);
		}
		for (int i = 0; i < k; i++) {
			str = in.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {

					g[y][x] = 1;
				}

			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && g[i][j] == 0) {
					int a = bfs(i, j);
					ans.add(a);
					cnt++;
					// System.out.println(i+","+j);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(cnt);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	public static int bfs(int x, int y) {
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		qx.offer(x);
		qy.offer(y);
		int area = 1;
		visited[x][y] = true;
		while (!qx.isEmpty()) {
			int tempx = qx.poll();
			int tempy = qy.poll();

			for (int k = 0; k < 4; k++) {
				int sx = tempx + dx[k];
				int sy = tempy + dy[k];
				if (sx >= 0 && sx < m && sy >= 0 && sy < n && g[sx][sy] == 0 && !visited[sx][sy]) {
					qx.offer(sx);
					qy.offer(sy);
					area++;
					visited[sx][sy] = true;

				}

			}

		}
		return area;
	}

}
