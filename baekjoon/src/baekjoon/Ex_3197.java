package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_3197 {
	static char[][] map;
	static int r;
	static int c;
	static int day;
	static Pair[] swan;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		day = 0;
		map = new char[r][c];
		swan = new Pair[2];
		int idx = 0;
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j]=='L') {
					swan[idx++] = new Pair(i, j);
				}
			}
		}
		bfs();
		System.out.println(day);
	}

	static void bfs() {
		
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		Queue<Pair> q = new LinkedList<>();
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j]=='.') {
					q.add(new Pair(i, j));
				}
			}
		}
		while (true) {
//			print();
			day++;
			q.add(swan[0]);
			boolean[][] visited = new boolean[r][c];
			Queue<Pair> nextQ = new LinkedList<>();
			while (!q.isEmpty()) {
				Pair p = q.poll();
				int sx, sy;
				visited[p.x][p.y] = true;
				for (int i = 0; i < 4; i++) {
					sx = p.x + dx[i];
					sy = p.y + dy[i];

					if (sx < 0 || sx >= r || sy < 0 || sy >= c) {
						continue;
					}
					if (sx == swan[1].x && sy == swan[1].y) {
						return;
					}
					if (map[sx][sy]=='.' && !visited[sx][sy]) {
						q.add(new Pair(sx, sy));
					}
					else if(map[sx][sy]=='X') {
						nextQ.add(new Pair(sx,sy));
					}
				}
			}
			while (!nextQ.isEmpty()) {
				Pair p = q.poll();
				int sx, sy;
				for (int i = 0; i < 4; i++) {
					sx = p.x + dx[i];
					sy = p.y + dy[i];

					if (sx < 0 || sx >= r || sy < 0 || sy >= c) {
						continue;
					}
					if (map[sx][sy]=='X') {
						map[sx][sy] = '.';
					}
				}

			}
			
		}
//		bfs();

	}
//	static void print() {
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

}

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
