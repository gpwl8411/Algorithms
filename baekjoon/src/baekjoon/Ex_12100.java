package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_12100 {

	static int n, ans;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 삼성 sw역량 테스트-2048
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = Integer.MIN_VALUE;
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		play(map, 0);
		System.out.println(ans);
	}

	static void play(int[][] map, int turn) {
		if (turn == 5) {
			return;
		}
		int[][] tmp = new int[n][n];
		for (int i = 0; i < n; i++)
			tmp[i] = map[i].clone();
		for (int i = 0; i < 4; i++) {
			go(map, i,new boolean[n]);
			play(map, turn + 1);
			for(int j=0;j<n;j++)
				map[j] = tmp[j].clone();
		}
	}

	static void go(int[][] map, int dir,boolean[] check) {
		if (dir == 0) {// 동
			for (int x = 0; x < n; x++) {
				Arrays.fill(check, false);
				for (int y = n - 1; y >= 0; y--) {
					ans = Math.max(ans, map[x][y]);
					if(map[x][y]==0)
						continue;
					int sy = y+dy[dir];
					while (sy < n) {
						if (map[x][sy] == map[x][sy-dy[dir]] && !check[sy-dy[dir]] && !check[sy]) {
							map[x][sy] *=2;
							map[x][sy - dy[dir]] = 0;
							check[sy]=true;
						}
						else if (map[x][sy] == 0) {
							map[x][sy] = map[x][sy-dy[dir]];
							map[x][sy - dy[dir]] = 0;
							check[sy] = check[sy-dy[dir]];
						}
						ans = Math.max(ans, map[x][sy]);
						sy += dy[dir];

					}
				}
			}
		} else if (dir == 1) {// 남
			for (int y = 0; y < n ; y++) {
				Arrays.fill(check, false);
				for (int x = n-1; x >= 0; x--) {

					ans = Math.max(ans, map[x][y]);
					if(map[x][y]==0)
						continue;
					int sx = x+dx[dir];
					while (sx < n) {
						if (map[sx][y] == map[sx-dx[dir]][y]&& !check[sx] && !check[sx-dx[dir]]) {
							map[sx][y] *=2;
							map[sx - dx[dir]][y] = 0;
							check[sx] =true;
						}
						else if (map[sx][y] == 0) {
							map[sx][y] = map[sx-dx[dir]][y];
							map[sx-dx[dir]][y] = 0;
							check[sx] = check[sx-dx[dir]];
						}
						ans = Math.max(ans, map[sx][y]);
						sx += dx[dir];

					}
				}
			}
		} else if (dir == 2) {// 서
			for (int x = 0; x < n; x++) {
				Arrays.fill(check, false);
				for (int y = 0; y <n ; y++) {
					ans = Math.max(ans, map[x][y]);
					if(map[x][y]==0)
						continue;
					int sy = y+dy[dir];
					while (sy >= 0) {
						if (map[x][sy] == map[x][sy-dy[dir]]&& !check[sy] && !check[sy-dy[dir]]) {
							map[x][sy] *=2;
							map[x][sy - dy[dir]] = 0;
							check[sy]=true;
						}
						else if (map[x][sy] == 0) {
							map[x][sy] = map[x][sy-dy[dir]];
							map[x][sy - dy[dir]] = 0;
							check[sy] = check[sy-dy[dir]];
						}
						ans = Math.max(ans, map[x][sy]);
						sy += dy[dir];
						
					}
				}
			}
		} else {// 북
			for (int y = 0; y < n ; y++) {
				Arrays.fill(check, false);
				for (int x = 0; x < n ; x++) {
					ans = Math.max(ans, map[x][y]);
					if(map[x][y]==0)
						continue;
					int sx = x+dx[dir];
					while (sx >= 0) {
						if (map[sx][y] == map[sx-dx[dir]][y]&& !check[sx] && !check[sx-dx[dir]]) {
							map[sx][y] *= 2;
							map[sx - dx[dir]][y] = 0;
							check[sx] = true;
						}
						else if (map[sx][y] == 0) {
							map[sx][y] = map[sx-dx[dir]][y];
							map[sx-dx[dir]][y] = 0;
							check[sx] = check[sx-dx[dir]];
						}
						ans = Math.max(ans, map[sx][y]);
						sx += dx[dir];

					}
				}
			}
		}
	}

}
