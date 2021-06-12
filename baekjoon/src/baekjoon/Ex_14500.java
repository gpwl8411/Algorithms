package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_14500 {

	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };// 동남서북
	static int[] dy = { 1, 0, -1, 0 };
	static int n, m, ans;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 삼성 sw역량 테스트-테트로미노
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j]=true;
				dfs(i, j, map[i][j], 1);
				visited[i][j]=false;
				search(i, j);
			}
		}
		System.out.println(ans);
	}

	// ㅗ , ㅜ , ㅓ , ㅏ따로 구현
	static void search(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int sum = map[x][y];
			for (int j = i; j < i + 3; j++) {
				int sx = x + dx[j % 4];
				int sy = y + dy[j % 4];

				if (sx < 0 || sy < 0 || sx >= n || sy >= m)
					break;
				sum += map[sx][sy];
				if (j == i + 2)
					ans = Math.max(ans, sum);
			}
		}
	}

	static void dfs(int x, int y, int sum, int cnt) {

		if (cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int sx = x + dx[i];
			int sy = y + dy[i];

			if (sx < 0 || sy < 0 || sx >= n || sy >= m)
				continue;
			if (!visited[sx][sy]) {
				visited[sx][sy] = true;
				dfs(sx, sy, sum + map[sx][sy], cnt + 1);
				visited[sx][sy] = false;
			}

		}
	}

}
