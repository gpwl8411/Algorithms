package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ex_7576 {
	static long g[][];
	static int x;
	static int y;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] str = in.readLine().split(" ");
		y = Integer.parseInt(str[0]);
		x = Integer.parseInt(str[1]);
		g = new long[x][y];
		for (int i = 0; i < x; i++) {
			str = in.readLine().split(" ");
			for (int j = 0; j < y; j++) {
				g[i][j] = Integer.parseInt(str[j]);
			}
		}

		bfs();
	}

	public static void bfs() {
		int max = 0;
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		int tempx;
		int tempy;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (g[i][j] == 1) {
					qx.offer(i);
					qy.offer(j);

				}

			}
		}
		while (!qx.isEmpty()) {
			tempx = qx.poll();
			tempy = qy.poll();
			for (int k = 0; k < 4; k++) {
				int sx = tempx + dx[k];
				int sy = tempy + dy[k];
				if (sx < 0 || sx >= x || sy < 0 || sy >= y) {
					continue;
				}
				if (g[sx][sy] != 0) {
					continue;
				}
				qx.offer(sx);
				qy.offer(sy);
				g[sx][sy] = g[tempx][tempy] + 1;
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (g[i][j] == 0) {
					System.out.println("-1");
					return;

				}
				max = (int) Math.max(g[i][j], max);

			}
		}
		System.out.println(max-1);
		return;

	}

}
