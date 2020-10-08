package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_16929 {

	static String[][] map;
	static boolean[][] visited;
	static boolean flag;

	public static void main(String[] args) throws Exception {

		// 그래프, dfs, two Dots
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new String[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = str[j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(i, j, i, j,1);
				if (flag) {
					System.out.println("Yes");
					return;
				}
				for (int r = 0; r < n; r++) {
					Arrays.fill(visited[r], false);
				}
			}

		}
		System.out.println("No");
	}

	static void dfs(int r, int c, int startR, int startC,int cnt) {

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		
		if (r - 1 == startR && c == startC && cnt >3) {
			flag = true;
			return;
		}
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int sx = r + dx[i];
			int sy = c + dy[i];

			if (sx < 0 || sy < 0 || sx >= map.length || sy >= map[0].length)
				continue;
			if (map[startR][startC].equals(map[sx][sy]) && !visited[sx][sy] && !(sx== startR && sy== startC)) {
				dfs(sx, sy, startR, startC,cnt+1);
			}
		}

		return;
	}

}
